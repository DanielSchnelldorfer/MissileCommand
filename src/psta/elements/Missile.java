package psta.elements;

import psta.controllers.GameController;
import psta.opticsandsound.GameView;

import java.awt.*;

/**
 * Class Missile is mother class of enemy missile and defense missile. The class passes on important mehods and variables to it's child classes
 * The class updates and prints flying missiles
 */
public class Missile {

    protected enum MissileStatus {INTACT, DESTROYED}

    protected enum MissileAffiliation {ENEMY, DEFENSIVE}

    protected MissileStatus missileStatus;
    protected MissileAffiliation missileAffiliation;
    protected int startX;
    protected int startY;
    protected int velocity;
    private int turbo;
    private int currentX;
    private int currentY;
    private int currentPathLength;
    private int totalPathLength;
    protected int targetX;
    protected int targetY;
    protected boolean branch;
    protected int branchStartY;
    protected int randomNumber;
    protected GameView gameView;
    protected GameController gameController;
    private long lastTime;

    /**
     * Constructor of the class
     *
     * @param gameView       object for graphical output
     * @param gameController object for managing all game elements
     */
    public Missile(GameView gameView, GameController gameController) {
        this.gameView = gameView;
        this.gameController = gameController;

    }

    /**
     * method for updating and calculating the flight route of a missile
     */
    public void updateFlyingMissile() {
        long now = System.currentTimeMillis();
        long timePassed = now - lastTime;
        if (timePassed > velocity) {

            if (currentPathLength < totalPathLength && missileStatus == MissileStatus.INTACT) {

                calculateNewCoordinates();
                lastTime = now;
            }
            if ((missileAffiliation == MissileAffiliation.ENEMY && branch) && currentY == branchStartY && (gameController.getLevel() == 2 || gameController.getLevel() == 3)) {
                if (branchStartY == 100) {
                    spawnBranchedMissiles(4);
                }
                if (branchStartY == 150) {
                    spawnBranchedMissiles(2);
                }

            }
            if (currentPathLength >= totalPathLength) {
                missileStatus = MissileStatus.DESTROYED;
                spawnExplosion();
                clearMissilePath();
            }

        }
        drawMissileAndPathLine();

    }

    /**
     * method spawns a given number of branched missiles at the current position of the missile
     *
     * @param anzahl the number of new branched missiles
     */
    public void spawnBranchedMissiles(int anzahl) {

        for (int i = 0; i < anzahl; i++) {
            gameController.enemyMissileBranchedList.add(new EnemyMissileBranched(gameView, gameController, currentX, currentY));
        }

    }

    /**
     * method spawns an explosion at the current position of the missile in the game
     * if the missile is an enemy missile, an enemy explosion is spawned, for a defense missile a defense explosion is spawned
     */
    public void spawnExplosion() {

        if (missileAffiliation == MissileAffiliation.ENEMY) {
            gameController.explosionsList.add(new Explosion(gameView, gameController, targetX, targetY,40));
        }
        if (missileAffiliation == MissileAffiliation.DEFENSIVE) {
            gameController.explosionsList.add(new Explosion(gameView, gameController, targetX, targetY));

        }

    }

    /**
     * method clears the missile path by removing the missile from the corresponding array list
     */
    public void clearMissilePath() {

        if (missileAffiliation == MissileAffiliation.ENEMY) {
            gameController.enemyMissilesList.remove(this);
        }
        if (missileAffiliation == MissileAffiliation.ENEMY) {
            gameController.enemyMissileBranchedList.remove(this);
        }

        if (missileAffiliation == MissileAffiliation.DEFENSIVE) {
            gameController.defendMissilesList.remove(this);
        }
    }

    /**
     * method draws the missile together with the missile path
     */
    public void drawMissileAndPathLine() {
        gameView.addOvalToCanvas(currentX, currentY, 2, 2, 2, true, Color.WHITE);
        if (missileAffiliation == MissileAffiliation.ENEMY) {
            gameView.addLineToCanvas(startX, startY, currentX, currentY, 2, Color.RED);
        }
        if (missileAffiliation == MissileAffiliation.DEFENSIVE) {
            gameView.addLineToCanvas(startX, startY, currentX, currentY, 2, Color.BLUE);
        }


    }

    /**
     * method calculates the total path length between the start and target coordinates
     */
    public void calculateTotalPathLength() {
        int distanceTargetAndStartX = (targetX - startX);
        int distanceTargetAndStartY = (targetY - startY);

        totalPathLength = (int) Math.sqrt(distanceTargetAndStartX * distanceTargetAndStartX + distanceTargetAndStartY * distanceTargetAndStartY);

    }

    /**
     * method calculates the new coordinates for the flying missile
     */
    public void calculateNewCoordinates() {

        currentPathLength += turbo;

        currentX = startX + (int) ((double) (targetX - startX) * ((double) currentPathLength / (double) totalPathLength));
        currentY = startY + (int) ((double) (targetY - startY) * ((double) currentPathLength / (double) totalPathLength));
    }

    public void setVelocity(int speedLevel) {
        velocity = speedLevel;
    }

    public void setTurbo(int speedLevel) {
        turbo = speedLevel;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }
}