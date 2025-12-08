package GameEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {

    Snake testSnake;
    SnakeBody testSnakeBody;

    @BeforeEach
    public void setUp(){
        testSnake = new Snake(30,true);
        testSnakeBody = new SnakeBody(testSnake);
    }

    @Test
    void setDirection() {
        testSnake.setDirection(Snake.directions.DOWN);
        assertArrayEquals(testSnake.currentlyFacing.values(),Snake.directions.DOWN.values());
    }

    @Test
    void comparePosition() {
        assertTrue(testSnake.comparePosition(11,11));
    }

    @Test
    void compareBodyPos(){
        testSnake.setPos(Snake.directions.UP);
        testSnake.setPos(Snake.directions.UP);
        testSnakeBody.setPos(Snake.directions.UP);
        assertTrue(testSnakeBody.comparePosition(11,10));

    }

}