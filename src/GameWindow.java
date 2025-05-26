import javax.swing.*;
import java.awt.*;
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
    private JLabel townHallPlace;
    private JLabel churchPlace;
    private JLabel forgePlace;
    private JLabel fishermanPlace;
    private JLabel libraryPlace;
    private JLabel lumberjackPlace;
    private JLabel farmPlace;
    private JLabel coins;

    private ImageIcon background = new ImageIcon("MainImages/GameMap.png");
    private ImageIcon icon = new ImageIcon("MainImages/Icon.png");

    private Balance balance;

    private Church church;
    private Farm farm;
    private Forge forge;
    private Fisherman fisherman;
    private Library library;
    private Lumberjack lumberjack;
    private TownHall townHall;

    /**
     * Constructs the main game window and initializes all game buildings and UI components.
     *
     * @param balance The Balance object that holds and manages the player's financial data.
     */
    public GameWindow(Balance balance) {
        this.balance = balance;

        this.church = new Church(balance);
        this.farm = new Farm(balance);
        this.forge = new Forge(balance);
        this.fisherman = new Fisherman(balance);
        this.library = new Library(balance);
        this.lumberjack = new Lumberjack(balance);
        this.townHall = new TownHall(balance);
        createWindow();
        refresh();

    }

    /**
     * Starts a refresh timer that periodically updates the display of the player's coin balance
     * and refreshes the icons of all building components in the UI.
     *
     * @return {@code true} if the refresh timer was successfully started.
     */
    public boolean refresh(){
        // refreshTimer - chatGPT
        Timer refreshTimer = new Timer(60, e -> {
            coins.setText("Coins: " + balance.getActualBalance());
            churchPlace.setIcon(church.getImage());
            farmPlace.setIcon(farm.getImage());
            forgePlace.setIcon(forge.getImage());
            fishermanPlace.setIcon(fisherman.getImage());
            libraryPlace.setIcon(library.getImage());
            lumberjackPlace.setIcon(lumberjack.getImage());
            townHallPlace.setIcon(townHall.getImage());
        });
        refreshTimer.start();
        return true;
    }


    /**
     * Creates and sets up the entire game window, including buttons, labels,
     * building placeholders, and layout. Also initializes the main game panel and frame.
     *
     * @return {@code true} if the window was successfully created.
     */
    public boolean createWindow() {
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

        menuButton = new JButton("menu");
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
        clickButton.setBounds(206, 150, SCREEN_WIDTH / 2 + 100, SCREEN_HEIGHT / 2 + 100);
        clickButton.setOpaque(false);
        clickButton.setContentAreaFilled(false);
        clickButton.setFocusable(false);
        clickButton.setBorderPainted(false);
        clickButton.addActionListener(this);

        coins = new JLabel("Coins: " + balance.getActualBalance());
        coins.setFont(new Font("Arial Black", Font.PLAIN, 20));
        coins.setForeground(Color.YELLOW);
        coins.setBounds(10, 10, 600, 40);

        map = new JLabel(background);
        map.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        churchPlace = new JLabel();
        churchPlace.setBounds(530,190,80,103);

        forgePlace = new JLabel();
        //forgePlace.setBounds(690,292,);

        fishermanPlace = new JLabel();
        fishermanPlace.setBounds(730,520,90,66);

        libraryPlace = new JLabel();
        libraryPlace.setBounds(400,600,100,103);

        lumberjackPlace = new JLabel();
        lumberjackPlace.setBounds(285,51, 80,65);

        townHallPlace = new JLabel();
        //townHallPlace.setBounds(427,316);

        farmPlace = new JLabel();
        farmPlace.setBounds(140,450,100,78);

        panel = new JPanel();
        panel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.add(settingsButton);
        panel.add(menuButton);
        panel.add(exitButton);
        panel.add(shopButton);
        panel.add(clickButton);
        panel.add(churchPlace);
        panel.add(forgePlace);
        panel.add(fishermanPlace);
        panel.add(libraryPlace);
        panel.add(lumberjackPlace);
        panel.add(townHallPlace);
        panel.add(farmPlace);
        panel.add(coins);
        panel.add(map);

        window = new JFrame("Kingdom Tycoon | Game");
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
     * Handles all button click events in the game window.
     *
     * If the click button is pressed, adds click income to the balance and save game.
     * If the exit button is pressed, closes the application.
     * If the settings, menu, or shop buttons are pressed, opens the respective windows and closes the current one.
     *
     *
     * @param e The ActionEvent triggered by a user interaction.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clickButton) {
                balance.addBalance(balance.getClickIncome());
                coins.setText("Coins: " + balance.getActualBalance());
                balance.save();
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
            new Menu(balance);
        }
        if (e.getSource() == shopButton) {
            window.dispose();
            new Shop(church, farm, forge, fisherman, library, lumberjack, townHall, balance);
        }
    }

}
