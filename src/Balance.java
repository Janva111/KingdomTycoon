import javax.swing.*;
import java.io.*;

public class Balance {
    private String textFile = "MainFileTxt/balance.txt";

    private int clickIncome; // 0
    private int passiveIncome; // 1
    private int actualBalance; // 2

    public Balance() {
        loadBalance();
    }

    /**
     * Saves the current game state (click income, passive income, and actual balance)
     * to a predefined text file.
     *
     * @return {@code true} if the save operation was successful.
     * @throws RuntimeException if an I/O error occurs during writing.
     */
    public boolean save(){
        try {
            FileWriter writer = new FileWriter(textFile, false);
            writer.write(String.valueOf(clickIncome)+";"+ String.valueOf(passiveIncome)+";"+ String.valueOf(actualBalance));
            writer.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the game state (click income, passive income, and actual balance)
     * from a predefined text file.
     *
     * @return {@code true} if the load operation was successful.
     * @throws RuntimeException if the file is not found or an I/O error occurs.
     */
    public boolean loadBalance() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(textFile));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                clickIncome=(Integer.parseInt(split[0]));
                passiveIncome=(Integer.parseInt(split[1]));
                actualBalance=(Integer.parseInt(split[2]));
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Checks whether the current game state matches the default values for a new game.
     *
     * @return The string "New Game" if the game is in its initial state,
     *         otherwise an empty string.
     */
    public String newGameText(){
        if (clickIncome == 1 && passiveIncome == 0 && actualBalance == 0) {
            return "New Game";
        }
        return "";
    }


    public void addBalance(int amount) {
        actualBalance += amount;
    }

    public void subtractBalance(int amount) {
        actualBalance -= amount;
    }

    public void addClickIncome(int amount) {
        clickIncome += amount;
    }

    public void addPassiveIncome(int amount) {
        passiveIncome += amount;
    }

    public void setClickIncome(int clickIncome) {
        this.clickIncome = clickIncome;
    }

    public void setPassiveIncome(int passiveIncome) {
        this.passiveIncome = passiveIncome;
    }

    public void setActualBalance(int actualBalance) {
        this.actualBalance = actualBalance;
    }

    public int getClickIncome() {
        return clickIncome;
    }

    public int getPassiveIncome() {
        return passiveIncome;
    }

    public int getActualBalance() {
        return actualBalance;
    }
}
