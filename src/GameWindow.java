import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame implements ActionListener{
    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JPanel panel;
    private JFrame window;
    private JLabel map;

    private ImageIcon background = new ImageIcon("GameMap.png");
    private ImageIcon icon = new ImageIcon("Icon.png");

    public GameWindow() {
        createPanel();

        window = new JFrame("Kingdom Tycoon");
        window.setSize(SCREEN_WIDTH+5, SCREEN_HEIGHT+5);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(panel);
        window.setIconImage(icon.getImage());
    }
    private int i = 0;
    public void counter(){
        i++;
    }

    public JPanel createPanel() {
        map = new JLabel(background);
        map.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setVisible(true);

        panel.add(map);
        return panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
