import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JFrame implements ActionListener {

    public int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 800;

    private JFrame window;
    private JPanel panel;
    private JButton churchUpgrade;
    private JButton farmUpgrade;
    private JButton fishermanUpgrade;
    private JButton forgeUpgrade;
    private JButton libraryUpgrade;
    private JButton lumberjackUpgrade;
    private JButton townHallUpgrade;
    private JButton exitButton;
    private JButton playButton;
    private JLabel shopBackground;
    private JLabel coins;
    private ImageIcon background = new ImageIcon("MainImages/Shop.png");
    private ImageIcon icon = new ImageIcon("MainImages/Icon.png");

    private Church church;
    private Farm farm;
    private Forge forge;
    private Fisherman fisherman;
    private Library library;
    private Lumberjack lumberjack;
    private TownHall townHall;

    private Balance balance;

    /**
     * Constructs the Shop window where the player can upgrade buildings.
     * Initializes references to all upgradeable buildings and creates the UI.
     * Also starts a timer to refresh the coin balance periodically.
     *
     * @param church      The Church building instance.
     * @param farm        The Farm building instance.
     * @param forge       The Forge building instance.
     * @param fisherman   The Fisherman building instance.
     * @param library     The Library building instance.
     * @param lumberjack  The Lumberjack building instance.
     * @param townHall    The TownHall building instance.
     * @param balance     The Balance instance tracking the player's coins.
     */
    public Shop(Church church, Farm farm, Forge forge, Fisherman fisherman, Library library, Lumberjack lumberjack, TownHall townHall, Balance balance) {
        this.balance = balance;

        this.church = church;
        this.farm = farm;
        this.forge = forge;
        this.fisherman = fisherman;
        this.library = library;
        this.lumberjack = lumberjack;
        this.townHall = townHall;

        createWindow();
        // refreshTimer - chatGPT
        Timer refreshTimer = new Timer(60, e -> {
            refresh();
        });
        refreshTimer.start();
    }

    /**
     * Creates and configures the main Shop window where users can upgrade buildings.
     * Sets up all buttons, labels, layout, and background.
     *
     * @return {@code true} if the shop window was successfully created.
     */
    public boolean createWindow() {

        exitButton = new JButton("Exit");
        exitButton.setBounds(790, 10, 200, 40);
        exitButton.setBackground(Color.WHITE);
        exitButton.addActionListener(this);
        exitButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        exitButton.setHorizontalTextPosition(JButton.CENTER);
        exitButton.setBorderPainted(false);

        playButton = new JButton("Continue");
        playButton.setBounds(790, 55, 200, 40);
        playButton.setBackground(Color.WHITE);
        playButton.addActionListener(this);
        playButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        playButton.setHorizontalTextPosition(JButton.CENTER);
        playButton.setBorderPainted(false);

        townHallUpgrade = new JButton("TOWNHALL level: " + townHall.getLvl() + " upgrade: " + townHall.getUpgradeCost());
        townHallUpgrade.setBounds(50, 160, SCREEN_WIDTH - 100, 70);
        townHallUpgrade.setOpaque(false);
        townHallUpgrade.setContentAreaFilled(false);
        townHallUpgrade.setFocusable(false);
        townHallUpgrade.addActionListener(this);
        townHallUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        townHallUpgrade.setForeground(Color.WHITE);
        townHallUpgrade.setHorizontalTextPosition(JButton.CENTER);

        farmUpgrade = new JButton("FARM level: " + farm.getLvl() + " upgrade cost: " + farm.getUpgradeCost());
        farmUpgrade.setBounds(50, 245, SCREEN_WIDTH - 100, 70);
        farmUpgrade.setOpaque(false);
        farmUpgrade.setContentAreaFilled(false);
        farmUpgrade.setFocusable(false);
        farmUpgrade.addActionListener(this);
        farmUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        farmUpgrade.setForeground(Color.WHITE);
        farmUpgrade.setHorizontalTextPosition(JButton.CENTER);

        lumberjackUpgrade = new JButton("LUMBERJACK level:" + lumberjack.getLvl() + " upgrade cost: " + lumberjack.getUpgradeCost());
        lumberjackUpgrade.setBounds(50, 330, SCREEN_WIDTH - 100, 70);
        lumberjackUpgrade.setOpaque(false);
        lumberjackUpgrade.setContentAreaFilled(false);
        lumberjackUpgrade.setFocusable(false);
        lumberjackUpgrade.addActionListener(this);
        lumberjackUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lumberjackUpgrade.setForeground(Color.WHITE);
        lumberjackUpgrade.setHorizontalTextPosition(JButton.CENTER);


        fishermanUpgrade = new JButton("FISHERMAN level: " + fisherman.getLvl() + " upgrade cost: " + fisherman.getUpgradeCost());
        fishermanUpgrade.setBounds(50, 415, SCREEN_WIDTH - 100, 70);
        fishermanUpgrade.setOpaque(false);
        fishermanUpgrade.setContentAreaFilled(false);
        fishermanUpgrade.setFocusable(false);
        fishermanUpgrade.addActionListener(this);
        fishermanUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        fishermanUpgrade.setForeground(Color.WHITE);
        fishermanUpgrade.setHorizontalTextPosition(JButton.CENTER);

        forgeUpgrade = new JButton("FORGE level: " + forge.getLvl() + " upgrade cost: " + forge.getUpgradeCost());
        forgeUpgrade.setBounds(50, 500, SCREEN_WIDTH - 100, 70);
        forgeUpgrade.setOpaque(false);
        forgeUpgrade.setContentAreaFilled(false);
        forgeUpgrade.setFocusable(false);
        forgeUpgrade.addActionListener(this);
        forgeUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        forgeUpgrade.setForeground(Color.WHITE);
        forgeUpgrade.setHorizontalTextPosition(JButton.CENTER);

        libraryUpgrade = new JButton("LIBRARY level: " + library.getLvl() + " upgrade cost: " + library.getUpgradeCost());
        libraryUpgrade.setBounds(50, 585, SCREEN_WIDTH - 100, 70);
        libraryUpgrade.setOpaque(false);
        libraryUpgrade.setContentAreaFilled(false);
        libraryUpgrade.setFocusable(false);
        libraryUpgrade.addActionListener(this);
        libraryUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        libraryUpgrade.setForeground(Color.WHITE);
        libraryUpgrade.setHorizontalTextPosition(JButton.CENTER);

        churchUpgrade = new JButton("CHURCH level:" + church.getLvl() + " upgrade: " + church.getUpgradeCost());
        churchUpgrade.setBounds(50, 675, SCREEN_WIDTH - 100, 70);
        churchUpgrade.setOpaque(false);
        churchUpgrade.setContentAreaFilled(false);
        churchUpgrade.setFocusable(false);
        churchUpgrade.addActionListener(this);
        churchUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        churchUpgrade.setForeground(Color.WHITE);
        churchUpgrade.setHorizontalTextPosition(JButton.CENTER);

        shopBackground = new JLabel(background);
        shopBackground.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        coins = new JLabel("Coins: " + balance.getActualBalance());
        coins.setFont(new Font("Arial Black", Font.PLAIN, 20));
        coins.setForeground(Color.YELLOW);
        coins.setBounds(10, 45, 600, 40);

        panel = new JPanel();
        panel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.add(townHallUpgrade);
        panel.add(churchUpgrade);
        panel.add(fishermanUpgrade);
        panel.add(forgeUpgrade);
        panel.add(libraryUpgrade);
        panel.add(lumberjackUpgrade);
        panel.add(farmUpgrade);
        panel.add(exitButton);
        panel.add(playButton);
        panel.add(coins);
        panel.add(shopBackground);

        window = new JFrame("Kingdom Tycoon | Shop");
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
     * Refreshes the displayed coin balance label with the current value from the Balance object.
     *
     * @return {@code true} if the coin label was successfully refreshed.
     */
    public boolean refresh() {
        coins.setText("Coins: " + balance.getActualBalance());
        return true;
    }

    /**
     * Handles button click events for all shop upgrades and controls.
     * Each upgrade button checks whether the player has enough coins,
     * performs the upgrade, updates the button text, and refreshes the coin display.
     *
     * Additional button actions:
     *
     * Continue – closes the Shop window and resumes the game.
     * Exit – closes the application.
     * "Building"Upgrade - The upgrade button text is updated to reflect the new level and cost
     * , building get upgraded and costLabel will refresh.
     *
     * @param e The ActionEvent triggered by a button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == farmUpgrade) {
            if (balance.getActualBalance() > farm.getUpgradeCost()) {
                farm.upgrade();
                farmUpgrade.setText("FARM level: " + farm.getLvl() + " upgrade cost: " + farm.getUpgradeCost());
                refresh();
            }
        }
        if (e.getSource() == fishermanUpgrade) {
            if (balance.getActualBalance() > fisherman.getUpgradeCost()) {
                fisherman.upgrade();
                fishermanUpgrade.setText("FISHERMAN level: " + fisherman.getLvl() + " upgrade cost: " + fisherman.getUpgradeCost());
                refresh();
            }
        }
        if (e.getSource() == forgeUpgrade) {
            if (balance.getActualBalance() > forge.getUpgradeCost()) {
                forge.upgrade();
                forgeUpgrade.setText("FORGE level: " + forge.getLvl() + " upgrade cost: " + forge.getUpgradeCost());
                refresh();
            }
        }
        if (e.getSource() == libraryUpgrade) {
            if (balance.getActualBalance() > library.getUpgradeCost()) {
                library.upgrade();
                libraryUpgrade.setText("LIBRARY level: " + library.getLvl() + " upgrade cost: " + library.getUpgradeCost());
                refresh();
            }
        }
        if (e.getSource() == lumberjackUpgrade) {
            if (balance.getActualBalance() > lumberjack.getUpgradeCost()) {
                lumberjack.upgrade();
                lumberjackUpgrade.setText("LUMBERJACK level: " + lumberjack.getLvl() + " upgrade cost: " + lumberjack.getUpgradeCost());
                refresh();
            }
        }
        if (e.getSource() == townHallUpgrade) {
            if (balance.getActualBalance() > townHall.getUpgradeCost()) {
                townHall.upgrade();
                townHallUpgrade.setText("TOWNHALL level: " + townHall.getLvl() + " upgrade: " + townHall.getUpgradeCost());
                refresh();
            }
        }
        if (e.getSource() == churchUpgrade) {
            if (balance.getActualBalance() > church.getUpgradeCost()) {
                church.upgrade();
                churchUpgrade.setText("CHURCH level:" + church.getLvl() + " upgrade: " + church.getUpgradeCost());
                refresh();
            }
        }
        if (e.getSource() == playButton) {
            window.dispose();
            new GameWindow(balance);
        }
        if (e.getSource() == exitButton) {
            window.dispose();
            System.exit(0);
        }
    }
}
