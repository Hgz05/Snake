import GameEngine.GameHandler;
import UserInterface.PanelManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        GameHandler currentGame = new GameHandler();
        PanelManager mainFrame = new PanelManager(currentGame);
        currentGame.setMainFrame(mainFrame);

    }
}