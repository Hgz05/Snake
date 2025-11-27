package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameHandler implements Runnable {

    private ArrayList<Level> levelArray;
    JFrame mainFrame;
    Thread gameThread;
    int selectedLevel;
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

        gameThread = new Thread(this);
        selectedLevel = levelToSelect;
        gameThread.start();


    }

    @Override
    public void run() {

        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        JPanel levelPanel = new JPanel();
        levelPanel.setLayout(null);
        levelPanel.setPreferredSize(new Dimension(720,720));
        ArrayList<ArrayList<GameObject>> levelMap = levelArray.get(selectedLevel).getLevelMap();
        for (ArrayList<GameObject> gameObjects : levelMap) {
            for (GameObject gameObject : gameObjects) {
                levelPanel.add(gameObject.paintObject());
            }
        }

        mainFrame.add(levelPanel);
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / (1000000000/60);
            lastTime = currentTime;

            if(delta >= 1){
                mainFrame.revalidate();
                mainFrame.repaint();
                mainFrame.pack();
            }
        }



    }
}
