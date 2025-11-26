package GameEngine;

import javax.swing.*;
import java.util.ArrayList;

public class GameHandler {

    ArrayList<Level> levelArray;
    JFrame mainFrame;

    public void setMainFrame(JFrame Frame){
        mainFrame = Frame;
    }
    public GameHandler(){
        //Fill the level Array with level objects


    }

    public void runLevel(int levelToSelect){
        mainFrame.revalidate();
        mainFrame.repaint();
    }


}
