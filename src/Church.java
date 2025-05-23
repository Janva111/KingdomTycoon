public class Church extends Building {

    private String loadFile ="BuildingParams/ChurchParams/Params.txt";

    private String design1 = "BuildingParams/ChurchParams/";
    private String design2 = "BuildingParams/ChurchParams/";
    private String desing3 = "BuildingParams/ChurchParams/";

    public Church(Balance balance) {
        super(balance);
        loadBuilding(loadFile);
        loadImage(design1,design2,desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }

}
