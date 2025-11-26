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
        titlePanel = new TitlePanel("res/Placeholder.jpg", new Dimension(720,240));

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
