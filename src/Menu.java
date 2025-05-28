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

    /**
     * Constructs the main menu of the game, initializing the window and UI elements.
     *
     * @param balance The Balance object that stores the player's current game data.
     */
    public Menu(Balance balance) {
        this.balance = balance;
        createWindow();
    }

    /**
     * Initializes and displays the main menu window, including buttons for:
     * Play, Quit, Settings, and New Game. Also sets up labels and layout.
     *
     * @return {@code true} if the menu window was successfully created.
     */
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

    /**
     * Starts a new game by resetting relevant game data files
     * and adds prestige boost;
     * Reads file names and default values from a configuration text file,
     * and overwrites the content in each specified file with default values.
     *
     * @return {@code true} if the new game data was successfully written.
     * @throws RuntimeException if the file is not found or an I/O error occurs.
     */

    public boolean newGame() {
        String filename;
        int value1;
        int value2;
        int value3;
        int value4;
        int prestigeBoostCount = -1;
        String prestigeBoostFile = balance.getPrestigeBoostFile();

        try {
            BufferedReader br = new BufferedReader(new FileReader(textFile));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");

                    filename = split[0];
                    value1 = Integer.parseInt(split[1]);
                    value2 = Integer.parseInt(split[2]);
                    value3 = Integer.parseInt(split[3]);
                    value4 = Integer.parseInt(split[4]);

                    if (value1 >= 200){
                        prestigeBoostCount++;
                    }
                    try {
                        FileWriter writer = new FileWriter(filename, false);
                        writer.write(value1 + ";" + value2 + ";" + value3 + ";" + value4);
                        writer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
            prestigeBoostCount = prestigeBoostCount + balance.prestigeBoost();
            try {
                FileWriter writer = new FileWriter(prestigeBoostFile, false);
                writer.write(String.valueOf(prestigeBoostCount));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles menu button actions:
     *
     * Play – opens the game window.
     * Quit – exits the application.
     * Settings – opens the settings window.
     * New Game – resets save data and starts a new game.
     *
     *
     * @param e The ActionEvent triggered by user interaction.
     */
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




