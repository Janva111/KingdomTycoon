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
    private JButton quitButton;
    private JButton playButton;
    private ImageIcon icon = new ImageIcon("MainImages/Icon.png");

    private Church church;
    private Farm farm;
    private Forge forge;
    private Fisherman fisherman;
    private Library library;
    private Lumberjack lumberjack;
    private TownHall townHall;

    private Balance balance;

    public Shop(Church church, Farm farm, Forge forge,Fisherman fisherman, Library library,Lumberjack lumberjack, TownHall townHall) {
        this.church = church;
        this.farm = farm;
        this.forge = forge;
        this.fisherman = fisherman;
        this.library = library;
        this.lumberjack = lumberjack;
        this.townHall = townHall;

        createWindow();
    }


    public boolean createWindow() {

        townHallUpgrade = new JButton("TownHall upgrade: " + townHall.getUpgradeCost());
        townHallUpgrade.setBounds(50, 60,SCREEN_WIDTH-100 , 90);
        townHallUpgrade.setOpaque(false);
        townHallUpgrade.setContentAreaFilled(false);
        townHallUpgrade.setFocusable(false);
        townHallUpgrade.addActionListener(this);
        townHallUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        townHallUpgrade.setHorizontalTextPosition(JButton.CENTER);
        //townHallUpgrade.setBorderPainted(false);

        lumberjackUpgrade = new JButton("Lumberjack upgrade: " + lumberjack.getUpgradeCost());
        lumberjackUpgrade.setBounds(50, 160,SCREEN_WIDTH-100 , 90);
        lumberjackUpgrade.setOpaque(false);
        lumberjackUpgrade.setContentAreaFilled(false);
        lumberjackUpgrade.setFocusable(false);
        lumberjackUpgrade.addActionListener(this);
        lumberjackUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lumberjackUpgrade.setHorizontalTextPosition(JButton.CENTER);
        //lumberjackUpgrade.setBorderPainted(false);

        farmUpgrade = new JButton("Farm upgrade: " + farm.getUpgradeCost());
        farmUpgrade.setBounds(50, 260,SCREEN_WIDTH-100 , 90);
        farmUpgrade.setOpaque(false);
        farmUpgrade.setContentAreaFilled(false);
        farmUpgrade.setFocusable(false);
        farmUpgrade.addActionListener(this);
        farmUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        farmUpgrade.setHorizontalTextPosition(JButton.CENTER);
        //farmUpgrade.setBorderPainted(false);

        fishermanUpgrade = new JButton("Fisherman upgrade: " + fisherman.getUpgradeCost());
        fishermanUpgrade.setBounds(50, 360,SCREEN_WIDTH-100 , 90);
        fishermanUpgrade.setOpaque(false);
        fishermanUpgrade.setContentAreaFilled(false);
        fishermanUpgrade.setFocusable(false);
        fishermanUpgrade.addActionListener(this);
        fishermanUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        fishermanUpgrade.setHorizontalTextPosition(JButton.CENTER);
        //fishermanUpgrade.setBorderPainted(false);

        forgeUpgrade = new JButton("Forge upgrade: " + forge.getUpgradeCost());
        forgeUpgrade.setBounds(50, 460,SCREEN_WIDTH-100 , 90);
        forgeUpgrade.setOpaque(false);
        forgeUpgrade.setContentAreaFilled(false);
        forgeUpgrade.setFocusable(false);
        forgeUpgrade.addActionListener(this);
        forgeUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        forgeUpgrade.setHorizontalTextPosition(JButton.CENTER);
        //forgeUpgrade.setBorderPainted(false);

        libraryUpgrade = new JButton("Library upgrade: " + library.getUpgradeCost());
        libraryUpgrade.setBounds(50, 560,SCREEN_WIDTH-100 , 90);
        libraryUpgrade.setOpaque(false);
        libraryUpgrade.setContentAreaFilled(false);
        libraryUpgrade.setFocusable(false);
        libraryUpgrade.addActionListener(this);
        libraryUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        libraryUpgrade.setHorizontalTextPosition(JButton.CENTER);
        //libraryUpgrade.setBorderPainted(false);

        churchUpgrade = new JButton("Church upgrade: " + church.getUpgradeCost());
        churchUpgrade.setBounds(50, 660,SCREEN_WIDTH-100 , 90);
        churchUpgrade.setOpaque(false);
        churchUpgrade.setContentAreaFilled(false);
        churchUpgrade.setFocusable(false);
        churchUpgrade.addActionListener(this);
        churchUpgrade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        churchUpgrade.setHorizontalTextPosition(JButton.CENTER);
        //churchUpgrade.setBorderPainted(false);

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

    // aktualizovat furt pres vedlejsi metodu co budu vyvolavat pro aktualizaci treba vytvaret znovu panel

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == farmUpgrade) {

        }
        if (e.getSource() == fishermanUpgrade) {

        }
        if (e.getSource() == forgeUpgrade) {

        }
        if (e.getSource() == libraryUpgrade) {

        }
        if (e.getSource() == lumberjackUpgrade) {

        }
        if (e.getSource() == townHallUpgrade) {

        }
        if (e.getSource() == churchUpgrade){

        }
        if (e.getSource() == playButton) {

        }
        if (e.getSource() == quitButton) {

        }
    }
}
