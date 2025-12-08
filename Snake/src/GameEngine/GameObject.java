package GameEngine;

import javax.swing.*;
import java.awt.*;

/**
 * This is an abstract class which implements the GameObjects
 */
public abstract class GameObject {
    /**
     * X position in pixels
     */
    int posX;
    /**
     * Y position in pixels
     */
    int posY;
    /**
     * Row position
     */
    protected int posRow;
    /**
     * Column position
     */
    protected int posColumn;
    /**
     * The label which is used for image display
     */
    protected JLabel gameObject;

    /**
     * @param row row position
     * @param column column position
     */
    public GameObject(int row, int column){
        posX = column*30;
        posY = row*30;
        posRow = row;
        posColumn = column;

        gameObject = new JLabel();
        gameObject.setBounds(posX,posY,30,30);
        gameObject.setIcon(new ImageIcon("res/SnakeIcon.png"));

    }

    /**
     * @return This will return the label of this object
     */
    public JLabel paintObject(){
        return gameObject;
    }

    /**
     *@param col column to compare
     * @param row row to compare
     * @return returns the value true if the rows and columns match the current position
     */
    public boolean comparePosition(int col, int row){
        return col == posColumn && row == posRow;
    }


    /**
     * @param playerSnake the player snake
     * @param currentGame the game handler (currently running game session)
     * This function will handle the interaction with the player and it's outcome
     */
    public abstract void interactionBehaviour(Snake playerSnake, GameHandler currentGame);


}
