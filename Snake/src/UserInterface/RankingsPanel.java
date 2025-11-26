package UserInterface;

import UserInterface.BasicComponents.BackPanel;
import UserInterface.BasicComponents.TitlePanel;

import javax.swing.*;
import java.awt.*;

public class RankingsPanel extends JPanel {

    PanelManager parentFrame;
    JPanel titlePanel;
    JPanel rankingsPanel;
    JPanel backPanel;

    public RankingsPanel(PanelManager Frame){

        parentFrame = Frame;
        this.setLayout(new BorderLayout());

        //Title Panel
        titlePanel = new TitlePanel("res/Placeholder.jpg", new Dimension(720,240));

        //Rankings Panel

        //Back Button
        backPanel = new BackPanel(parentFrame);

        this.add(titlePanel, BorderLayout.NORTH);
        this.add(backPanel, BorderLayout.SOUTH);


    }

}
