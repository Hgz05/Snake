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
                GameHandler.getCurrentSnake().setDirection(Snake.directions.UP);
            } else if(key == KeyEvent.VK_S || key ==KeyEvent.VK_DOWN){
                GameHandler.getCurrentSnake().setDirection(Snake.directions.DOWN);
            } else if(key == KeyEvent.VK_A || key ==KeyEvent.VK_LEFT){
                GameHandler.getCurrentSnake().setDirection(Snake.directions.LEFT);
            } else if(key == KeyEvent.VK_D || key ==KeyEvent.VK_RIGHT){
                GameHandler.getCurrentSnake().setDirection(Snake.directions.RIGHT);
            }


    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
