package psta.controllers;

import psta.elements.City;
import psta.opticsandsound.GameView;
import psta.opticsandsound.OpticalElements;

/**
 * Class for initializing all cities in the game and currently updating them.
 */
public class CityController implements Controller {

    GameView gameView;
    OpticalElements opticalElements;
    GameController gameController;

    /**
     * Constructor for new city controller object.
     *
     * @param gameView        object for graphical output
     * @param opticalElements object containing graphical elements
     * @param gameController  object for managing all game elements
     */
    CityController(GameView gameView, OpticalElements opticalElements, GameController gameController) {

        this.gameView = gameView;
        this.opticalElements = opticalElements;
        this.gameController = gameController;
        initializeCitys();
    }

    /**
     * Method for repeatedly updating all cities.
     * {@inheritDoc}
     */
    @Override
    public void update() {

        for (int i = 0; i < gameController.citiesList.size(); i++) {
            gameController.citiesList.get(i).drawCity();
        }
    }

    /**
     * Method for initializing all cities at the beginning of every level.
     */
    public void initializeCitys() {
        gameController.citiesList.add(new City(gameView, opticalElements, 160, 510));
        gameController.citiesList.add(new City(gameView, opticalElements, 240, 510));
        gameController.citiesList.add(new City(gameView, opticalElements, 320, 510));
        gameController.citiesList.add(new City(gameView, opticalElements, 500, 510));
        gameController.citiesList.add(new City(gameView, opticalElements, 600, 510));
        gameController.citiesList.add(new City(gameView, opticalElements, 690, 510));
    }
}
