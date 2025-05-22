import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GameLoop {

    private static int FPS;
    private static int delay;

    private Timer loop;

    private Balance balance;
    private String textFile = "MainFileTxt/speed.txt";

    // pridat drohy loop ktery bude ukladat hru automaticky

    public GameLoop(Balance balance) {
        this.balance = balance;
        loadGameSpeed();
        loop = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balance.addBalance(balance.getPassiveIncome()); // rework to funktion
                System.out.println(balance.getActualBalance());// control
            }
        });
        loop.start();
    }

    public boolean loadGameSpeed() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(textFile));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                setFPS(Integer.parseInt(split[0]));
                setDelay(Integer.parseInt(split[1]));

            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setFPS(int FPS) {
        GameLoop.FPS = FPS;
    }

    public static void setDelay(int delay) {
        GameLoop.delay = delay;
    }
}
