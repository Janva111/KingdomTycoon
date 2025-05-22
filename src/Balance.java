import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Balance {
    private String textFile = "MainFileTxt/balance.txt";

    private int clickIncome; // 0
    private int passiveIncome; // 1
    private int actualBalance; // 2

    public Balance() {
        loadBalance();
    }


    public boolean loadBalance(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(textFile));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                setClickIncome(Integer.parseInt(split[0]));
                setPassiveIncome(Integer.parseInt(split[1]));
                setActualBalance(Integer.parseInt(split[2]));
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
