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
        this.setMaximumSize(new Dimension(720,720));
        this.setBackground(Color.white);
        this.setIconImage( new ImageIcon("res/SnakeIcon.png").getImage());
        this.setTitle("Snake");
        currentPanel = new MenuPanel(this);
        this.add(currentPanel);
        this.setVisible(true);

    }




    public JPanel getCurrentPanel(){
        return currentPanel;
    }

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
        case GAME -> {
            return;
        }


        case null, default -> throw new IllegalArgumentException();

    }
        this.add(currentPanel);
        this.revalidate();
        this.repaint();

    }

}
