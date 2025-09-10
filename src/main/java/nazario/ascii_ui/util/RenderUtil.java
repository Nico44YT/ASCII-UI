package nazario.ascii_ui.util;

import javax.swing.*;

public class RenderUtil {

    /**
     *
     * @param length Length of the spacer,
     * @param s The character of the spacer, as a String,
     * @return Returns the spacer.
     */
    public static String repeatString(int length, String s) {
        String r = "";
        for(int i = 0;i<length;i++) {
            r += s;
        }

        return r;
    }

    public static String replaceWithLength(String string, int index, String replacement) {
        String newString = "";

        for(int i = 0;i<string.length();i++) {
            if(i == index) {
                newString += replacement;

                i += replacement.length() - 1;

                continue;
            }

            newString += string.charAt(i);
        }

        return newString;
    }

    public static String replaceCharAt(String string, int index, String character) {
        String newString = "";

        for(int i = 0;i<string.length();i++) {
            if(i != index) newString+=string.charAt(i);
            else newString+=character;
        }

        return newString;
    }

    public static String renderStringArray(String[] line) {
        String finalString = "";

        for (int i = 0; i < line.length; i++) {
            finalString += line[i];

            if(i < line.length-1) finalString += "\n";
        }

        return finalString;
    }

    public static void renderStringArrays(String[][] arrays) {
        String finalString = "";

        for(int i = 0; i < arrays[0].length; i++) {
            String tempString = "";

            for(int j = 0; j < arrays.length; j++) {
                tempString += arrays[j][i];
            }

            finalString += tempString;
        }
        System.out.print(finalString);
    }

    public static void renderStringArray(JTextArea textArea, String[][] arrays) {
        if (textArea == null || arrays == null) {
            return;
        }

        String finalString = "";

        for(int i = 0;i<arrays[0].length;i++) {
            String tempString = "";

            for(int j = 0;j<arrays.length;j++) {
                tempString += arrays[j][i];
            }

            finalString += tempString + "\n";
        }

        textArea.setText(finalString);
    }
}
