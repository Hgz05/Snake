package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameHandler {

    private ArrayList<Level> levelArray;
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

        JPanel levelPanel = new JPanel();
        levelPanel.setLayout(null);
        levelPanel.setPreferredSize(new Dimension(720,720));
        ArrayList<ArrayList<GameObject>> levelMap = levelArray.get(levelToSelect).getLevelMap();
        for(int i = 0; i< levelMap.size(); i++){
            for(int j = 0; j<levelMap.get(i).size(); j++){
                levelPanel.add(levelMap.get(i).get(j).paintObject());
            }
        }
        mainFrame.add(levelPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.pack();
    }
}
