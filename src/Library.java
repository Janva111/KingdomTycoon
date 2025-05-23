public class Library extends Building {
    private String loadFile = "BuildingParams/LibraryParams/Params.txt";

    private String design1 = "BuildingParams/LibraryParams/";
    private String design2 = "BuildingParams/LibraryParams/";
    private String desing3 = "BuildingParams/LibraryParams/";

    public Library(Balance balance) {
        super(balance);
        loadBuilding(loadFile);
        loadImage(design1, design2, desing3);
    }

    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
