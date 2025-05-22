package Buildings;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Building{

    private int lvl;
    private int pasivBoost;
    private int clickBoost;
    private int upgradeCost;

    private ImageIcon image;

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
                pasivBoost = Integer.parseInt(split[1]);
                clickBoost = Integer.parseInt(split[2]);
                upgradeCost = Integer.parseInt(split[0])*Integer.parseInt(split[3]);
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

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public int getClickBoost() {
        return clickBoost;
    }

    public int getPasivBoost() {
        return pasivBoost;
    }

    public int getLvl() {
        return lvl;
    }
}
