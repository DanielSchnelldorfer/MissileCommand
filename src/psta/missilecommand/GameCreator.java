package psta.missilecommand;


import psta.controllers.GameController;
import psta.opticsandsound.GameStats;
import psta.opticsandsound.GameView;
import psta.opticsandsound.OpticalElements;

/**
 * Class for managing the game Levels.
 */
public class GameCreator {

    GameView gameView;
    Menu menu;
    OpticalElements opticalElements;
    GameController gameController;
    GameStats gameStats;
    MissileCommandMain missileCommandMain;

    /**
     * Constructor for new game creator Object.
     *
     * @param gameView        object for graphical output
     * @param menu            object for getting menu input
     * @param opticalElements object for graphical elements
     * @param gameController  object for managing all game elements
     * @param gameStats       object for showing game stats after level
     */
    GameCreator(GameView gameView, Menu menu
            , OpticalElements opticalElements, GameController gameController, GameStats gameStats, MissileCommandMain missileCommandMain) {
        this.gameView = gameView;
        this.menu = menu;
        this.opticalElements = opticalElements;
        this.gameController = gameController;
        this.gameStats = gameStats;
        this.missileCommandMain = missileCommandMain;

    }

    /**
     * Method creating every level as a new object gameController and calling method runNewLevel to start the Level,
     * also creating new object gameStats with methods waitMilliSeconds and showStats in order to wait two seconds and show stats for the level.
     */
    public void startPlaying() {

        //Level 1
        gameController = new GameController(1, gameView, opticalElements, menu);
        gameStats = new GameStats(gameView, gameController, opticalElements, missileCommandMain);
        gameController.runNewLevel();

        gameStats.waitMilliSeconds(1000);
        gameStats.showStats();

        //Level2
        gameController = new GameController(2, gameView, opticalElements, menu);
        gameStats = new GameStats(gameView, gameController, opticalElements, missileCommandMain);
        gameController.runNewLevel();

        gameStats.waitMilliSeconds(1000);
        gameStats.showStats();

        //Level3
        gameController = new GameController(3, gameView, opticalElements, menu);
        gameStats = new GameStats(gameView, gameController, opticalElements, missileCommandMain);
        gameController.runNewLevel();

        gameStats.waitMilliSeconds(2000);
        gameStats.showStats();

    }
}
