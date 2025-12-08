package UserInterface;

import GameEngine.GameHandler;

import javax.swing.*;
import java.awt.*;

/**
 * This is the Class that manages all the menus
 */
public class PanelManager extends JFrame {

    /**
     * Current "Panel" menu selected
     */
    private JPanel currentPanel;
    /**
     * The class that handles the game logic
     */
    private GameHandler game;
    /**
     * Name of the player
     */
    public static String playerName;

    /**
     * An enum for storing panel types
     */
    public enum panelTypes{
        MAINMENU,
        LEVELS,
        TUTORIAL,
        RANKINGS
    }

    /**
     * @param currentGame This will be the game
     */
    public PanelManager(GameHandler currentGame){

        game = currentGame;
        this.setSize(720,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setMaximumSize(new Dimension(720,720));
        this.setBackground(Color.white);
        this.setIconImage( new ImageIcon("res/SnakeIcon.png").getImage());
        this.setTitle("Snake");
        currentPanel = new MenuPanel(this);
        this.add(currentPanel);
        this.setVisible(true);
        this.pack();
    }


    /**
     * @return Returns the current menu panel
     */
    public JPanel getCurrentPanel(){
        return currentPanel;
    }

    /**
     * @param panelToChangeTo Gets an enum that will determine which panel does it change to
     */
    public void panelChange(panelTypes panelToChangeTo){
        this.remove(currentPanel);
    switch (panelToChangeTo){

        case MAINMENU -> {
            currentPanel = new MenuPanel(this);
        }
        case LEVELS -> {
            currentPanel = new LevelsPanel(this);
        }
        case TUTORIAL -> {
            currentPanel = new TutorialPanel(this);
        }
        case RANKINGS -> {
            currentPanel = new RankingsPanel(this);
        }



        case null, default -> throw new IllegalArgumentException();

    }
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
        this.pack();

    }

    /**
     * @param i Initiates the game run method and runs the i th level
     */
    public void gameRun(int i){

        this.remove(currentPanel);
        game.runLevel(i);

    }

    /**
     * @param panelToSet This panel will be set as current panel
     * @return Return the panel that has been set for safety
     */
    public JPanel setCurrentPanel(JPanel panelToSet){
        currentPanel = panelToSet;
        return currentPanel;
    }

}
