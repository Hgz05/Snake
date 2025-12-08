package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;
import java.awt.*;

/**
 * Apple GameObject class
 */
public class Apple extends GameObject {

    /**
     * @param row row position
     * @param column column position
     */
    public Apple(int row, int column){
        super(row, column);
        gameObject.setIcon(new ImageIcon("res/Apple.png"));
    }

    /**
     * @param playerSnake the player snake
     * @param currentGame the game handler (currently running game session)
     *                    This function will handle the interaction with the player and it's outcome
     *                    Decreases the apple counter
     */
    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {

        currentGame.setApplesRemain();
        currentGame.addSnakeBody();
        currentGame.removeObject(this);

    }


}
