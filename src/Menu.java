import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JFrame window;
    private JPanel panel;
    private JButton play;
    private JButton quit;
    private JButton settingsButton;
    private JLabel backgroundMenu;
    private ImageIcon background = new ImageIcon("Menu.png");
    private ImageIcon icon = new ImageIcon("Icon.png");
    private Balance balance = new Balance();

    public Menu() {
        createWindow();
    }

    public void createWindow(){
        play = new JButton("Play");
        play.setBounds(SCREEN_WIDTH/2-100, SCREEN_HEIGHT/2+80, 200, 40);
        play.setBackground(Color.WHITE);
        play.addActionListener(this);
        play.setFont(new Font("Arial Black", Font.PLAIN, 20));
        play.setHorizontalTextPosition(JButton.CENTER);

        quit = new JButton("Quit");
        quit.setBounds(SCREEN_WIDTH/2-350, SCREEN_HEIGHT/2+80, 200, 40);
        quit.setBackground(Color.WHITE);
        quit.addActionListener(this);
        quit.setFont(new Font("Arial Black", Font.PLAIN, 20));
        quit.setHorizontalTextPosition(JButton.CENTER);

        settingsButton = new JButton("Settings");
        settingsButton.setBounds(SCREEN_WIDTH/2+150, SCREEN_HEIGHT/2+80, 200, 40);
        settingsButton.setBackground(Color.WHITE);
        settingsButton.addActionListener(this);
        settingsButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        settingsButton.setHorizontalTextPosition(JButton.CENTER);

        backgroundMenu = new JLabel(background);
        backgroundMenu.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.add(play);
        panel.add(quit);
        panel.add(settingsButton);
        panel.add(backgroundMenu);

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
        if (e.getSource() == play) {
            window.dispose();
            new GameWindow(balance);
        }
        if (e.getSource() == quit) {
            window.dispose();
            System.exit(0);
        }
        if (e.getSource() == settingsButton) {;
            window.dispose();
            new Settings(balance);
        }

    }
}




