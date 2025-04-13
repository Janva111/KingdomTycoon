
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JFrame window;
    private JPanel panel;
    private JButton play;
    private JButton quit;
    private JButton settings;
    private JLabel backgroundMenu;
    private ImageIcon background = new ImageIcon("Menu.png");
    private ImageIcon icon = new ImageIcon("Icon.png");

    public Menu() {
        createMenu();
    }

    public void createMenu(){
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

        settings = new JButton("Settings");
        settings.setBounds(SCREEN_WIDTH/2+150, SCREEN_HEIGHT/2+80, 200, 40);
        settings.setBackground(Color.WHITE);
        settings.addActionListener(this);
        settings.setFont(new Font("Arial Black", Font.PLAIN, 20));
        settings.setHorizontalTextPosition(JButton.CENTER);

        backgroundMenu = new JLabel(background);
        backgroundMenu.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);



        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.add(play);
        panel.add(quit);
        panel.add(settings);
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
            new Game();
        }
        if (e.getSource() == quit) {
            window.dispose();
            System.exit(0);
        }
        if (e.getSource() == settings) {;
            window.dispose();
            new Settings();
        }

    }
}




