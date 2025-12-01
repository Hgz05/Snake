package GameEngine;

import javax.swing.*;
import java.awt.*;

public abstract class GameObject {
    int posX;
    int posY;
    int posRow;
    int posColumn;
    protected JLabel gameObject;

    public GameObject(int row, int column){
        posX = column*30;
        posY = row*30;
        posRow = row;
        posColumn = column;

        gameObject = new JLabel();
        gameObject.setBounds(posX,posY,30,30);
        gameObject.setIcon(new ImageIcon("res/SnakeIcon.png"));

    }

    public JLabel paintObject(){
        return gameObject;
    }

    public boolean comparePosition(int col, int row){
        return col == posColumn && row == posRow;
    }


    public abstract void interactionBehaviour(Snake playerSnake, GameHandler currentGame);


}
