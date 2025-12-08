package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;

/**
 * PoisonApple GameObject
 */
public class PoisonApple extends GameObject {

    /**
     * @param row row position
     * @param column column position
     */
    public PoisonApple(int row, int column){
        super(row, column);
        gameObject.setIcon(new ImageIcon("res/PoisonApple.png"));
    }

    /**
     * @param playerSnake the player snake
     * @param currentGame the game handler (currently running game session)
     *                    This function will handle the interaction with the player and it's outcome
     *                    The snake will die and the game will end
     */
    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {
        GameHandler.setThreadRunning(false);
    }
}
