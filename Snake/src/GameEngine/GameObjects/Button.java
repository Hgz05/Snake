package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;

/**
 * Button GameObject
 */
public class Button extends GameObject {


    /**
     * @param row row position
     * @param column column position
     */
    public Button(int row, int column){
        super(row, column);
        gameObject.setIcon(new ImageIcon("res/Button.png"));

    }

    /**
     * @param playerSnake the player snake
     * @param currentGame the game handler (currently running game session)
     *                    This function will handle the interaction with the player and it's outcome
     *                    If Spike is up snake will die and the game session will end
     */
    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {

        for(GameObject currentObject: currentGame.getLoadedGameObjects()){
            if(currentObject.getClass() == Spike.class){
                ((Spike) currentObject).setSpike(currentGame);
            }
        }

    }
}
