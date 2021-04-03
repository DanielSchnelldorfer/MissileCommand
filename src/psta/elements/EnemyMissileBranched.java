package psta.elements;

import psta.controllers.GameController;
import psta.opticsandsound.GameView;

/**
 * Class for creating branched enemy missiles
 */
public class EnemyMissileBranched extends EnemyMissile {

    /**
     * Constructor for creating branched enemy missiles
     *
     * @param gameView       object for graphical output
     * @param gameController object for managing all game elements
     * @param currentX       x coordinate of the new branched enemy missile
     * @param currentY       y coordinate of the new branched enemy missile
     */
    public EnemyMissileBranched(GameView gameView, GameController gameController, int currentX, int currentY) {
        super(gameView, gameController);
        super.startX = currentX;
        super.startY = currentY;
        super.missileStatus = MissileStatus.INTACT;
        super.missileAffiliation = MissileAffiliation.ENEMY;
        setLevelOfVelocity();
        setTarget();
        setVelocity(velocity);
        setTurbo(1);


    }
}






