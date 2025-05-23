public class TownHall extends Building {
    private String loadFile = "BuildingParams/TownHallParams/Params.txt";

    private String design1 = "BuildingParams/TownHallParams/";
    private String design2 = "BuildingParams/TownHallParams/";
    private String desing3 = "BuildingParams/TownHallParams/";

    public TownHall(Balance balance) {
        super(balance);
        loadBuilding(loadFile);
        loadImage(design1, design2, desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
