public class Farm extends Building {

    private String loadFile = "BuildingParams/FarmParams/Params.txt";

    private String design1 = "BuildingParams/FarmParams/";
    private String design2 = "BuildingParams/FarmParams/";
    private String desing3 = "BuildingParams/FarmParams/";

    public Farm(Balance balance) {
        super(balance);
        loadBuilding(loadFile);
        loadImage(design1, design2, desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
