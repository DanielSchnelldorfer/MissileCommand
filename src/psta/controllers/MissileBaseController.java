package psta.controllers;

import psta.elements.MissileBase;
import psta.opticsandsound.GameView;
import psta.opticsandsound.OpticalElements;

/**
 * Class for initializing and updating all missile bases.
 */
public class MissileBaseController implements Controller {
    GameView gameView;
    OpticalElements opticalElements;
    GameController gameController;

    /**
     * Constructor for creating new missile base controller.
     *
     * @param gameView        object for graphical output
     * @param opticalElements object with graphical elements
     * @param gameController  object for managing all game elements
     */
    MissileBaseController(GameView gameView, OpticalElements opticalElements, GameController gameController) {
        this.gameView = gameView;
        this.opticalElements = opticalElements;
        this.gameController = gameController;
        initializeMissileBases();
    }

    /**
     * Method for currently updating all missile bases.
     * {@inheritDoc}
     */
    @Override
    public void update() {
        for (int i = 0; i < gameController.missileBasesList.size(); i++) {
            gameController.missileBasesList.get(i).updateMissileBase();
        }

    }

    /**
     * Method for initializing all missile bases.
     */
    public void initializeMissileBases() {
        gameController.missileBasesList.add(new MissileBase(30, 500, 1, gameView, gameController, opticalElements));
        gameController.missileBasesList.add(new MissileBase(445, 500, 2, gameView, gameController, opticalElements));
        gameController.missileBasesList.add(new MissileBase(900, 500, 3, gameView, gameController, opticalElements));
    }
}
