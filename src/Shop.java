import Buildings.*;

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

    public Shop(Church church, Farm farm, Forge forge,Fisherman fisherman, Library library,Lumberjack lumberjack, TownHall townHall, Balance balance) {
        this.balance = balance;

        this.church = church;
        this.farm = farm;
        this.forge = forge;
        this.fisherman = fisherman;
        this.library = library;
        this.lumberjack = lumberjack;
        this.townHall = townHall;

        createWindow();
    }

    // prepisovani hodnot po kliknuti


    public boolean createWindow() {

        exitButton = new JButton("Exit");
        exitButton.setBounds(10, 45, 200, 40);
        exitButton.setBackground(Color.WHITE);
        exitButton.addActionListener(this);
        exitButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        exitButton.setHorizontalTextPosition(JButton.CENTER);
        exitButton.setBorderPainted(false);

        playButton = new JButton("Continue");
        playButton.setBounds(790, 45, 200, 40);
        playButton.setBackground(Color.WHITE);
        playButton.addActionListener(this);
        playButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
        playButton.setHorizontalTextPosition(JButton.CENTER);
        playButton.setBorderPainted(false);

        townHallUpgrade = new JButton("TownHall upgrade: " + townHall.getUpgradeCost());
        townHallUpgrade.setBounds(50, 160,SCREEN_WIDTH-100 , 70);
        townHallUpgrade.setOpaque(false);
        townHallUpgrade.setContentAreaFilled(false);
        townHallUpgrade.setFocusable(false);
        townHallUpgrade.addActionListener(this);
        townHallUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        townHallUpgrade.setForeground(Color.WHITE);
        townHallUpgrade.setHorizontalTextPosition(JButton.CENTER);

        lumberjackUpgrade = new JButton("Lumberjack upgrade: " + lumberjack.getUpgradeCost());
        lumberjackUpgrade.setBounds(50, 245,SCREEN_WIDTH-100 , 70);
        lumberjackUpgrade.setOpaque(false);
        lumberjackUpgrade.setContentAreaFilled(false);
        lumberjackUpgrade.setFocusable(false);
        lumberjackUpgrade.addActionListener(this);
        lumberjackUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lumberjackUpgrade.setForeground(Color.WHITE);
        lumberjackUpgrade.setHorizontalTextPosition(JButton.CENTER);

        farmUpgrade = new JButton("Farm upgrade: " + farm.getUpgradeCost());
        farmUpgrade.setBounds(50, 330,SCREEN_WIDTH-100 , 70);
        farmUpgrade.setOpaque(false);
        farmUpgrade.setContentAreaFilled(false);
        farmUpgrade.setFocusable(false);
        farmUpgrade.addActionListener(this);
        farmUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        farmUpgrade.setForeground(Color.WHITE);
        farmUpgrade.setHorizontalTextPosition(JButton.CENTER);

        fishermanUpgrade = new JButton("Fisherman upgrade: " + fisherman.getUpgradeCost());
        fishermanUpgrade.setBounds(50, 415,SCREEN_WIDTH-100 , 70);
        fishermanUpgrade.setOpaque(false);
        fishermanUpgrade.setContentAreaFilled(false);
        fishermanUpgrade.setFocusable(false);
        fishermanUpgrade.addActionListener(this);
        fishermanUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        fishermanUpgrade.setForeground(Color.WHITE);
        fishermanUpgrade.setHorizontalTextPosition(JButton.CENTER);

        forgeUpgrade = new JButton("Forge upgrade: " + forge.getUpgradeCost());
        forgeUpgrade.setBounds(50, 500,SCREEN_WIDTH-100 , 70);
        forgeUpgrade.setOpaque(false);
        forgeUpgrade.setContentAreaFilled(false);
        forgeUpgrade.setFocusable(false);
        forgeUpgrade.addActionListener(this);
        forgeUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        forgeUpgrade.setForeground(Color.WHITE);
        forgeUpgrade.setHorizontalTextPosition(JButton.CENTER);

        libraryUpgrade = new JButton("Library upgrade: " + library.getUpgradeCost());
        libraryUpgrade.setBounds(50, 585,SCREEN_WIDTH-100 , 70);
        libraryUpgrade.setOpaque(false);
        libraryUpgrade.setContentAreaFilled(false);
        libraryUpgrade.setFocusable(false);
        libraryUpgrade.addActionListener(this);
        libraryUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        libraryUpgrade.setForeground(Color.WHITE);
        libraryUpgrade.setHorizontalTextPosition(JButton.CENTER);

        churchUpgrade = new JButton("Church upgrade: " + church.getUpgradeCost());
        churchUpgrade.setBounds(50, 675,SCREEN_WIDTH-100 , 70);
        churchUpgrade.setOpaque(false);
        churchUpgrade.setContentAreaFilled(false);
        churchUpgrade.setFocusable(false);
        churchUpgrade.addActionListener(this);
        churchUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        churchUpgrade.setForeground(Color.WHITE);
        churchUpgrade.setHorizontalTextPosition(JButton.CENTER);

        shopBackground = new JLabel(background);
        shopBackground.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);


        panel = new JPanel();
        panel.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
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
        panel.add(shopBackground);

        window = new JFrame("Kingdom Tycoon | Shop");
        window.setSize(SCREEN_WIDTH+5, SCREEN_HEIGHT+5);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(panel);
        window.setIconImage(icon.getImage());
        return true;
    }

    // prepsat do jedne metody a tu pak vyvolavat

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == farmUpgrade) {
            if(balance.getActualBalance()>farm.getUpgradeCost() ) {
                farm.addLvl();
                farm.setUpgradeCost();
                balance.subtractBalance(farm.getUpgradeCost());
                balance.addPassiveIncome(farm.getPassiveBoost());
                balance.addClickIncome(farm.getClickBoost());

            }
        }
        if (e.getSource() == fishermanUpgrade) {
            if (balance.getActualBalance()>fisherman.getUpgradeCost()) {
                balance.subtractBalance(fisherman.getUpgradeCost());
                fisherman.addLvl();
                fisherman.setUpgradeCost();
                balance.subtractBalance(fisherman.getUpgradeCost());
                balance.addPassiveIncome(fisherman.getPassiveBoost());
                balance.addClickIncome(fisherman.getClickBoost());

            }
        }
        if (e.getSource() == forgeUpgrade) {
            if (balance.getActualBalance()>forge.getUpgradeCost()) {
                balance.subtractBalance(forge.getUpgradeCost());
                forge.addLvl();
                forge.setUpgradeCost();
                balance.subtractBalance(forge.getUpgradeCost());
                balance.addPassiveIncome(forge.getPassiveBoost());
                balance.addClickIncome(forge.getClickBoost());

            }
        }
        if (e.getSource() == libraryUpgrade) {
            if (balance.getActualBalance()>library.getUpgradeCost()) {
                balance.subtractBalance(library.getUpgradeCost());
                library.addLvl();
                library.setUpgradeCost();
                balance.subtractBalance(library.getUpgradeCost());
                balance.addPassiveIncome(library.getPassiveBoost());
                balance.addClickIncome(library.getClickBoost());

            }
        }
        if (e.getSource() == lumberjackUpgrade) {
            if (balance.getActualBalance()>lumberjack.getUpgradeCost()) {
                balance.subtractBalance(lumberjack.getUpgradeCost());
                lumberjack.addLvl();
                lumberjack.setUpgradeCost();
                balance.subtractBalance(lumberjack.getUpgradeCost());
                balance.addPassiveIncome(lumberjack.getPassiveBoost());
                balance.addClickIncome(lumberjack.getClickBoost());

            }
        }
        if (e.getSource() == townHallUpgrade) {
            if (balance.getActualBalance()>townHall.getUpgradeCost()) {
                balance.subtractBalance(townHall.getUpgradeCost());
                townHall.addLvl();
                townHall.setUpgradeCost();
                balance.subtractBalance(townHall.getUpgradeCost());
                balance.addPassiveIncome(townHall.getPassiveBoost());
                balance.addClickIncome(townHall.getClickBoost());

            }
        }
        if (e.getSource() == churchUpgrade){
            if (balance.getActualBalance()>church.getUpgradeCost()) {
                balance.subtractBalance(church.getUpgradeCost());
                church.addLvl();
                church.setUpgradeCost();
                balance.subtractBalance(church.getUpgradeCost());
                balance.addPassiveIncome(church.getPassiveBoost());
                balance.addClickIncome(church.getClickBoost());

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
