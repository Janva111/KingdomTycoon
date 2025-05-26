import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Menu extends JFrame implements ActionListener {
    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JFrame window;
    private JPanel panel;
    private JButton playButton;
    private JButton exitButton;
    private JButton settingsButton;
    private JButton newGameButton;
    private JLabel backgroundMenu;
    private JLabel newGameText;
    private ImageIcon background = new ImageIcon("MainImages/Menu.png");
    private ImageIcon icon = new ImageIcon("MainImages/Icon.png");
    private Balance balance;
    private String textFile = "StartGameValues.txt";

    public Menu(Balance balance) {
        this.balance = balance;
        createWindow();
    }

    public boolean createWindow() {
        playButton = new JButton("Play");
        playButton.setBounds(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT / 2 + 80, 200, 40);
        playButton.setBackground(Color.WHITE);
        playButton.addActionListener(this);
        playButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        playButton.setHorizontalTextPosition(JButton.CENTER);
        playButton.setBorderPainted(false);

        exitButton = new JButton("Quit");
        exitButton.setBounds(SCREEN_WIDTH / 2 - 350, SCREEN_HEIGHT / 2 + 80, 200, 40);
        exitButton.setBackground(Color.WHITE);
        exitButton.addActionListener(this);
        exitButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        exitButton.setHorizontalTextPosition(JButton.CENTER);
        exitButton.setBorderPainted(false);

        settingsButton = new JButton("Settings");
        settingsButton.setBounds(SCREEN_WIDTH / 2 + 150, SCREEN_HEIGHT / 2 + 80, 200, 40);
        settingsButton.setBackground(Color.WHITE);
        settingsButton.addActionListener(this);
        settingsButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        settingsButton.setHorizontalTextPosition(JButton.CENTER);
        settingsButton.setBorderPainted(false);

        newGameButton = new JButton("New Game");
        newGameButton.setBounds(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT / 2 + 160, 200, 40);
        newGameButton.setBackground(Color.WHITE);
        newGameButton.addActionListener(this);
        newGameButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        newGameButton.setHorizontalTextPosition(JButton.CENTER);
        newGameButton.setBorderPainted(false);

        newGameText = new JLabel(balance.newGameText());
        newGameText.setFont(new Font("Arial Black", Font.PLAIN, 40));
        newGameText.setForeground(Color.RED);
        newGameText.setBounds(SCREEN_WIDTH / 2 - 125, SCREEN_HEIGHT / 2 + 20, 400, 60);
        newGameText.setHorizontalTextPosition(JButton.CENTER);

        backgroundMenu = new JLabel(background);
        backgroundMenu.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        panel = new JPanel();
        panel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.add(playButton);
        panel.add(exitButton);
        panel.add(settingsButton);
        panel.add(newGameButton);
        panel.add(newGameText);
        panel.add(backgroundMenu);

        window = new JFrame("Kingdom Tycoon | Menu");
        window.setSize(SCREEN_WIDTH + 5, SCREEN_HEIGHT + 5);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(panel);
        window.setIconImage(icon.getImage());
        return true;
    }

    public boolean newGame() {
        String filename;
        String value1;
        String value2;
        String value3;
        String value4;

        try {
            BufferedReader br = new BufferedReader(new FileReader(textFile));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");

                    filename = split[0];
                    value1 = split[1];
                    value2 = split[2];
                    value3 = split[3];
                    value4 = split[4];

                    try {
                        FileWriter writer = new FileWriter(filename, false);
                        writer.write(value1 + ";" + value2 + ";" + value3 + ";" + value4);
                        writer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            window.dispose();
            new GameWindow(balance);
        }
        if (e.getSource() == exitButton) {
            window.dispose();
            System.exit(0);
        }
        if (e.getSource() == settingsButton) {
            window.dispose();
            new Settings(balance);
        }
        if (e.getSource() == newGameButton) {
            window.dispose();
            newGame();
            new Start();
        }

    }
}




