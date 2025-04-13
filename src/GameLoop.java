import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop {

    private static int FPS = 60;
    private static int delay = FPS / 1000;

    private Timer loop;


    public GameLoop(Game game) {
        loop = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




            }
        });
        loop.start();
    }
}
