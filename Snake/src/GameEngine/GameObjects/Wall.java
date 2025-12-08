package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;

/**
 * Wall GameObject
 */
public class Wall extends GameObject {

    /**
     * @param row row position
     * @param column column position
     */
    public Wall(int row, int column){
        super(row,column);
        gameObject.setIcon(new ImageIcon("res/Wall.png"));

    }

    /**
     * @param playerSnake the player snake
     * @param currentGame the game handler (currently running game session)
     *                    This function will handle the interaction with the player and it's outcome
     *                    If collision happens the snake will die and the game will end
     */
    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {
        GameHandler.setThreadRunning(false);
    }
}
