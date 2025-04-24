import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Balance {

    private String textFile = "balance.txt";

    private int clickIncome; // 0
    private int pasivIncome; // 1
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
                setPasivIncome(Integer.parseInt(split[1]));
                setActualBalance(Integer.parseInt(split[2]));
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void setClickIncome(int clickIncome) {
        this.clickIncome = clickIncome;
    }

    public void setPasivIncome(int pasivIncome) {
        this.pasivIncome = pasivIncome;
    }

    public void setActualBalance(int actualBalance) {
        this.actualBalance = actualBalance;
    }

    public int getClickIncome() {
        return clickIncome;
    }

    public int getPasivIncome() {
        return pasivIncome;
    }

    public int getActualBalance() {
        return actualBalance;
    }
}
