package GameEngine;

import GameEngine.GameObjects.Apple;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameHandler implements Runnable {

    private ArrayList<Level> levelArray;
    JFrame mainFrame;
    Thread gameThread;
    int selectedLevel;
    public static final int numberOfLevels = 2; //Change later
    int FPS = 6;
    ArrayList<GameObject> loadedGameObjects = new ArrayList<>();
    ArrayList<JLabel> loadedJLabelGameObjects = new ArrayList<>();
    JPanel currentLevelPanel;

    static Snake playerSnake;
    int applesRemain = 0;
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
                if(gameObject.getClass() == Apple.class) applesRemain++;
                loadedGameObjects.add(gameObject);
                loadedJLabelGameObjects.add(gameObject.paintObject());
                currentLevelPanel.add(gameObject.paintObject());
            }
        }
        playerSnake = new Snake(30, true);
        currentLevelPanel.add(playerSnake.icon);
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
        playerSnake.setPos(Snake.directions.UP);
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / ((double) 1000000000 /FPS);
            lastTime = currentTime;


            if(delta >= 1){

                playerSnake.setPos(playerSnake.currentlyFacing);
                this.collisionCheck();
                mainFrame.revalidate();
                mainFrame.repaint();
                mainFrame.pack();
                if(applesRemain == 0) return;
                delta = 0;

            }
        }



    }

    public static Snake getCurrentSnake(){

        return playerSnake;

    }

    private void collisionCheck(){

        for (Iterator<GameObject> it = loadedGameObjects.iterator(); it.hasNext();){
            GameObject currentObject = it.next(); //Exception if object deleted

            if(currentObject.comparePosition(playerSnake.posColumn, playerSnake.posRow)){

                currentObject.interactionBehaviour(playerSnake, this);
                break;
            }

        }

    }

    public void setApplesRemain(){
        applesRemain--;
    }

    public void removeObject(GameObject objectToRemove){

        currentLevelPanel.remove(objectToRemove.paintObject());
        loadedJLabelGameObjects.remove(objectToRemove.paintObject());
        loadedGameObjects.remove(objectToRemove);

    }



}
