import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void createWindow() {
        Balance balance = new Balance();
        Church church = new Church(balance);
        Farm farm = new Farm(balance);
        Forge forge = new Forge(balance);
        Fisherman fisherman = new Fisherman(balance);
        Library library = new Library(balance);
        Lumberjack lumberjack = new Lumberjack(balance);
        TownHall townHall = new TownHall(balance);
        Shop shop = new Shop(church,farm,forge,fisherman,library,lumberjack,townHall,balance);
        assertTrue(shop.createWindow());
    }
}