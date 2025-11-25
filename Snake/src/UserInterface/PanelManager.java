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

    switch (panelToChangeTo){

        case MAINMENU -> {
            this.remove(currentPanel);
            currentPanel = new MenuPanel(this);
            this.add(currentPanel);
            this.revalidate();
            this.repaint();
        }
        case LEVELS -> {
            return;
        }
        case TUTORIAL -> {
            this.remove(currentPanel);
            currentPanel = new TutorialPanel(this);
            this.add(currentPanel);
            this.revalidate();
            this.repaint();
        }
        case RANKINGS -> {
            this.remove(currentPanel);
            currentPanel = new RankingsPanel(this);
            this.add(currentPanel);
            this.revalidate();
            this.repaint();
        }
        case GAME -> {
            return;
        }

        case null, default -> throw new IllegalArgumentException();

    }

    }

}
