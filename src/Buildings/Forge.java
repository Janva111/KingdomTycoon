package Buildings;

public class Forge extends Building {
    private String loadFile = "BuildingParams/ForgeParams/Params.txt";

    private String design1 = "BuildingParams/ForgeParams/"; // 1-40
    private String design2 = "BuildingParams/ForgeParams/"; // 40-100
    private String desing3 = "BuildingParams/ForgeParams/"; // 101-200

    public Forge() {
        loadBuilding(loadFile);
        loadImage(design1, design2, desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
