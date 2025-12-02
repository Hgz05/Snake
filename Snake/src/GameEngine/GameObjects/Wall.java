package GameEngine.GameObjects;

import GameEngine.GameHandler;
import GameEngine.GameObject;
import GameEngine.Snake;

import javax.swing.*;

public class Wall extends GameObject {

    public Wall(int row, int collumn){
        super(row,collumn);
        gameObject.setIcon(new ImageIcon("res/Wall.png"));

    }

    @Override
    public void interactionBehaviour(Snake playerSnake, GameHandler currentGame) {
        GameHandler.setThreadRunning(false);
    }
}
