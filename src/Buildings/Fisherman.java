package Buildings;

public class Fisherman extends Building {

    private String loadFile ="BuildingParams/FishermanParams/Params.txt";

    private String design1 = "BuildingParams/FishermanParams/"; // 1-40
    private String design2 = "BuildingParams/FishermanParams/"; // 40-100
    private String desing3 = "BuildingParams/FishermanParams/"; // 101-200

    public Fisherman() {
        loadBuilding(loadFile);
        loadImage(design1,design2,desing3);
    }
}
