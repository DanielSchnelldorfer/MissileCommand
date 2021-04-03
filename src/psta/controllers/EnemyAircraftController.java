package psta.controllers;

import psta.elements.EnemyAircraft;
import psta.opticsandsound.GameView;
import psta.opticsandsound.OpticalElements;

/**
 * Class for initializing and updating enemy aircraft.
 */
public class EnemyAircraftController implements Controller {
    GameView gameView;
    OpticalElements opticalElements;
    GameController gameController;

    /**
     * Constructor for new enemy aircraft controller, only creates enemy aircraft in level 3.
     *
     * @param gameView        object for graphical output
     * @param opticalElements object containing graphical elements
     * @param gameController  object for managing all game elements
     */
    EnemyAircraftController(GameView gameView, OpticalElements opticalElements, GameController gameController) {
        this.gameView = gameView;
        this.opticalElements = opticalElements;
        this.gameController = gameController;
        if (gameController.getLevel() == 3) {
            gameController.enemyAircraftList.add(new EnemyAircraft(gameView, gameController, opticalElements));
            gameController.enemyAircraftList.add(new EnemyAircraft(gameView, gameController, opticalElements));
        }

    }

    /**
     * Method for currently updating all enemy aircraft objects.
     * {@inheritDoc}
     */
    @Override
    public void update() {
        for (int i = 0; i < gameController.enemyAircraftList.size(); i++) {
            gameController.enemyAircraftList.get(i).updateEnemyAircraft();
        }

    }
}
