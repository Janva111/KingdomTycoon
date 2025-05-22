package Buildings;

public class Library extends Building {
    private String loadFile ="BuildingParams/LibraryParams/Params.txt";

    private String design1 = "BuildingParams/LibraryParams/"; // 1-40
    private String design2 = "BuildingParams/LibraryParams/"; // 40-100
    private String desing3 = "BuildingParams/LibraryParams/"; // 101-200

    public Library() {
        loadBuilding(loadFile);
        loadImage(design1,design2,desing3);
    }
}
