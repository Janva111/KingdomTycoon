package Buildings;

public class Lumberjack extends Building {
    private String loadFile ="BuildingParams/LumberjackParams/Params.txt";

    private String design1 = "BuildingParams/LumberjackParams/"; // 1-40
    private String design2 = "BuildingParams/LumberjackParams/"; // 40-100
    private String desing3 = "BuildingParams/LumberjackParams/"; // 101-200

    public Lumberjack() {
        loadBuilding(loadFile);
        loadImage(design1,design2,desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
