package Buildings;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Building {

    private String buildingName;
    private int lvl;
    private int pasivBoost;
    private int clickBoost;
    private int upgradeCost;

    private JLabel image;

    public Building(String filename) {
        loadBuilding(filename);
    }

    public boolean loadBuilding(String filename) {
       /*
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");



            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        */
        return true;
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
