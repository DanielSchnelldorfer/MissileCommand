package psta.missilecommand;

import psta.controllers.GameController;
import psta.opticsandsound.OpticalElements;
import psta.opticsandsound.GameStats;
import psta.opticsandsound.GameView;

/**
 * The class containing the main-method and starting the game.
 */
public class MissileCommandMain {
    GameView gameView = new GameView();
    Menu menu = new Menu(gameView);
    OpticalElements opticalElements = new OpticalElements();
    GameController gameController = new GameController(0, gameView, opticalElements, menu);
    GameStats gameStats = new GameStats(gameView, gameController, opticalElements, this);
    GameCreator gameCreator = new GameCreator(gameView, menu, opticalElements, gameController, gameStats, this);
    private final boolean USE_MOUSE = true;
    private boolean gameRunning = true;

    /**
     * Constructor of the main class, for adjusting and controlling mouse settings.
     */
    private MissileCommandMain() {
        if (USE_MOUSE) {
            gameView.useMouse(true);
            gameView.setMouseCursor("Cursor.png", true);
        }
    }

    /**
     * Main method creates new object of main class and starts the game with method runGame.
     */
    public static void main(String[] args) {

        new MissileCommandMain().runGame();
    }

    /**
     * Method starts the menu and creates new game repeatedly as long as the game is running.
     */
    private void runGame() {
        while (gameRunning) {
            menu.startMenue();
            new GameCreator(gameView, menu, opticalElements, gameController, gameStats, this).startPlaying();

        }
    }

    /**
     * Method stops the game at the end of level three, if required.
     */
    public void setGameToStop() {
        gameRunning = false;
    }


}