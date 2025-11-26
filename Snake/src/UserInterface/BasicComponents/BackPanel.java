package UserInterface.BasicComponents;

import UserInterface.PanelManager;

import javax.swing.*;
import java.awt.*;

public class BackPanel extends JPanel {

    PanelManager parentFrame;

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
