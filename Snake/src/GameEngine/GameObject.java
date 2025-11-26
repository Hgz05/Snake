package GameEngine;

import javax.swing.*;
import java.awt.*;

public class GameObject {
    int posX;
    int posY;
    int posRow;
    int posColumn;
    protected JLabel gameObject;

    public GameObject(int row, int column){
        posX = row*30;
        posY = column*30;
        posRow = row;
        posColumn = column;

        gameObject = new JLabel();
        gameObject.setBounds(posX,posY,30,30);

    }

    public JLabel paintObject(){
        return gameObject;
    }

}
