package UserInterface;

import javax.swing.*;
import java.awt.*;

public class TutorialPanel extends JPanel {

    PanelManager parentFrame;
    JPanel titlePanel;
    JPanel tutorialPanel;


    public TutorialPanel(PanelManager Frame){

        parentFrame = Frame;
        this.setLayout(new BorderLayout());

        //Title Panel
        titlePanel = new JPanel();
        titlePanel.setMaximumSize( new Dimension(720,240));
        titlePanel.setBackground(Color.black);
        JLabel titleImage = new JLabel();
        titleImage.setIcon(new ImageIcon("res/Title.png"));
        titleImage.setMaximumSize(new Dimension(240,149));
        titlePanel.add(titleImage);
        titlePanel.setVisible(true);

        //testbutton
        JButton test = new JButton();
        test.addActionListener(e -> {
            parentFrame.panelChange(PanelManager.panelTypes.MAINMENU);
        });
        test.setText("Back");


        this.add(titlePanel, BorderLayout.NORTH);
        this.add(test,BorderLayout.CENTER);
        this.setVisible(true);

    }

}
