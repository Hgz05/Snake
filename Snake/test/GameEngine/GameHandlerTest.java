package GameEngine;
import UserInterface.PanelManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GameHandlerTest {

    GameHandler testGame;
    PanelManager testPanel;

    @BeforeEach
    public void setUp(){

        testGame = new GameHandler();
        testPanel = new PanelManager(testGame);
        testGame.setMainFrame(testPanel);
    }

    @Test
    void levelReadTest(){
        assertFalse(testGame.levelArray.isEmpty());
        for(Level currentLevel : testGame.levelArray){
            assertFalse(currentLevel.getLevelMap().isEmpty());
        }
    }

    @Test
    void appleRemoveTest(){
        testGame.runLevel(0);
        testGame.setApplesRemain();
        assertEquals(11, testGame.applesRemain);

    }

    @Test
    void snakeGrowthTest(){

        testGame.runLevel(0);
        testGame.addSnakeBody();
        assertSame(SnakeBody.class,testGame.getSnakeArray().get(1).getClass());

    }

    @Test
    void collisionTest(){

        testGame.runLevel(0);
        testGame.playerSnake.posY = 330;
        testGame.playerSnake.posRow = 11;
        testGame.collisionCheck();
        assertEquals(11,testGame.loadedGameObjects.size());

    }

    @Test
    void threadRunningTest(){
        testGame.runLevel(0);
        GameHandler.setThreadRunning(false);
        assertFalse(testGame.gameThread.isInterrupted());
    }

}
