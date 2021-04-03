package psta.controllers;

/**
 * Class for updating all current existing explosions.
 */
public class ExplosionController implements Controller {
    GameController gameController;

    /**
     * Constructor for new explosion controller object.
     *
     * @param gameController object for managing all game elements
     */
    ExplosionController(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * Method for currently updating all current existing explosion objects.
     * {@inheritDoc}
     */
    @Override
    public void update() {
        for (int i = 0; i < gameController.explosionsList.size(); i++) {
            gameController.explosionsList.get(i).updateCurrentExplosion();
        }

    }
}
