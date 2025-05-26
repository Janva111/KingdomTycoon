import javax.swing.*;
import java.io.*;

public class Balance {
    private String textFile = "MainFileTxt/balance.txt";
    private String prestigeBoostFile = "MainFileTxt/prestigeBoost.txt";

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
                clickIncome=(Integer.parseInt(split[0])) * prestigeBoost();
                passiveIncome=(Integer.parseInt(split[1]) * prestigeBoost());
                actualBalance=(Integer.parseInt(split[2]) * prestigeBoost());
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Reads the prestige boost value from the `prestigeBoostFile`.
     * <p>
     * The file is expected to contain a single line (or the last valid line is used),
     * with the boost value as the first semicolon-separated field.
     * </p>
     *
     * @return the integer value representing the prestige boost.
     * @throws RuntimeException if the file is not found or cannot be read.
     */
    public int prestigeBoost(){
        int boost = 0;
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(prestigeBoostFile));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                boost = Integer.parseInt(split[0]);
            }
            return boost;
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

    public String getPrestigeBoostFile() {
        return prestigeBoostFile;
    }
}
