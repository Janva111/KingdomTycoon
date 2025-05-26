public class Library extends Building {
    private String loadFile = "BuildingParams/LibraryParams/Params.txt";

    private String design1 = "BuildingParams/LibraryParams/";
    private String design2 = "BuildingParams/LibraryParams/";
    private String desing3 = "BuildingParams/LibraryParams/";

    /**
     * Constructs a building and initializes its state by loading its saved data
     * and setting the appropriate image design based on its level.
     *
     * @param balance The Balance object used to manage the game's currency and income.
     */
    public Library(Balance balance) {
        super(balance);
        loadBuilding(loadFile);
        loadImage(design1, design2, desing3);
    }
    /**
     * Upgrades the building by applying its effects and saving the updated data to a file.
     *
     * @return {@code true} if the upgrade was successful.
     */
    public boolean upgrade() {
        upgradeBuilding(loadFile);
        return true;
    }
}
