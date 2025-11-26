package UserInterface;

import UserInterface.BasicComponents.BackPanel;
import UserInterface.BasicComponents.TitlePanel;

import javax.swing.*;
import java.awt.*;

public class TutorialPanel extends JPanel {

    PanelManager parentFrame;
    JPanel titlePanel;
    JPanel tutorialField;
    JPanel backPanel;


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
        tutorialField.add(tutorialImage);
        tutorialField.setVisible(true);

        //Panel for back button
        backPanel = new BackPanel(parentFrame);


        this.add(titlePanel, BorderLayout.NORTH);
        this.add(tutorialField, BorderLayout.CENTER);
        this.add(backPanel, BorderLayout.SOUTH);
        this.setVisible(true);

    }

}
