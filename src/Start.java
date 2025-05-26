public class Start {
    public Start(){
        Balance balance = new Balance();
        Menu menu = new Menu(balance);
        GameLoop gameLoop = new GameLoop(balance);
    }
}
