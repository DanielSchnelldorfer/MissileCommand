package psta.elements;

import psta.controllers.GameController;
import psta.opticsandsound.OpticalElements;
import psta.opticsandsound.GameView;

/**
 * Class for creating and printing MissileBases
 */
public class MissileBase {

    protected enum MissileBaseStatus {INTACT, DESTROYED}

    protected MissileBase.MissileBaseStatus missileBaseStatus;
    private final GameView gameView;
    private final OpticalElements opticalElements;
    private final GameController gameController;
    private final int positionX;
    private final int positionY;
    protected int missileBaseNumber;


    /**
     * Constructor for creating new missile Base
     *
     * @param positionX         x coordinate of the missile base
     * @param positionY         y coordinate of the missile base
     * @param missileBaseNumber identification number 1-3 of every missile base
     * @param gameView          object for graphical output
     * @param gameController    object for managing all game elements
     * @param opticalElements   object delivering string elements for graphical output
     */
    public MissileBase(int positionX, int positionY, int missileBaseNumber, GameView gameView, GameController gameController, OpticalElements opticalElements) {
        missileBaseStatus = MissileBaseStatus.INTACT;
        this.gameView = gameView;
        this.gameController = gameController;
        this.opticalElements = opticalElements;
        this.positionX = positionX;
        this.positionY = positionY;
        this.missileBaseNumber = missileBaseNumber;
        initializeStationedDefendMissiles();

    }

    /**
     * method for drawing und checking if the base has missiles left.
     * if the base has no missiles left, it's status is set to DESTROYED
     */
    public void updateMissileBase() {

        drawMissileBase();
        checkIfMissileSupplyIsEmpty();

    }

    /**
     * initializes for every base (number 1-3) the corresponding stationedDefendMissiles-ArrayList with objects of type stationedDefendMissile
     */
    public void initializeStationedDefendMissiles() {
        if (missileBaseNumber == 1) {

            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 50, 515));
            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 60, 515));
            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 70, 515));
            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 80, 515));

            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 55, 510));
            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 65, 510));
            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 75, 510));

            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 60, 505));
            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 70, 505));

            gameController.stationedDefendMissilesListB1.add(new StationedDefendMissile(gameView, opticalElements, 65, 500));

        }
        if (missileBaseNumber == 2) {

            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 415, 515));
            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 425, 515));
            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 435, 515));
            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 445, 515));

            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 420, 510));
            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 430, 510));
            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 440, 510));

            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 425, 505));
            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 435, 505));

            gameController.stationedDefendMissilesListB2.add(new StationedDefendMissile(gameView, opticalElements, 430, 500));

        }
        if (missileBaseNumber == 3) {


            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 850, 515));
            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 860, 515));
            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 870, 515));
            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 880, 515));

            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 855, 510));
            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 865, 510));
            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 875, 510));

            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 870, 505));
            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 860, 505));

            gameController.stationedDefendMissilesListB3.add(new StationedDefendMissile(gameView, opticalElements, 865, 500));

        }

    }

    /**
     * method draws each intact missileBase (or rather the stationed defend missiles) that are still contained in the ArrayLists
     * if the status of the base is destroyed, the missile base gets removed from the ArrayList and wont be printed anymore
     */
    public void drawMissileBase() {

        if (missileBaseStatus == MissileBaseStatus.INTACT) {

            if (missileBaseNumber == 1) {
                for (int i = 0; i < gameController.stationedDefendMissilesListB1.size(); i++) {
                    gameController.stationedDefendMissilesListB1.get(i).printStationedDefendMissile();
                }
            }
            if (missileBaseNumber == 2) {
                for (int i = 0; i < gameController.stationedDefendMissilesListB2.size(); i++) {
                    gameController.stationedDefendMissilesListB2.get(i).printStationedDefendMissile();
                }
            }
            if (missileBaseNumber == 3) {
                for (int i = 0; i < gameController.stationedDefendMissilesListB3.size(); i++) {
                    gameController.stationedDefendMissilesListB3.get(i).printStationedDefendMissile();
                }

            }

        }
        if (missileBaseStatus == MissileBaseStatus.DESTROYED) {
            clearStationedDefendMissilesOfList();
        }
    }

    /**
     * method checks if the ArrayList containing the stationed defend missiles is empty
     * if the the list is empty the corresponding missile base is set destroyed
     */
    public void checkIfMissileSupplyIsEmpty() {
        if (gameController.stationedDefendMissilesListB1.isEmpty()) {
            gameController.missileBasesList.get(0).setDestroyed();
        }
        if (gameController.stationedDefendMissilesListB2.isEmpty()) {
            gameController.missileBasesList.get(1).setDestroyed();    //new approach
        }
        if (gameController.stationedDefendMissilesListB3.isEmpty()) {
            gameController.missileBasesList.get(2).setDestroyed();
        }
    }

    /**
     * method removes all objects of the corresponding stationed defend missiles list
     */
    public void clearStationedDefendMissilesOfList() {
        if (missileBaseNumber == 1) {
            gameController.stationedDefendMissilesListB1.clear();
        }
        if (missileBaseNumber == 2) {
            gameController.stationedDefendMissilesListB2.clear();
        }
        if (missileBaseNumber == 3) {
            gameController.stationedDefendMissilesListB3.clear();
        }
    }

    public void setDestroyed() {
        missileBaseStatus = MissileBaseStatus.DESTROYED;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

}
