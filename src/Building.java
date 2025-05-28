import javax.swing.*;
import java.io.*;

public abstract class Building {

    protected int lvl;
    protected int passiveBoost;
    protected int clickBoost;
    protected int upgradeCost;
    protected int upgradeCostMult;

    protected ImageIcon image;
    protected Balance balance;

    public Building(Balance balance) {
        this.balance = balance;
    }

    /**
     * Upgrades the building: subtracts the upgrade cost from the current balance,
     * increases the level, recalculates the new upgrade cost,
     * quest reward for lvl 60 and 150,
     * and adds the click and passive income boosts.
     * Then saves the updated building state to a file.
     *
     * @param filename The name of the file where the building data should be saved.
     * @return {@code true} if the upgrade was successful.
     */
    public boolean upgradeBuilding(String filename) {
        balance.subtractBalance(upgradeCost);
        addLvl();
        setUpgradeCost();
        balance.addClickIncome(clickBoost * balance.prestigeBoost());
        balance.addPassiveIncome(passiveBoost * balance.prestigeBoost());
        save(filename);

        if (getLvl() == 60 || getLvl() == 150) {
            balance.addBalance(upgradeCost*balance.prestigeBoost()*1000*getLvl());
        }

        return true;
    }


    /**
     * Saves the current building state (level, passive boost, click boost, upgrade cost multiplier)
     * to the specified file.
     *
     * @param filename The name of the file to save the data to.
     * @return {@code true} if the save was successful.
     * @throws RuntimeException if an I/O error occurs during writing.
     */
    public boolean save(String filename) {
        try {
            FileWriter writer = new FileWriter(filename, false);
            writer.write(String.valueOf(lvl) + ";" + String.valueOf(passiveBoost) + ";" + String.valueOf(clickBoost) + ";" + String.valueOf(upgradeCostMult));
            writer.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the building state (level, passive boost, click boost, upgrade cost multiplier)
     * from the specified file and applies the values.
     *
     * @param filename The name of the file to load the data from.
     * @return {@code true} if the load was successful.
     * @throws RuntimeException if the file is not found or an I/O error occurs.
     */
    public boolean loadBuilding(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            // lvl, passivBoost, clickBoost, upgradeCostMult

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                lvl = Integer.parseInt(split[0]);
                passiveBoost = Integer.parseInt(split[1]);
                clickBoost = Integer.parseInt(split[2]);
                upgradeCostMult = Integer.parseInt(split[3]);
                setUpgradeCost();
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Loads and sets the image of the building based on the current level.
     *
     * @param filename1 Path to the image for levels 1–60.
     * @param filename2 Path to the image for levels 61–150.
     * @param filename3 Path to the image for levels 151 and above.
     * @return A number representing which image was used:
     * 1 (filename1), 2 (filename2), 3 (filename3),
     * or 0 if the level is invalid.
     */
    public int loadImage(String filename1, String filename2, String filename3) {
        if (getLvl() <= 60 && getLvl() > 0) {
            image = new ImageIcon(filename1);
            return 1;
        }
        if (getLvl() > 60 && getLvl() <= 150) {
            image = new ImageIcon(filename2);
            setImage(image);
            return 2;
        }
        if (getLvl() >= 151) {
            image = new ImageIcon(filename3);
            setImage(image);
            return 3;
        }
        return 0;
    }

    public void addLvl() {
        this.lvl++;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void setUpgradeCost() {
        this.upgradeCost = upgradeCostMult * lvl + upgradeCostMult;
    }

    public void setLvl(int lvl) { // unit test
        this.lvl = lvl;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public int getLvl() {
        return lvl;
    }

    public ImageIcon getImage() {
        return image;
    }
}
