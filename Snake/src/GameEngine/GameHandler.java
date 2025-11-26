package GameEngine;

import javax.swing.*;
import java.util.ArrayList;

public class GameHandler {

    ArrayList<Level> levelArray;
    JFrame mainFrame;
    public static final int numberOfLevels = 1;

    public void setMainFrame(JFrame Frame){
        mainFrame = Frame;
    }
    public GameHandler(){
        levelArray = new ArrayList<>();
        for (int i = 1; i <= numberOfLevels; i++) {
            Level currentLevel = new Level(i);
            levelArray.add(currentLevel);
        }

    }

    public void runLevel(int levelToSelect){
        mainFrame.revalidate();
        mainFrame.repaint();
    }


}
