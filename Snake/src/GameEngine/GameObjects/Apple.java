package GameEngine.GameObjects;

import GameEngine.GameObject;

import javax.swing.*;
import java.awt.*;

public class Apple extends GameObject {

    public Apple(int row, int column){
        super(row, column);
        gameObject.setIcon(new ImageIcon("res/Apple.png"));
    }

}
