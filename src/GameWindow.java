import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameWindow extends JFrame implements ActionListener {
    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JPanel panel;
    private JFrame window;
    private JLabel map;
    private JButton clickButton;
    private JButton menuButton;
    private JButton settingsButton;
    private JButton exitButton;

    private ImageIcon background = new ImageIcon("GameMap.png");
    private ImageIcon icon = new ImageIcon("Icon.png");

    private Balance balance;

    public GameWindow(Balance balance) {
        createPanel();
        this.balance = balance;
        new GameLoop(balance);

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

        menuButton = new JButton("Menu");
        menuButton.setBounds(30, 10, 100, 200);
        menuButton.setBackground(Color.WHITE);
        menuButton.addActionListener(this);
        menuButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        menuButton.setVisible(false);

        clickButton = new JButton();
        clickButton.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        clickButton.addActionListener(this);
        clickButton.setVisible(true);

        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.white);
        panel.setVisible(true);
        panel.add(menuButton);
        panel.add(clickButton);
        panel.add(map);

        return panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clickButton) {
            balance.setActualBalance(balance.getClickIncome()+balance.getActualBalance());// rework to funktion
            System.out.println(balance.getActualBalance()); // control
        }
    }

}
