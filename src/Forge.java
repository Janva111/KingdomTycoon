public class Forge extends Building {
    private String loadFile = "BuildingParams/ForgeParams/Params.txt";

    private String design1 = "BuildingParams/ForgeParams/ForgeDesign1.png"; // 1-40
    private String design2 = "BuildingParams/ForgeParams/ForgeDesing2.png";
    private String desing3 = "BuildingParams/ForgeParams/ForgeDesign3.png";

    /**
     * Constructs a building and initializes its state by loading its saved data
     * and setting the appropriate image design based on its level.
     *
     * @param balance The Balance object used to manage the game's currency and income.
     */
    public Forge(Balance balance) {
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
