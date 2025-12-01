package GameEngine;

import javax.swing.*;

public class Snake {
    enum directions{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    directions currentlyFacing = directions.UP;
    directions prevFacing = directions.UP;
    int velocity = 3;
    int posX = 330;
    int posY = 330;
    int posRow = 11;
    int posColumn = 11;
    int prevColumn = 11;
    int prevRow = 11;
    JLabel icon;
    boolean isBorderOff;


    public Snake(int vel, boolean border){

        isBorderOff = border;
        velocity = vel;
        icon = new JLabel();
        icon.setIcon(new ImageIcon("res/SnakeUp.png"));
        icon.setBounds(330,330,30,30);

    }


    public void setIcon(directions dir){

        switch (dir){
            case UP -> icon.setIcon(new ImageIcon("res/SnakeUp.png"));
            case DOWN ->icon.setIcon(new ImageIcon("res/SnakeDown.png"));
            case LEFT ->icon.setIcon(new ImageIcon("res/SnakeLeft.png"));
            case RIGHT ->icon.setIcon(new ImageIcon("res/SnakeRight.png"));
        }

    }

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

    public void setDirection(directions dir){

        currentlyFacing = dir;

    }

    public boolean comparePosition(int col, int row){
        return col == posColumn && row == posRow;
    }

}
