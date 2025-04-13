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
    private JLabel map;
    private GameLoop gameLoop;

    private ImageIcon background = new ImageIcon("GameMap.png");
    private ImageIcon icon = new ImageIcon("Icon.png");

    public Game() {
        createWindow();
        gameLoop = new GameLoop(this);
    }

    public void createWindow() {

        map = new JLabel(background);
        map.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setVisible(true);

        panel.add(map);

        window = new JFrame("Kingdom Tycoon");
        window.setSize(SCREEN_WIDTH+5, SCREEN_HEIGHT+5);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(panel);
        window.setIconImage(icon.getImage());
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
