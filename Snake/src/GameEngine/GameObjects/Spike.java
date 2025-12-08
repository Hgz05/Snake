package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;

/**
 * Spike GameObject
 */
public class Spike extends GameObject {
    /**
     * Determines if the spike position is up
     */
    boolean isUp;

    /**
     * @param row row position
     * @param column column position
     */
    public Spike(int row, int column){
        super(row, column);
        isUp = false;
        gameObject.setIcon(new ImageIcon("res/SpikeDown.png"));

    }

    /**
     * @param playerSnake the player snake
     * @param currentGame the game handler (currently running game session)
     *                    This function will handle the interaction with the player and it's outcome
     *                    If the snake is on a spike whe a spike gets up the snake will die and the game will end
     */
    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {
        if(isUp){
            GameHandler.setThreadRunning(false);
        }
    }

    /**
     * @param currentGame current game session
     *                    Sets the spike position to it's opposite
     */
    public void setSpike(GameHandler currentGame){
        if(!isUp){
            isUp = true;
            gameObject.setIcon(new ImageIcon("res/SpikeUp.png"));
            for(int i = 1; i<currentGame.getSnakeArray().size(); i++){
                if(currentGame.getSnakeArray().get(i).comparePosition(posColumn,posRow)){
                    currentGame.setThreadRunning(false);
                }
            }


        } else if(isUp){
            isUp = false;
            gameObject.setIcon(new ImageIcon("res/SpikeDown.png"));
        }

    }

}
