import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GameLoop {

    private static int FPS;
    private static int delay;

    private Timer loop;

    private Balance balance;
    private String textFile = "MainFileTxt/speed.txt";

    public GameLoop(Balance balance) {
        this.balance = balance;
        loadGameSpeed();
        loop = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balance.addBalance(balance.getPassiveIncome());
                balance.save();
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
                FPS =(Integer.parseInt(split[0]));
                delay =(Integer.parseInt(split[1]));

            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
