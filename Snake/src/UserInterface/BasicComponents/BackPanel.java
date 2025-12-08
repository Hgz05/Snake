package UserInterface.BasicComponents;

import UserInterface.PanelManager;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates a back button used in multiple menus
 */
public class BackPanel extends JPanel {

    /**
     * This is the display frame here it is used to get a back reference to change panels
     */
    PanelManager parentFrame;

    /**
     * @param Frame This will be the parent frame
     */
    public BackPanel(PanelManager Frame){

        parentFrame = Frame;
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setAlignmentX(120);
        this.setBackground(Color.black);
        this.setSize(720, 120);
        JButton backButton = new JButton();
        backButton.addActionListener( e -> {
            parentFrame.panelChange(PanelManager.panelTypes.MAINMENU);
        });
        backButton.setText("Back");
        backButton.setPreferredSize(new Dimension(64,48));

        this.add(Box.createHorizontalStrut(20));
        this.add(backButton);

    }

}
