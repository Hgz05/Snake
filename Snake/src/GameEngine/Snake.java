package GameEngine;

import javax.swing.*;

/**
 * This is the main player class which is used for the game
 */
public class Snake {
    /**
     * Enum for the directions of the player
     */
    enum directions{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**
     * Enum for currently facing direction
     */
    directions currentlyFacing = directions.UP;
    /**
     * Enum for previously facing direction
     */
    directions prevFacing = directions.UP;
    /**
     * How many pixels does the snake move
     */
    int velocity;
    /**
     * X position in pixels
     */
    int posX = 330;
    /**
     * Y position in pixles
     */
    int posY = 330;
    /**
     * The current row position
     */
    int posRow = 11;
    /**
     * The current column position
     */
    int posColumn = 11;
    /**
     * The previous column position
     */
    int prevColumn = 11;
    /**
     * The previous row position
     */
    int prevRow = 11;
    /**
     * Label containing the snake image
     */
    JLabel icon;
    /**
     * This boolean determines if the game rule "border" is on or off
     */
    boolean isBorderOff;


    /**
     * @param vel The velocity that will be set
     * @param border The border game rule setting
     */
    public Snake(int vel, boolean border){

        isBorderOff = border;
        velocity = vel;
        icon = new JLabel();
        icon.setIcon(new ImageIcon("res/SnakeUp.png"));
        icon.setBounds(330,330,30,30);

    }


    /**
     * @param dir Currently facing direction
     * This function sets the image of the snake in the currently facing direction
     */
    public void setIcon(directions dir){

        switch (dir){
            case UP -> icon.setIcon(new ImageIcon("res/SnakeUp.png"));
            case DOWN ->icon.setIcon(new ImageIcon("res/SnakeDown.png"));
            case LEFT ->icon.setIcon(new ImageIcon("res/SnakeLeft.png"));
            case RIGHT ->icon.setIcon(new ImageIcon("res/SnakeRight.png"));
        }

    }

    /**
     * @param dir The direction the snake will be going
     * This function calculates the snake position from velocity and direction and sets it. It moves the Snake.
     */
    public void setPos(directions dir){
        setIcon(dir);
        switch (dir){

            case UP -> {

                if(posY <= 0 && !isBorderOff){

                    GameHandler.threadRunning = false;

                } else if(posY <= 0 && isBorderOff){
                    prevFacing = currentlyFacing;
                    prevColumn = posColumn;
                    prevRow = posRow;
                    posY = 690;
                    posRow = 23;

                } else {
                    prevFacing = currentlyFacing;
                    prevColumn = posColumn;
                    prevRow = posRow;
                    posY -= velocity;
                    posRow--;
                }

            }
            case DOWN -> {

                if(posY >= 690 && !isBorderOff){

                    GameHandler.threadRunning = false;

                } else if(posY >= 690 && isBorderOff){
                    prevFacing = currentlyFacing;
                    prevColumn = posColumn;
                    prevRow = posRow;
                    posY = 0;
                    posRow = 0;

                } else {
                    prevFacing = currentlyFacing;
                    prevColumn = posColumn;
                    prevRow = posRow;
                    posY += velocity;
                    posRow++;
                }

            }
            case LEFT -> {

                if(posX <= 0 && !isBorderOff){

                    GameHandler.threadRunning = false;

                } else if (posX <= 0 && isBorderOff) {
                    prevFacing = currentlyFacing;
                    prevColumn = posColumn;
                    prevRow = posRow;
                    posX = 690;
                    posColumn = 23;

                } else {
                    prevFacing = currentlyFacing;
                    prevColumn = posColumn;
                    prevRow = posRow;
                    posX -= velocity;
                    posColumn--;
                }

            }
            case RIGHT ->{

                if(posX >= 690 && !isBorderOff){

                    GameHandler.threadRunning = false;

                } else if(posX >= 690 && isBorderOff){
                    prevFacing = currentlyFacing;
                    prevColumn = posColumn;
                    prevRow = posRow;
                    posX = 0;
                    posColumn = 0;

                } else {
                    prevFacing = currentlyFacing;
                    prevColumn = posColumn;
                    prevRow = posRow;
                    posX += velocity;
                    posColumn++;
                }

            }

        }
        icon.setBounds(posX,posY,30,30);

    }

    /**
     * @param dir The direction the snake will be facing
     * This sets the direction that the snake is currently facing. It is used in the KeyHandler for handling inputs.
     */
    public void setDirection(directions dir){

        currentlyFacing = dir;

    }

    /**
     * @param col column to compare
     * @param row row to compare
     * @return returns the value true if the rows and columns match the current position
     */
    public boolean comparePosition(int col, int row){
        return col == posColumn && row == posRow;
    }

}
