import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame implements ActionListener {

    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JPanel panel;
    private JFrame window;
    private JButton menu;
    private JButton play;
    private JButton quit;
    private JLabel settings;
    private ImageIcon settings_icon = new ImageIcon("MainImages/Settings.png");
    private ImageIcon icon = new ImageIcon("MainImages/Icon.png");
    private Balance balance;

    public Settings(Balance balance) {
        this.balance = balance;
        createWindow();
    }

    public boolean createWindow() {

        menu = new JButton("Menu");
        menu.setBounds(SCREEN_WIDTH/2+150, SCREEN_HEIGHT-100, 200, 40);
        menu.setBackground(Color.WHITE);
        menu.addActionListener(this);
        menu.setFont(new Font("Arial Black", Font.PLAIN, 20));
        menu.setHorizontalTextPosition(JButton.CENTER);
        menu.setBorderPainted(false);

        play = new JButton("Play");
        play.setBounds(SCREEN_WIDTH/2-100, SCREEN_HEIGHT-100, 200, 40);
        play.setBackground(Color.WHITE);
        play.addActionListener(this);
        play.setFont(new Font("Arial Black", Font.PLAIN, 20));
        play.setHorizontalTextPosition(JButton.CENTER);
        play.setBorderPainted(false);

        quit = new JButton("Quit");
        quit.setBounds(SCREEN_WIDTH/2-350, SCREEN_HEIGHT-100, 200, 40);
        quit.setBackground(Color.WHITE);
        quit.addActionListener(this);
        quit.setFont(new Font("Arial Black", Font.PLAIN, 20));
        quit.setHorizontalTextPosition(JButton.CENTER);
        quit.setBorderPainted(false);

        settings = new JLabel(settings_icon);
        settings.setBounds(0,0, SCREEN_WIDTH, SCREEN_HEIGHT);

        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLUE);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.add(play);
        panel.add(quit);
        panel.add(menu);
        panel.add(settings);

        window = new JFrame("Kingdom Tycoon | Settings");
        window.setSize(SCREEN_WIDTH+5, SCREEN_HEIGHT+5);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(panel);
        window.setIconImage(icon.getImage());
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
            System.exit(0);

        }if (e.getSource() == play) {
            window.dispose();
            new GameWindow(balance);
        }
        if (e.getSource() == menu) {
            window.dispose();
            new Menu();
        }
    }
}
