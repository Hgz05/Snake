package GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    boolean keyUp, keyDown, keyRight, keyLeft;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

            if(key == KeyEvent.VK_W || key ==KeyEvent.VK_UP){
                keyUp = true;
            } else if(key == KeyEvent.VK_S || key ==KeyEvent.VK_DOWN){
                keyDown = true;
            } else if(key == KeyEvent.VK_A || key ==KeyEvent.VK_LEFT){
                keyLeft = true;
            } else if(key == KeyEvent.VK_D || key ==KeyEvent.VK_RIGHT){
                keyRight = true;
            }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W || key ==KeyEvent.VK_UP){
            keyUp = false;
        } else if(key == KeyEvent.VK_S || key ==KeyEvent.VK_DOWN){
            keyDown = false;
        } else if(key == KeyEvent.VK_A || key ==KeyEvent.VK_LEFT){
            keyLeft = false;
        } else if(key == KeyEvent.VK_D || key ==KeyEvent.VK_RIGHT){
            keyRight = false;
        }

    }
}
