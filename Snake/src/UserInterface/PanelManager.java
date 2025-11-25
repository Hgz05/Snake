package UserInterface;

import javax.swing.*;
import java.awt.*;

public class PanelManager extends JFrame {

    private JPanel currentPanel;
    public enum panelTypes{

        MAINMENU,
        LEVELS,
        TUTORIAL,
        RANKINGS,
        GAME
    }

    public PanelManager(){

        this.setSize(720,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        currentPanel = new MenuPanel();
        this.add(currentPanel);
        this.setVisible(true);

    }

    public void setCurrentPanel(JPanel panelToSet){
        currentPanel = panelToSet;
    }

    public JPanel getCurrentPanel(){
        return currentPanel;
    }

    public static void panelChange(panelTypes panelToChangeTo){

    switch (panelToChangeTo){

        case MAINMENU -> {
            return;
        }
        case LEVELS -> {
            return;
        }
        case TUTORIAL -> {
            return;
        }
        case RANKINGS -> {
            return;
        }
        case GAME -> {
            return;
        }

        case null, default -> throw new IllegalArgumentException();

    }

    }

}
