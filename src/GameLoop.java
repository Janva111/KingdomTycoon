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

    /**
     * Creates a new GameLoop instance that periodically adds passive income to the balance
     * and saves the current game state at a fixed interval defined by the game speed settings.
     *
     * @param balance The Balance object that holds the player's financial state.
     *                This object is updated regularly by the game loop.
     */
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


    /**
     * Loads the game speed configuration (frames per second and delay between updates)
     * from a predefined text file and sets the corresponding values.
     *
     * @return {@code true} if the configuration was successfully loaded.
     * @throws RuntimeException if the file is not found or an I/O error occurs.
     */
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
