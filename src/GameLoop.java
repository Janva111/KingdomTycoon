import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop {

    private static int FPS = 60;

    private Timer loop;


    public GameLoop() {
        loop = new Timer(FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        loop.start();
    }
}
