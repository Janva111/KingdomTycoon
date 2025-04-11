import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JPanel implements ActionListener {

    public int SCREEN_WIDTH = 1280, SCREEN_HEIGHT = 720;

    private JPanel panel;
    private JFrame window;
    private JButton menu;
    private JButton play;
    private JButton quit;
    private ImageIcon icon = new ImageIcon("Icon.png");

    public Settings() {
        createWindow();
    }

    public void createWindow() {
        menu = new JButton("Menu");
        menu.setBounds(SCREEN_WIDTH/2+150, SCREEN_HEIGHT-100, 200, 40);
        menu.setBackground(Color.WHITE);
        menu.addActionListener(this);
        menu.setFont(new Font("Arial Black", Font.PLAIN, 20));
        menu.setHorizontalTextPosition(JButton.CENTER);

        play = new JButton("Play");
        play.setBounds(SCREEN_WIDTH/2-100, SCREEN_HEIGHT-100, 200, 40);
        play.setBackground(Color.WHITE);
        play.addActionListener(this);
        play.setFont(new Font("Arial Black", Font.PLAIN, 20));
        play.setHorizontalTextPosition(JButton.CENTER);

        quit = new JButton("Quit");
        quit.setBounds(SCREEN_WIDTH/2-350, SCREEN_HEIGHT-100, 200, 40);
        quit.setBackground(Color.WHITE);
        quit.addActionListener(this);
        quit.setFont(new Font("Arial Black", Font.PLAIN, 20));
        quit.setHorizontalTextPosition(JButton.CENTER);

        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLUE);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.add(play);
        panel.add(quit);
        panel.add(menu);

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
}
