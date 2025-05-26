public class Farm extends Building {

    private String loadFile = "BuildingParams/FarmParams/Params.txt";

    private String design1 = "BuildingParams/FarmParams/FarmDesign1.png";
    private String design2 = "BuildingParams/FarmParams/FarmDesign2.png";
    private String desing3 = "BuildingParams/FarmParams/FarmDesign3.png";

    /**
     * Constructs a building and initializes its state by loading its saved data
     * and setting the appropriate image design based on its level.
     *
     * @param balance The Balance object used to manage the game's currency and income.
     */
    public Farm(Balance balance) {
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
