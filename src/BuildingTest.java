import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    Balance balance = new Balance();
    Church c = new Church(balance);
    @Test
    void upgradeBuilding() {
        assertTrue(c.upgrade());
    }

    @Test
    void save() {
        assertTrue(c.save("BuildingParams/ChurchParams/Params.txt"));
    }

    @Test
    void loadBuilding() {
        assertTrue(c.loadBuilding("BuildingParams/ChurchParams/Params.txt"));
    }

    @Test
    void loadImage() {
        c.setLvl(4);
        String design1 = "1-60";
        String design2 = "61-150";
        String desing3 = "151->";
        assertEquals(c.loadImage(design1,design2,desing3),1);
    }
}