import javax.swing.*;
import java.io.*;

public abstract class Building {

    protected int lvl;
    protected int passiveBoost;
    protected int clickBoost;
    protected int upgradeCost;
    protected int upgradeCostMult;

    protected ImageIcon image;
    private Balance balance;

    public Building(Balance balance) {
        this.balance = balance;
    }


    public boolean upgradeBuilding(String filename) {
        balance.subtractBalance(upgradeCost);
        addLvl();
        setUpgradeCost();
        balance.addClickIncome(clickBoost);
        balance.addPassiveIncome(passiveBoost);
        save(filename);

        return true;
    }

    public boolean save(String filename) {
        try {
            FileWriter writer = new FileWriter(filename, false);
            writer.write(String.valueOf(lvl)+";"+ String.valueOf(passiveBoost)+";"+ String.valueOf(clickBoost)+";"+ String.valueOf(upgradeCostMult));
            writer.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    public int loadImage(String filename1, String filename2, String filename3) {
        if (getLvl() <= 40 && getLvl() >= 0) {
            image = new ImageIcon(filename1);
            return 1;
        }
        if (getLvl() > 20 && getLvl() < 100) {
            image = new ImageIcon(filename2);
            setImage(image);
            return 2;
        }
        if (getLvl() > 100 && getLvl() < 200) {
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
