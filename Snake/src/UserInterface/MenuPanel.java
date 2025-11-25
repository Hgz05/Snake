package UserInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuPanel extends JPanel {

    JPanel titlePanel;
    JPanel buttonsPanel;

    public MenuPanel(){
        //Main Menu Panel
        this.setLayout(new BorderLayout());

        //Title Panel
        titlePanel = new JPanel();
        titlePanel.setPreferredSize( new Dimension(720,240));
        titlePanel.setBackground(Color.black);
        JLabel titleImage = new JLabel();
        titleImage.setIcon(new ImageIcon("res/Title.png"));
        titlePanel.add(titleImage);
        titlePanel.setVisible(true);

        //Buttons Panel
        buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize( new Dimension(720,480));
        buttonsPanel.setBackground(Color.black);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));

        //Levels Button
        JButton levelsButton = new JButton();
        levelsButton.addActionListener(e -> {
            PanelManager.panelChange(PanelManager.panelTypes.LEVELS);
        });
        levelsButton.setMaximumSize(new Dimension(240, 160));
        levelsButton.setBackground(new Color(0,0,0));
        levelsButton.setBorder(new LineBorder(Color.WHITE));
        levelsButton.setText("Levels");
        levelsButton.setForeground(Color.white);
        levelsButton.setAlignmentX(Component.CENTER_ALIGNMENT);



        //Tutorial Button
        JButton tutorialButton = new JButton();
        tutorialButton.addActionListener( e -> {
            PanelManager.panelChange(PanelManager.panelTypes.TUTORIAL);
        });
        tutorialButton.setMaximumSize( new Dimension(240, 160));
        tutorialButton.setBackground(new Color(0,0,0));
        tutorialButton.setBorder(new LineBorder(Color.WHITE));
        tutorialButton.setText("Tutorial");
        tutorialButton.setForeground(Color.white);
        tutorialButton.setAlignmentX(Component.CENTER_ALIGNMENT);



        //Rankings Button
        JButton rankingsButton = new JButton();
        rankingsButton.addActionListener( e -> {
            PanelManager.panelChange(PanelManager.panelTypes.RANKINGS);
        });
        rankingsButton.setMaximumSize( new Dimension(240, 160));
        rankingsButton.setBackground(new Color(0,0,0));
        rankingsButton.setBorder(new LineBorder(Color.WHITE));
        rankingsButton.setText("Rankings");
        rankingsButton.setForeground(Color.white);
        rankingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);



        //Exit Button
        JButton exitButton = new JButton();
        exitButton.addActionListener( e -> System.exit(0));
        exitButton.setMaximumSize( new Dimension(240, 160));
        exitButton.setBackground(new Color(0,0,0));
        exitButton.setBorder(new LineBorder(Color.WHITE));
        exitButton.setText("Exit");
        exitButton.setForeground(Color.white);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);



        //Adding the buttons
        buttonsPanel.add(levelsButton);
        buttonsPanel.add(Box.createVerticalStrut(20));
        buttonsPanel.add(tutorialButton);
        buttonsPanel.add(Box.createVerticalStrut(20));
        buttonsPanel.add(rankingsButton);
        buttonsPanel.add(Box.createVerticalStrut(20));
        buttonsPanel.add(exitButton);
        buttonsPanel.add(Box.createVerticalStrut(20));



        //Adding the panels to the Main Menu panel
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }



}
