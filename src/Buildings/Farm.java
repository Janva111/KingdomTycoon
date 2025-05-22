package Buildings;

public class Farm extends Building {

    private String loadFile ="BuildingParams/FarmParams/Params.txt";

    private String design1 = "BuildingParams/FarmParams/"; // 1-40
    private String design2 = "BuildingParams/FarmParams/"; // 40-100
    private String desing3 = "BuildingParams/FarmParams/"; // 101-200

    public Farm() {
        loadBuilding(loadFile);
        loadImage(design1,design2,desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
