package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;

public class PoisonApple extends GameObject {

    public PoisonApple(int row, int column){
        super(row, column);
        gameObject.setIcon(new ImageIcon("res/PoisonApple.png"));
    }

    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {
        GameHandler.setThreadRunning(false);
    }
}
