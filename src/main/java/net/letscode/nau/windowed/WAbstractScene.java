package net.letscode.nau.windowed;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class WAbstractScene implements KeyListener, MouseListener {
    String title;

    private boolean runnable;

    public WAbstractScene(String title) {
        this.title = title;
    }

    public WAbstractScene() {
        this.title = "";
    }

    public void init() {
        this.runnable = true;

        while(runnable) {
            this.update();
        }
    }

    public void render() {
        try{
            Thread.sleep(20);
        }catch(Exception ignored) {};
    }
    public void update() {
        this.render();
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void stop() {
        this.runnable = false;
        Thread.currentThread().interrupt();
    }
}
