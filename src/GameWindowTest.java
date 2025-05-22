import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameWindowTest {

    @Test
    void createWindow() {
        Balance balance = new Balance();
        GameWindow gameWindow = new GameWindow(balance);
        assertTrue(gameWindow.createWindow());
    }
}