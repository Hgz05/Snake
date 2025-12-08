package GameEngine;
import GameEngine.GameObjects.Apple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LevelTest {

    Level testLevel;

    @BeforeEach
    public void setUp(){
         testLevel = new Level(1);
    }

    @Test
    void testInput(){
        assertSame(Apple.class, testLevel.getLevelMap().getFirst().getFirst().getClass());
    }

    @Test
    void testMultpleInput(){
        assertSame(Apple.class,testLevel.getLevelMap().getLast().getFirst().getClass());
        assertSame(Apple.class,testLevel.getLevelMap().get(5).getFirst().getClass());
    }

}
