public class Start {

    /**
     * Initializes the game by creating the core components:
     *
     * {@link Balance} – Handles the player's coin balance.
     * {@link Menu} – Displays the main menu UI.
     * {@link GameLoop} – Manages the game's update and render cycle.
     *
     *
     * This constructor effectively starts a new game session.
     */
    public Start(){
        Balance balance = new Balance();
        Menu menu = new Menu(balance);
        GameLoop gameLoop = new GameLoop(balance);
    }
}
