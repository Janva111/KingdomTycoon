import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame implements ActionListener {

    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JPanel panel;
    private JFrame window;
    private JButton menuButton;
    private JButton playButton;
    private JButton quitButton;
    private JLabel settings;
    private ImageIcon settings_icon = new ImageIcon("MainImages/Settings.png");
    private ImageIcon icon = new ImageIcon("MainImages/Icon.png");
    private Balance balance;

    public Settings(Balance balance) {
        this.balance = balance;
        createWindow();
    }

    public boolean createWindow() {

        menuButton = new JButton("Menu");
        menuButton.setBounds(SCREEN_WIDTH / 2 + 150, SCREEN_HEIGHT - 100, 200, 40);
        menuButton.setBackground(Color.WHITE);
        menuButton.addActionListener(this);
        menuButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        menuButton.setHorizontalTextPosition(JButton.CENTER);
        menuButton.setBorderPainted(false);

        playButton = new JButton("Play");
        playButton.setBounds(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT - 100, 200, 40);
        playButton.setBackground(Color.WHITE);
        playButton.addActionListener(this);
        playButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        playButton.setHorizontalTextPosition(JButton.CENTER);
        playButton.setBorderPainted(false);

        quitButton = new JButton("Quit");
        quitButton.setBounds(SCREEN_WIDTH / 2 - 350, SCREEN_HEIGHT - 100, 200, 40);
        quitButton.setBackground(Color.WHITE);
        quitButton.addActionListener(this);
        quitButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        quitButton.setHorizontalTextPosition(JButton.CENTER);
        quitButton.setBorderPainted(false);

        settings = new JLabel(settings_icon);
        settings.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        panel = new JPanel();
        panel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLUE);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.add(playButton);
        panel.add(quitButton);
        panel.add(menuButton);
        panel.add(settings);

        window = new JFrame("Kingdom Tycoon | Settings");
        window.setSize(SCREEN_WIDTH + 5, SCREEN_HEIGHT + 5);
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
        if (e.getSource() == quitButton) {
            System.exit(0);
        }
        if (e.getSource() == playButton) {
            window.dispose();
            new GameWindow(balance);
        }
        if (e.getSource() == menuButton) {
            window.dispose();
            new Menu(balance);
        }
    }
}
