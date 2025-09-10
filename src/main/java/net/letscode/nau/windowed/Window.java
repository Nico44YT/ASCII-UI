package net.letscode.nau.windowed;

import net.letscode.nau.annoted.DoNotUse;
import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.utiled.RenderUtil;
import net.letscode.nau.windowed.component.WComponent;
import net.letscode.nau.windowed.component.interactiable.WSelectableComponent;
import net.letscode.nau.windowed.component.interactiable.WSelector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Window {

    protected int width;
    protected int height;

    protected LanguageProvider languageProvider;

    protected String[] content;
    protected List<WindowProperties> properties;
    protected List<WComponent> componentList = new ArrayList<>();


    public Window(int width, int height) {
        this.width = width;
        this.height = height;
        this.properties = new ArrayList<>();
    }

    public Window(int width, int height, WindowProperties... properties) {
        this.width = width;
        this.height = height;
        this.properties = List.of(properties);
    }

    //region// * Private Methods * //

    /**
     * If you want to add text use a WTextLiteral or WTextTranslatable as a component and add it using addComponent();
     * @param x
     * @param y
     * @param text
     */
    @DoNotUse @Deprecated
    public void legacyTextAdd(int x, int y, String text) {
        String newString = (this.properties.contains(WindowProperties.FRAME)?"║":" ");

        for(int i = 1;((i<content[y].length()-1 && !this.properties.contains(WindowProperties.SHADOW)) || (i<content[y].length()-2 && this.properties.contains(WindowProperties.SHADOW)));i++) {

            if(i == y) {
                for(int j = 0;j<text.length();j++) {
                    if(newString.length() >= width-1) {
                        legacyTextAdd(x-1, y, text.substring(j));
                        break;
                    }
                    newString += text.charAt(j);
                }
            } else if(i >= x+text.length()) {
                newString += content[y].charAt(i);
            } else if(i < x){
                newString += content[y].charAt(i);
            }
        }

        content[y] = newString+(this.properties.contains(WindowProperties.FRAME)?"║":" ")+(this.properties.contains(WindowProperties.SHADOW)?"▒":"");
    }

    /**
     * If you want to add text use a WTextLiteral or WTextTranslatable as a component and add it using addComponent();
     * @param x
     * @param maxX
     * @param y
     * @param text
     */
    @DoNotUse @Deprecated
    public void legacyTextAdd(int x, int maxX, int y, String text) {
        String newString = "║";

        for(int i = 0;((i<content[y].length()-1 && !this.properties.contains(WindowProperties.SHADOW)) || (i<content[y].length()-2 && this.properties.contains(WindowProperties.SHADOW)));i++) {

            if(i == y) {
                for(int j = 0;j<text.length();j++) {
                    if(newString.length() >= maxX) {
                        legacyTextAdd(x, maxX, y, text.substring(j));
                        break;
                    }
                    newString += text.charAt(j);
                }
            } else if(i >= x+text.length()) {
                newString += content[y].charAt(i);
            } else if(i < x){
                newString += content[y].charAt(i);
            }
        }

        content[y] = newString+" ║";

        while(content[y].length() > this.width) {
            String newContentString = RenderUtil.replaceCharAt(content[y], content[y].length(), "");
            content[y] = newContentString;
        }
    }


    /**
     * If you want to add text use a WTextLiteral or WTextTranslatable as a component and add it using addComponent();
     * @param x
     * @param y
     * @param text
     */
    @DoNotUse
    public void addText(int x, int y, String text) {
        String newString = "";

        for(int i = 0;i<content[y].length();i++) {
            if(x == i) {
                for(int j = 0;j<text.length();j++) {
                    newString += text.charAt(j);
                    i++;
                }

                // WHY?! WHY?! WHY?! WITHOUT THIS SINGLE FU**ING LINE IT WON'T WORK PROPERLY?!
                newString += " ";

                continue;
            }
            newString += content[y].charAt(i);
        }

        content[y] = newString;
    }

    @DoNotUse
    public void renderComponents() {
        for(WComponent component : componentList) {
            component.render(this, languageProvider);
        }
    }

    private String[] renderFrame(String[] arr) {

        // ** Unicode Characters :
        // - https://www.grepper.com/answers//?ucard=1
        // - https://en.wikipedia.org/wiki/Box-drawing_characters
        // **

        for(int y = 0;y<height;y++) {
            // * Check for the top * //
            if(y == 0) {
                arr[y] = "╔" + RenderUtil.getSpacer(width-2, "═") + "╗";
                continue;
            }

            // * Check for the bottom * //
            if(y == height-1) {
                arr[y] = "╚" + RenderUtil.getSpacer(width-2, "═") + "╝";
                continue;
            }

            arr[y] = "║" + RenderUtil.getSpacer(width-2, " ")+"║";
        }

        return arr;
    }

    private String[] renderShadow(String[] arr) {
        for(int i = 0;i<height;i++) {
            if(i > 0) arr[i] += "▒";
        }
        arr[height] = " " + RenderUtil.getSpacer(width, "▒");

        return arr;
    }
    //endregion

    //region// * Public Methods * //
    public void init() {
        String[] arr = new String[height];

        if(properties.contains(WindowProperties.SHADOW)) arr = new String[height+1];

        for(int i = 0;i<arr.length;i++) {
            arr[i] = RenderUtil.getSpacer(width, " ");

        }

        if(properties.contains(WindowProperties.FRAME)) renderFrame(arr);

        if(properties.contains(WindowProperties.SHADOW)) renderShadow(arr);

        content = arr;
    }
    //endregion

    //region// * Rendering * //
    public void clear() {
        this.init();
    }

    public String getRenderContent() {
        if(!properties.contains(WindowProperties.NO_COMPONENT_AUTO_RENDER)) renderComponents();

        String finalString = "";
        for(String s : content) {
            finalString += (s+"\n");
        }

        return finalString;
    }
    public void renderComponent(WComponent component) {
        component.render(this, languageProvider);
    }
    //endregion

    //region// * Utility * //
    public String[] getContent() {
        return this.content;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void addHorizontalLine(int y) {
        String text = "";
        for(int i = 0;((i<content[y].length() && !properties.contains(WindowProperties.SHADOW)) || (i<content[y].length()-1 && properties.contains(WindowProperties.SHADOW)));i++) {
            if(i == 0) {
                text += "╠";
                continue;
            }
            if(i == content[y].length() - 1) {
                text += "╣";
                continue;
            }
            if(content[y].charAt(i) == '║') {
                text += "╬";
                continue;
            }

            text += "═";

        }
        content[y] = text;
    }

    public void addVerticalLine(int x) {
        for(int i = 0;i<content.length;i++) {
            if(i == 0) {
                content[i] = RenderUtil.replaceCharAt(content[i], x, "╦");
            } else if(i == content.length-1) {
                content[i] = RenderUtil.replaceCharAt(content[i], x, "╩");
            } else if(content[i].charAt(x) == '═') {
                content[i] = RenderUtil.replaceCharAt(content[i], x, "╬");
            } else {
                content[i] = RenderUtil.replaceCharAt(content[i], x, "║");
            }
        }
    }
    //endregion

    //region// * Properties * //
    public void addProperty(WindowProperties property) {
        this.properties.add(property);
    }

    public void removeProperty(WindowProperties property) {
        this.properties.remove(property);
    }

    public boolean hasProperty(WindowProperties property) {
        return this.properties.contains(property);
    }

    public void addProperty(WindowProperties... properties) {
        this.properties.addAll(Arrays.asList(properties));
    }

    public void removeProperty(WindowProperties... properties) {
        this.properties.removeAll(Arrays.asList(properties));
    }

    public boolean hasProperty(WindowProperties... property) {
        return this.properties.containsAll(List.of(property));
    }

    public List<WindowProperties> getProperties() {
        return properties;
    }
    //endregion

    //region// * Components * //
    public void addComponent(WComponent component) {
        this.componentList.add(component);
    }

    public void replaceComponent(WComponent component) {
        for(WComponent _component : this.componentList) {
            if(_component.getID() == component.getID()) {
                this.componentList.remove(_component);
                break;
            }
        }

        this.componentList.add(component);
    }

    public void addComponent(WComponent[] components) {
        this.componentList.addAll(Arrays.asList(components));
    }

    public void addComponent(WComponent[]... components) {
        for(WComponent[] arr : components) {
            for(WComponent component : arr) {
                this.addComponent(component);
            }
        }
    }

    public void removeComponent(WComponent _component) {
        for(WComponent component : this.componentList) {
            if(component.getID() == _component.getID()) {
                this.componentList.remove(component);
                break;
            }
        }
    }

    public void clearComponents() {
        this.componentList.clear();
    }

    public List<WComponent> getComponents() {
        return this.componentList;
    }

    public List<WComponent> getSelectableComponents() {
        return this.componentList.stream().filter(comp -> {
           if(comp instanceof WSelectableComponent) return true;
           return false;
        }).toList();
    }
    //endregion

    // * Language * //
    public void setLanguageProvider(LanguageProvider languageProvider) {
        this.languageProvider = languageProvider;
    }
}