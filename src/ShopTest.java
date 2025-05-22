import Buildings.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void createWindow() {
        Balance balance = new Balance();
        Church church = new Church();
        Farm farm = new Farm();
        Forge forge = new Forge();
        Fisherman fisherman = new Fisherman();
        Library library = new Library();
        Lumberjack lumberjack = new Lumberjack();
        TownHall townHall = new TownHall();
        Shop shop = new Shop(church,farm,forge,fisherman,library,lumberjack,townHall,balance);
        assertTrue(shop.createWindow());
    }
}