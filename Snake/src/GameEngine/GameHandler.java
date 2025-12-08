package GameEngine;

import GameEngine.GameObjects.Apple;
import UserInterface.MenuPanel;
import UserInterface.PanelManager;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * This Class handles the game logic and runs the game
 */
public class GameHandler implements Runnable {

    /**
     * The array of loaded levels
     */
    private final ArrayList<Level> levelArray;
    /**
     * The display frame
     */
    PanelManager mainFrame;
    /**
     * The thread which runs the game
     */
    Thread gameThread;
    /**
     * Boolean confirming the thread status
     */
    static boolean threadRunning;

    /**
     * The id of the selected level
     */
    int selectedLevel;
    /**
     * Number of loadable levels (Dev Feature)
     */
    public static final int numberOfLevels = 3;
    /**
     * Refresh rate which also determines the difficulty
     */
    public static int FPS = 6;
    /**
     * Array of the loaded game objects
     */
    ArrayList<GameObject> loadedGameObjects;
    /**
     * Array that contains the loaded game objects display data
     */
    ArrayList<JLabel> loadedJLabelGameObjects;
    /**
     * Panel which displays the level
     */
    JPanel currentLevelPanel;

    /**
     * The player snake
     */
    static Snake playerSnake;
    /**
     * The array of the player snake and it's parts
     */
    static ArrayList<Snake> snakeArray;
    /**
     * A boolean which indicates the border game rule
     */
    public static boolean isBorderOff = false;
    /**
     * Apple counter
     */
    int applesRemain = 0;
    /**
     * KeyHandler for the input handling (runs on the main thread)
     */
    KeyHandler keyboardInput = new KeyHandler();


    /**
     * @param Frame Sets the main display frame
     */
    public void setMainFrame(PanelManager Frame){
        mainFrame = Frame;
    }

    /**
     * Reads the levels from file and stores them in the levelArray
     */
    public GameHandler(){
        levelArray = new ArrayList<>();
        for (int i = 1; i <= numberOfLevels; i++) {
            Level currentLevel = new Level(i);
            levelArray.add(currentLevel);
        }

    }

    /**
     * @param levelToSelect the id of the selected level
     *                      This function will prepare the game startup and will load the game objects, evaluate game rules and start the game thread
     */
    public void runLevel(int levelToSelect){

        gameThread = new Thread(this);
        loadedGameObjects = new ArrayList<>();
        loadedJLabelGameObjects = new ArrayList<>();
        snakeArray = new ArrayList<>();
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
        playerSnake = new Snake(30, isBorderOff);
        snakeArray.add(playerSnake);
        currentLevelPanel.add(playerSnake.icon);
        mainFrame.add(currentLevelPanel);
        currentLevelPanel.addKeyListener(keyboardInput);
        currentLevelPanel.setFocusable(true);
        currentLevelPanel.requestFocusInWindow();
        gameThread.start();


    }

    /**
     * The Game loop runner function
     * This function maintains the game loop and handle game events
     * If the game is finished by some reason it will handle the ending by two outcomes
     * If the game is won the player name and the time will be written int the level record date according to the level id and the player is returned into the main menu
     * If the game is lost the thread will be simply aborted and the player will return int the main menu
     */
    @Override
    public void run() {
        threadRunning = true;
        double delta = 0;
        long startingTime = System.nanoTime();
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
                if(applesRemain == 0){
                    int compleationTime =(int)((currentTime - startingTime) / 1000000000);
                    threadRunning = false;
                    //Write stats back to leaderboards
                    addRecord(compleationTime);
                }
                delta = 0;

            }
        }

        //Game Ended
        mainFrame.remove(currentLevelPanel);
        mainFrame.add(mainFrame.setCurrentPanel(new MenuPanel(mainFrame)));
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.pack();


    }

    /**
     * @return Return the player snake
     */
    public static Snake getCurrentSnake(){

        return playerSnake;

    }

    /**
     * Checks for player collision and handles the collided GameObject interaction
     */
    private void collisionCheck(){

        //Exception if object deleted
        for (GameObject currentObject : loadedGameObjects) {
            if (currentObject.comparePosition(playerSnake.posColumn, playerSnake.posRow)) {

                currentObject.interactionBehaviour(playerSnake, this);
                break;
            }

        }

    }

    /**
     * Lowers the apple counter
     */
    public void setApplesRemain(){
        applesRemain--;
    }

    /**
     * @param objectToRemove Removes the selected from the storage arrays and from the display
     */
    public void removeObject(GameObject objectToRemove){

        currentLevelPanel.remove(objectToRemove.paintObject());
        loadedJLabelGameObjects.remove(objectToRemove.paintObject());
        loadedGameObjects.remove(objectToRemove);

    }

    /**
     * Adds a part to the current snake and updates the snake array
     */
    public void addSnakeBody(){
        Snake bodyToAdd = new SnakeBody(snakeArray.getLast());
        snakeArray.add(bodyToAdd);
        currentLevelPanel.add(bodyToAdd.icon);
    }

    /**
     * @param time The record time in seconds which will be added to the record file of the current level
     */
    public void addRecord(int time){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/LevelRankings/Level"+(selectedLevel+1)+".dat", true));
            bw.write(PanelManager.playerName + ";" + time + "\n");
            bw.close();

        } catch (Exception e){}

    }


    /**
     * @param bool The boolean value which the tread thread will be set
     */
    public static void setThreadRunning(boolean bool){
        threadRunning = bool;
    }

    /**
     * @return Returns the currently loaded game objects
     */
    public ArrayList<GameObject> getLoadedGameObjects(){
        return loadedGameObjects;
    }

    /**
     * @return Returns the snake array which contains the parts of the snake
     */
    public ArrayList<Snake> getSnakeArray(){
        return snakeArray;
    }


}
