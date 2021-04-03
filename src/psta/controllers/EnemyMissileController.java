package psta.controllers;

import psta.elements.EnemyMissile;
import psta.opticsandsound.GameView;
import psta.opticsandsound.OpticalElements;

/**
 * Class for initializing and updating all enemy missiles in the game.
 */
public class EnemyMissileController implements Controller {

    GameView gameView;
    OpticalElements opticalElements;
    GameController gameController;

    /**
     * Constructor for creating new enemy missile controller object.
     *
     * @param gameView        object for graphical output
     * @param opticalElements object containing graphical elements
     * @param gameController  object for managing all game elements
     */
    EnemyMissileController(GameView gameView, OpticalElements opticalElements, GameController gameController) {
        this.gameView = gameView;
        this.opticalElements = opticalElements;
        this.gameController = gameController;
        initializeEnemyMissiles();

    }

    /**
     * Method for initializing all enemy missiles per level.
     */
    public void initializeEnemyMissiles() {
        for (int i = 0; i < 18; i++) {
            gameController.enemyMissilesList.add(new EnemyMissile(gameView, gameController));
        }
    }

    /**
     * Method for currently updating all enemy missiles and branched enemy missiles.
     * {@inheritDoc}
     */
    @Override
    public void update() {

        for (int i = 0; i < gameController.enemyMissilesList.size(); i++) {
            gameController.enemyMissilesList.get(i).updateFlyingMissile();
        }
        for (int i = 0; i < gameController.enemyMissileBranchedList.size(); i++) {
            gameController.enemyMissileBranchedList.get(i).updateFlyingMissile();
        }
        checkEndOfLevel();
    }

    /**
     * Method repeatedly checks if the end of the game level is reached.
     */
    public void checkEndOfLevel() {
        if (gameController.enemyMissilesList.isEmpty()) {
            gameController.setGameToStopRunning();
        }
    }


}
