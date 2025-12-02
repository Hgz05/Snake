package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;

public class Button extends GameObject {


    public Button(int row, int column){
        super(row, column);
        gameObject.setIcon(new ImageIcon("res/Button.png"));

    }

    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {

        for(GameObject currentObject: currentGame.getLoadedGameObjects()){
            if(currentObject.getClass() == Spike.class){
                ((Spike) currentObject).setSpike(currentGame);
            }
        }

    }
}
