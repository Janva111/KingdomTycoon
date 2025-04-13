import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements ActionListener, KeyListener{
    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JPanel panel;
    private JFrame window;

    private ImageIcon background = new ImageIcon("background.png");
    private ImageIcon icon = new ImageIcon("Icon.png");

    public Game() {
        createWindow();
    }

    public void createWindow() {
        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLUE);
        panel.setLayout(null);
        panel.setVisible(true);

        window = new JFrame("Kingdom Tycoon");
        window.setSize(SCREEN_WIDTH+5, SCREEN_HEIGHT+5);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(panel);
        window.setIconImage(new ImageIcon("Icon.png").getImage());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {




    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
