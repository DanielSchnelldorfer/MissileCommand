package psta.elements;

import psta.controllers.GameController;
import psta.opticsandsound.GameView;
import psta.opticsandsound.Sound;

/**
 * Class for initializing a new defense missile
 */
public class DefendMissile extends Missile implements Sound {
    private int baseNumber;
    private boolean basesAreDestroyed;

    /**
     * Constructor creates a new defend missile object with a certain starting point
     *
     * @param gameView       object for graphical output
     * @param gameController object for managing all game elements
     * @param targetX        target x coordinate
     * @param targetY        target y coordinate
     */
    public DefendMissile(GameView gameView, GameController gameController, int targetX, int targetY) {
        super(gameView, gameController);
        super.missileStatus = MissileStatus.INTACT;
        super.missileAffiliation = MissileAffiliation.DEFENSIVE;
        super.targetX = targetX;
        super.targetY = targetY;
        super.calculateTotalPathLength();
        startDefendMissile();

    }

    /**
     * method starts the defend missile by setting its velocity, choosing the next intact missile base as a starting point,
     * removing a stationed defend missile from the corresponding base and playing a sound for the starting defend missile
     */
    public void startDefendMissile() {
        setVelocity(1);
        setTurbo(10);
        checkIfAllBasesAreDestroyed();
        chooseIntactAndSuppliedBase();
        getCoordinatesOfBase();
        removeStationedDefendMissileFromBase();
        playSound();

    }

    /**
     * method checks if all bases are destroyed
     */
    private void checkIfAllBasesAreDestroyed() {

        if (gameController.missileBasesList.get(0).missileBaseStatus == MissileBase.MissileBaseStatus.DESTROYED && gameController.missileBasesList.get(1).missileBaseStatus == MissileBase.MissileBaseStatus.DESTROYED && gameController.missileBasesList.get(2).missileBaseStatus == MissileBase.MissileBaseStatus.DESTROYED) {
            basesAreDestroyed = true;
            gameController.setNoMissilesLeft();
        } else {
            basesAreDestroyed = false;
        }
    }

    /**
     * method chooses the next intact and supplied missile base and sets the corresponding base number
     */
    public void chooseIntactAndSuppliedBase() {

        if (!basesAreDestroyed) {

            //LinkesFeld
            if ((targetX <= 300)) {
                if ((gameController.missileBasesList.get(0).missileBaseStatus == MissileBase.MissileBaseStatus.INTACT) && (!gameController.stationedDefendMissilesListB1.isEmpty())) {
                    baseNumber = 1;
                }
                if ((gameController.missileBasesList.get(0).missileBaseStatus == MissileBase.MissileBaseStatus.DESTROYED)) {
                    //check the others
                    if ((gameController.missileBasesList.get(1).missileBaseStatus == MissileBase.MissileBaseStatus.INTACT) && (!gameController.stationedDefendMissilesListB2.isEmpty())) {
                        baseNumber = 2;
                    }
                    if ((gameController.missileBasesList.get(1).missileBaseStatus == MissileBase.MissileBaseStatus.DESTROYED)) {
                        baseNumber = 3;
                    }
                }
            }
            //mittleresFeld
            if ((targetX <= 600 && targetX > 300)) {
                if ((gameController.missileBasesList.get(1).missileBaseStatus == MissileBase.MissileBaseStatus.INTACT) && (!gameController.stationedDefendMissilesListB2.isEmpty())) {
                    baseNumber = 2;
                }
                if ((gameController.missileBasesList.get(1).missileBaseStatus == MissileBase.MissileBaseStatus.DESTROYED)) {
                    //check the others
                    if ((gameController.missileBasesList.get(2).missileBaseStatus == MissileBase.MissileBaseStatus.INTACT) && (!gameController.stationedDefendMissilesListB3.isEmpty())) {
                        baseNumber = 3;
                    }
                    if ((gameController.missileBasesList.get(2).missileBaseStatus == MissileBase.MissileBaseStatus.DESTROYED)) {
                        baseNumber = 1;
                    }
                }
            }
            //rechtes Feld
            if ((targetX > 600 && targetX <= 956)) {
                if ((gameController.missileBasesList.get(2).missileBaseStatus == MissileBase.MissileBaseStatus.INTACT) && (!gameController.stationedDefendMissilesListB3.isEmpty())) {
                    baseNumber = 3;
                }
                if ((gameController.missileBasesList.get(2).missileBaseStatus == MissileBase.MissileBaseStatus.DESTROYED)) {  //||EMPTY
                    //check the others
                    if ((gameController.missileBasesList.get(1).missileBaseStatus == MissileBase.MissileBaseStatus.INTACT) && (!gameController.stationedDefendMissilesListB2.isEmpty())) {
                        baseNumber = 2;
                    }
                    if ((gameController.missileBasesList.get(1).missileBaseStatus == MissileBase.MissileBaseStatus.DESTROYED)) {
                        baseNumber = 1;
                    }
                }
            }
        }
    }

    /**
     * method gets the coordinates of the missile base for the corresponding base number
     */
    public void getCoordinatesOfBase() {

        if (baseNumber == 1) {
            startX = 75;
            startY = 500;
        }
        if (baseNumber == 2) {
            startX = 440;
            startY = 500;
        }
        if (baseNumber == 3) {
            startX = 870;
            startY = 500;
        }

    }

    /**
     * method removes the a stationed defend missile object from the corresponding missile base, if there is a missile left
     */
    public void removeStationedDefendMissileFromBase() {

        if (baseNumber == 1) {
            if (!gameController.stationedDefendMissilesListB1.isEmpty()) {
                gameController.stationedDefendMissilesListB1.remove(gameController.stationedDefendMissilesListB1.size() - 1);
            }
        }


        if (baseNumber == 2) {
            if (!gameController.stationedDefendMissilesListB2.isEmpty()) {
                gameController.stationedDefendMissilesListB2.remove(gameController.stationedDefendMissilesListB2.size() - 1);
            }
        }

        if (baseNumber == 3) {
            if (!gameController.stationedDefendMissilesListB3.isEmpty()) {
                gameController.stationedDefendMissilesListB3.remove(gameController.stationedDefendMissilesListB3.size() - 1);

            }
        }
    }

    /**
     * method plays a sound for a starting defense missile
     * {@inheritDoc}
     */
    @Override
    public void playSound() {
        gameView.playSound("DefendMissileSound.wav", false);
    }
}
