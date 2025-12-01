package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;
import java.awt.*;

public class Apple extends GameObject {

    public Apple(int row, int column){
        super(row, column);
        gameObject.setIcon(new ImageIcon("res/Apple.png"));
    }

    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {

        currentGame.setApplesRemain();
        currentGame.removeObject(this);

    }


}
