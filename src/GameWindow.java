import javax.swing.*;
import java.awt.*;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame implements ActionListener {
    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JPanel panel;
    private JFrame window;
    private JLabel map;
    private JButton clickButton;
    private JButton menuButton;
    private JButton settingsButton;
    private JButton exitButton;
    private JButton shopButton;


    private ImageIcon background = new ImageIcon("GameMap.png");
    private ImageIcon icon = new ImageIcon("Icon.png");

    private Balance balance;

    public GameWindow(Balance balance) {
        this.balance = balance;
        createWindow();

    }

    public boolean createWindow(){
        exitButton = new JButton("Exit");
        exitButton.setBounds(10, 720, 200, 40);
        exitButton.setBackground(Color.WHITE);
        exitButton.addActionListener(this);
        exitButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        exitButton.setHorizontalTextPosition(JButton.CENTER);
        exitButton.setBorderPainted(false);

        settingsButton = new JButton("Settings");
        settingsButton.setBounds(220, 720, 200, 40);
        settingsButton.setBackground(Color.WHITE);
        settingsButton.addActionListener(this);
        settingsButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        settingsButton.setHorizontalTextPosition(JButton.CENTER);
        settingsButton.setBorderPainted(false);

        menuButton = new JButton("Menu");
        menuButton.setBounds(430, 720, 200, 40);
        menuButton.setBackground(Color.WHITE);
        menuButton.addActionListener(this);
        menuButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        menuButton.setHorizontalTextPosition(JButton.CENTER);
        menuButton.setBorderPainted(false);

        shopButton = new JButton("Shop");
        shopButton.setBounds(790, 10, 200, 40);
        shopButton.setBackground(Color.WHITE);
        shopButton.addActionListener(this);
        shopButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        shopButton.setHorizontalTextPosition(JButton.CENTER);
        shopButton.setBorderPainted(false);

        clickButton = new JButton();
        clickButton.setBounds(206,150,SCREEN_WIDTH/2+100,SCREEN_HEIGHT/2+100);
        clickButton.setOpaque(false);
        clickButton.setContentAreaFilled(false);
        clickButton.setFocusable(false);
        //clickButton.setBorderPainted(false);
        clickButton.addActionListener(this);

        map = new JLabel(background);
        map.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.add(settingsButton);
        panel.add(menuButton);
        panel.add(exitButton);
        panel.add(shopButton);
        panel.add(clickButton);
        panel.add(map);

        window = new JFrame("Kingdom Tycoon");
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
        if (e.getSource() == clickButton) {
            balance.addBalance(balance.getClickIncome());// rework to funktion
            System.out.println(balance.getActualBalance()); // control
        }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
        if (e.getSource() == settingsButton) {
            window.dispose();
            new Settings(balance);
        }
        if (e.getSource() == menuButton) {
            window.dispose();
            new Menu();
        }
        if (e.getSource() == shopButton) {
            window.dispose();
            new Shop();
        }
    }

}
