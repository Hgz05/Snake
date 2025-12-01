package GameEngine;

import javax.swing.*;

public class SnakeBody extends Snake {

    Snake prevPart;


    public SnakeBody(int vel, boolean border) {
        super(vel, border);
    }

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

    @Override
    public void setIcon(directions dir) {
        switch (dir){
            case UP, DOWN, LEFT, RIGHT -> icon.setIcon(new ImageIcon("res/SnakeBody.png"));
        }
    }

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
