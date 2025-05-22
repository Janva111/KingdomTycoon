import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLoopTest {

    @Test
    void loadGameSpeed() {
        Balance balance = new Balance();
        GameLoop gameLoop = new GameLoop(balance);
        assertTrue(gameLoop.loadGameSpeed());
    }
}