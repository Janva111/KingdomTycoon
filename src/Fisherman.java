public class Fisherman extends Building {

    private String loadFile = "BuildingParams/FishermanParams/Params.txt";

    private String design1 = "BuildingParams/FishermanParams/";
    private String design2 = "BuildingParams/FishermanParams/";
    private String desing3 = "BuildingParams/FishermanParams/";

    public Fisherman(Balance balance) {
        super(balance);
        loadBuilding(loadFile);
        loadImage(design1, design2, desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
