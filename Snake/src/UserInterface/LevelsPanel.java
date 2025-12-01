package UserInterface;

import UserInterface.BasicComponents.BackPanel;
import UserInterface.BasicComponents.TitlePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelsPanel extends JPanel {

    PanelManager parentFrame;
    JPanel titlePanel;
    JPanel levelsPanel;
    JPanel backPanel;
    ArrayList<JButton> buttonArray;



    public LevelsPanel(PanelManager Frame){

        parentFrame = Frame;
        this.setLayout(new BorderLayout());

        //Title Panel
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.black);
        JPanel textPanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("Player Name:");
        nameLabel.setPreferredSize(new Dimension(180,20));
        textPanel.setPreferredSize(new Dimension(180,100));
        JTextField userInput = new JTextField(80);
        userInput.setFont(new Font("Arial", Font.PLAIN,24));
        userInput.setMargin(new Insets(5,10,5,10));
        userInput.addActionListener( e -> PanelManager.playerName = userInput.getText());
        textPanel.add(nameLabel, BorderLayout.NORTH);
        textPanel.add(userInput, BorderLayout.CENTER);
        titlePanel.add(textPanel);

        //Menu Table
        levelsPanel = new JPanel(new GridLayout(3,4, 10,10));
        levelsPanel.setBackground(Color.black);
        levelsPanel.setPreferredSize(new Dimension(360,720));
        buttonArray = new ArrayList<>();
        for(int i = 0; i < 10; i++){

            JButton levelButton = new JButton();
            levelButton.setText("Level " + (i+1));
            int finalI = i;
            levelButton.addActionListener(e -> {
                parentFrame.gameRun(finalI);
            });
            buttonArray.add(levelButton);
            levelsPanel.add(levelButton);
        }

        //Back Button
        backPanel = new BackPanel(parentFrame);

        this.setPreferredSize(new Dimension(720,720));
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(levelsPanel, BorderLayout.CENTER);
        this.add(backPanel, BorderLayout.SOUTH);


    }


}
