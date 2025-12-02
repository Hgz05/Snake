package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;

public class Spike extends GameObject {
    boolean isUp;

    public Spike(int row, int column){
        super(row, column);
        isUp = false;
        gameObject.setIcon(new ImageIcon("res/SpikeDown.png"));

    }

    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {
        if(isUp){
            GameHandler.setThreadRunning(false);
        }
    }

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
