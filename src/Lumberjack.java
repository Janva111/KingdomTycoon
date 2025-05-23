public class Lumberjack extends Building {
    private String loadFile = "BuildingParams/LumberjackParams/Params.txt";

    private String design1 = "BuildingParams/LumberjackParams/";
    private String design2 = "BuildingParams/LumberjackParams/";
    private String desing3 = "BuildingParams/LumberjackParams/";

    public Lumberjack(Balance balance) {
        super(balance);
        loadBuilding(loadFile);
        loadImage(design1, design2, desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
