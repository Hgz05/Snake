package UserInterface;

import UserInterface.BasicComponents.BackPanel;
import UserInterface.BasicComponents.TitlePanel;

import javax.swing.*;
import java.awt.*;

/**
 * This Class serves as the panel that displays the tutorial
 */
public class TutorialPanel extends JPanel {

    /**
     * The Display frame
     */
    PanelManager parentFrame;
    /**
     * Title Panel
     */
    JPanel titlePanel;
    /**
     * This panel displays the tutorial information
     */
    JPanel tutorialField;
    /**
     * This panel contains the main menu button
     */
    JPanel backPanel;


    /**
     * @param Frame This will be the parent frame
     */
    public TutorialPanel(PanelManager Frame){

        parentFrame = Frame;
        this.setLayout(new BorderLayout());

        //Title Panel
        titlePanel = new TitlePanel("res/Tutorial.png", new Dimension(720,240));


        //Tutorial Panel
        tutorialField = new JPanel(new BorderLayout());
        tutorialField.setBackground(Color.black);
        tutorialField.setMaximumSize(new Dimension(720,360));
        JLabel tutorialImage = new JLabel();
        tutorialImage.setIcon(new ImageIcon("res/Placeholder.jpg"));
        tutorialImage.setMaximumSize(new Dimension(300, 300));
        tutorialImage.setHorizontalAlignment(JLabel.CENTER);
        JLabel text = new JLabel();
        text.setText("Read The Manual");
        text.setPreferredSize(new Dimension(96,60));
        text.setHorizontalAlignment(JLabel.CENTER);
        tutorialField.add(text);
        tutorialField.add(tutorialImage);
        tutorialField.setVisible(true);

        //Panel for back button
        backPanel = new BackPanel(parentFrame);

        this.setPreferredSize(new Dimension(720,720));
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(tutorialField, BorderLayout.CENTER);
        this.add(backPanel, BorderLayout.SOUTH);
        this.setVisible(true);

    }

}
