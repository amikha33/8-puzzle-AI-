public class GameEngine {

    private static GameEngine ourInstance = new GameEngine();

    private GameEngine(){

    }

    public static GameEngine getInstance() {
        return ourInstance;
    }
}
