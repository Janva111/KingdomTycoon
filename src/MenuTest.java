import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void createWindow() {
        Balance balance = new Balance();
        Menu menu = new Menu(balance);
        assertTrue(menu.createWindow());
    }

    @Test
    void newGame() {
        Balance balance = new Balance();
        Menu menu = new Menu(balance);
        assertTrue(menu.newGame());
    }
}