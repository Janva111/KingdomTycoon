import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsTest {

    @Test
    void createWindow() {
        Balance balance = new Balance();
        Settings settings = new Settings(balance);
        assertTrue(settings.createWindow());
    }
}