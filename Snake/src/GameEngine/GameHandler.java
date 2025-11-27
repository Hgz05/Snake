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
    int FPS = 10;
    ArrayList<JLabel> loadedGameObjects = new ArrayList<>();
    JPanel currentLevelPanel;

    Snake testSnake;
    KeyHandler keyboardInput = new KeyHandler();


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

        currentLevelPanel = new JPanel();
        currentLevelPanel.setLayout(null);
        currentLevelPanel.setPreferredSize(new Dimension(720,720));
        ArrayList<ArrayList<GameObject>> levelMap = levelArray.get(selectedLevel).getLevelMap();
        for (ArrayList<GameObject> gameObjects : levelMap) {
            for (GameObject gameObject : gameObjects) {
                loadedGameObjects.add(gameObject.paintObject());
                currentLevelPanel.add(gameObject.paintObject());
            }
        }
        testSnake = new Snake(3, true);
        currentLevelPanel.add(testSnake.icon);
        mainFrame.add(currentLevelPanel);
        currentLevelPanel.addKeyListener(keyboardInput);
        currentLevelPanel.setFocusable(true);
        currentLevelPanel.requestFocusInWindow();
        gameThread.start();


    }

    @Override
    public void run() {

        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        testSnake.setPos(Snake.directions.UP);
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / ((double) 1000000000 /FPS);
            lastTime = currentTime;


            if(delta >= 1){

                evaluateKeyBoardInput();
                testSnake.setPos(testSnake.currentlyFacing);
                mainFrame.revalidate();
                mainFrame.repaint();
                mainFrame.pack();
                delta--;

            }
        }



    }

    private void evaluateKeyBoardInput(){

        if(keyboardInput.keyUp){
            testSnake.currentlyFacing = Snake.directions.UP;
        } else if(keyboardInput.keyDown){
            testSnake.currentlyFacing = Snake.directions.DOWN;
        } else if(keyboardInput.keyLeft){
            testSnake.currentlyFacing = Snake.directions.LEFT;
        } else if (keyboardInput.keyRight) {
            testSnake.currentlyFacing = Snake.directions.RIGHT;
        }

    }

}
