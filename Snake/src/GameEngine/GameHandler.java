package GameEngine;

import GameEngine.GameObjects.Apple;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameHandler implements Runnable {

    private ArrayList<Level> levelArray;
    JFrame mainFrame;
    Thread gameThread;
    static boolean threadRunning;

    int selectedLevel;
    public static final int numberOfLevels = 2; //Change later
    int FPS = 6;
    ArrayList<GameObject> loadedGameObjects = new ArrayList<>();
    ArrayList<JLabel> loadedJLabelGameObjects = new ArrayList<>();
    JPanel currentLevelPanel;

    static Snake playerSnake;
    static ArrayList<Snake> snakeArray = new ArrayList<>();
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
        playerSnake = new Snake(30, false);
        snakeArray.add(playerSnake);
        currentLevelPanel.add(playerSnake.icon);
        mainFrame.add(currentLevelPanel);
        currentLevelPanel.addKeyListener(keyboardInput);
        currentLevelPanel.setFocusable(true);
        currentLevelPanel.requestFocusInWindow();
        gameThread.start();


    }

    @Override
    public void run() {
        threadRunning = true;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        playerSnake.setPos(Snake.directions.UP);
        while(threadRunning){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / ((double) 1000000000 /FPS);
            lastTime = currentTime;


            if(delta >= 1){
                playerSnake.setPos(playerSnake.currentlyFacing);
                for(int i = 1; i<snakeArray.size(); i++){
                    snakeArray.get(i).setPos(snakeArray.get(i-1).prevFacing);
                    //Snake collided with itself
                    if(snakeArray.get(i).comparePosition(playerSnake.posColumn,playerSnake.posRow)) {
                        threadRunning = false;
                        break;
                    }
                }
                this.collisionCheck();
                mainFrame.revalidate();
                mainFrame.repaint();
                mainFrame.pack();
                if(applesRemain == 0) return;
                delta = 0;

            }
        }

        //Game Ended



    }

    public static Snake getCurrentSnake(){

        return playerSnake;

    }

    private void collisionCheck(){

        //Exception if object deleted
        for (GameObject currentObject : loadedGameObjects) {
            if (currentObject.comparePosition(playerSnake.posColumn, playerSnake.posRow)) {

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

    public void addSnakeBody(){
        Snake bodyToAdd = new SnakeBody(snakeArray.getLast());
        snakeArray.add(bodyToAdd);
        currentLevelPanel.add(bodyToAdd.icon);
    }



}
