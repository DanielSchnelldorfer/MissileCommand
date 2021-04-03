package psta.controllers;

import java.awt.event.MouseEvent;

import psta.elements.DefendMissile;
import psta.opticsandsound.GameView;
import psta.opticsandsound.OpticalElements;

/**
 * Class for adding and currently updating defense missiles.
 */
public class DefendMissileController implements Controller {
    GameView gameView;
    OpticalElements opticalElements;
    GameController gameController;

    /**
     * Constructor for new defense missile controller object.
     *
     * @param gameView        object for graphical output
     * @param opticalElements object containing graphical elements
     * @param gameController  object for managing all game elements
     */
    DefendMissileController(GameView gameView, OpticalElements opticalElements, GameController gameController) {
        this.gameView = gameView;
        this.opticalElements = opticalElements;
        this.gameController = gameController;
    }

    /**
     * Method currently checks mouse events and spawns a new defense missile if the mouse is clicked
     * existing defense missiles are also currently updated.
     */
    @Override
    public void update() {

        MouseEvent[] mouseEvents = gameView.pollMouseEvents();
        for (MouseEvent mouseEvent : mouseEvents) {
            if (mouseEvent.getID() == MouseEvent.MOUSE_PRESSED) {
                if (gameController.getMissilesAlreadyAdded() < gameController.getMissileSupply()) {
                    gameController.defendMissilesList.add(new DefendMissile(gameView, gameController, mouseEvent.getX(), mouseEvent.getY()));
                    gameController.setMissilesAlreadyAdded(1);
                }
            }
        }
        for (int i = 0; i < gameController.defendMissilesList.size(); i++) {
            gameController.defendMissilesList.get(i).updateFlyingMissile();
        }
    }

}
