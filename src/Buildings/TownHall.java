package Buildings;

public class TownHall extends Building {
    private String loadFile ="BuildingParams/TownHallParams/Params.txt";

    private String design1 = "BuildingParams/TownHallParams/"; // 1-40
    private String design2 = "BuildingParams/TownHallParams/"; // 40-100
    private String desing3 = "BuildingParams/TownHallParams/"; // 101-200

    public TownHall() {
        loadBuilding(loadFile);
        loadImage(design1,design2,desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
