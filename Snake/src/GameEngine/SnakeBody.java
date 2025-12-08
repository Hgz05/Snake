package GameEngine;

import javax.swing.*;

/**
 * This class is a child of the Snake class and it represents a body part of the snake
 */
public class SnakeBody extends Snake {

    /**
     * The previous part of the snake. E.g. the head if "this" is the second part
     */
    Snake prevPart;


    /**
     * @param vel Velocity
     * @param border Border rule
     * This is a default constructor (Not used)
     */
    public SnakeBody(int vel, boolean border) {
        super(vel, border);
    }

    /**
     * @param previousPart The reference to the previous part
     */
    public SnakeBody(Snake previousPart){
        super(previousPart.velocity,previousPart.isBorderOff);
        posX = previousPart.prevColumn*30;
        posY = previousPart.prevRow*30;
        posRow = previousPart.prevRow;
        posColumn = previousPart.prevColumn;
        prevColumn = previousPart.prevColumn;
        prevRow = previousPart.prevRow;
        currentlyFacing = previousPart.prevFacing;
        prevFacing = previousPart.prevFacing;
        icon = null;
        icon = new JLabel();
        icon.setIcon(new ImageIcon("res/SnakeBody.png"));
        icon.setBounds(previousPart.prevColumn*30,previousPart.prevRow*30,30,30);
        prevPart = previousPart;


    }

    /**
     * @param dir Currently facing direction
     * This function sets the image of the snake in the currently facing direction
     */
    @Override
    public void setIcon(directions dir) {
        switch (dir){
            case UP, DOWN, LEFT, RIGHT -> icon.setIcon(new ImageIcon("res/SnakeBody.png"));
        }
    }

    /**
     * @param dir The direction the snake will be going
     * This function will set "this" part's direction to the previous part's direction.
     */
    @Override
    public void setPos(directions dir){
        setIcon(dir);
        prevColumn = posColumn;
        prevRow = posRow;
        currentlyFacing = dir;
        posColumn = prevPart.prevColumn;
        posRow = prevPart.prevRow;
        posX = posColumn * 30;
        posY = posRow * 30;
        icon.setBounds(posX,posY,30,30);
    }
}
