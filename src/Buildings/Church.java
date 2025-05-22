package Buildings;

public class Church extends Building {

    private String loadFile ="BuildingParams/ChurchParams/Params.txt";

    private String design1 = "BuildingParams/ChurchParams/"; // 1-40
    private String design2 = "BuildingParams/ChurchParams/"; // 40-100
    private String desing3 = "BuildingParams/ChurchParams/"; // 101-200
    public Church() {
        loadBuilding(loadFile);
        loadImage(design1,design2,desing3);
    }
}
