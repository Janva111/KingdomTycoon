package Buildings;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Building{

    protected int lvl;
    protected int passiveBoost;
    protected int clickBoost;
    protected int upgradeCost;
    protected int upgradeCostMult;

    protected ImageIcon image;

    //protected Balance balance;

    public Building() {
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
        if (getLvl() <= 40 && getLvl() >= 0 ) {
            image = new ImageIcon(filename1);
            return 1;
        }if (getLvl()>20 && getLvl()<100) {
            image = new ImageIcon(filename2);
            setImage(image);
            return 2;
        }if (getLvl()>100 && getLvl()<200) {
            image = new ImageIcon(filename3);
            setImage(image);
            return 3;
        }
        return 0;
    }

    public void addLvl() {
        this.lvl ++;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void setUpgradeCost() {
        this.upgradeCost = upgradeCostMult*lvl + upgradeCostMult;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public int getClickBoost() {
        return clickBoost;
    }

    public int getPassiveBoost() {
        return passiveBoost;
    }

    public int getLvl() {
        return lvl;
    }

    public ImageIcon getImage() {
        return image;
    }
}
