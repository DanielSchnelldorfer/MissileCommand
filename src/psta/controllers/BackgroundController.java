package psta.controllers;

import psta.opticsandsound.GameView;
import psta.opticsandsound.OpticalElements;

/**
 * Class for initializing and currently updating the background in the game.
 */
public class BackgroundController implements Controller {
    GameView gameView;
    OpticalElements opticalElements;

    /**
     * Constructor for new background controller object.
     *
     * @param gameView        object for graphical output
     * @param opticalElements object for graphical elements
     */
    BackgroundController(GameView gameView, OpticalElements opticalElements) {
        this.gameView = gameView;
        this.opticalElements = opticalElements;

    }

    /**
     * Method for currently updating (drawing) the background.
     * {@inheritDoc}
     */
    @Override
    public void update() {
        gameView.addImageToCanvas(opticalElements.getMountains(), 0, 490, 4);
    }
}
