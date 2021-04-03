package psta.elements;

import psta.controllers.GameController;
import psta.opticsandsound.GameView;
import psta.opticsandsound.Sound;

import java.awt.*;

/**
 * Class for spawning explosions and destroying objects in explosion range
 */
public class Explosion implements Sound {

    private enum ExplosionStatus {SPREADING, WITHDRAWING}

    private enum ExplosionType {ATTACK, DEFEND}

    private ExplosionStatus explosionStatus;
    private final ExplosionType explosionType;
    private final java.awt.Rectangle hitBox;
    private final GameView gameView;
    private final GameController gameController;
    private final int currentX;
    private final int currentY;
    private final int destructionRange;
    private int radius;


    /**
     * Constructor for creating new defensive explosion
     *
     * @param gameView       object for graphical output
     * @param gameController object for managing all game elements
     * @param targetX        x coordinate of the explosion
     * @param targetY        y coordinate of the explosion
     */
    Explosion(GameView gameView, GameController gameController, int targetX, int targetY) {
        this.gameView = gameView;
        this.gameController = gameController;
        this.currentX = targetX;
        this.currentY = targetY;
        this.hitBox = new Rectangle();

        explosionType = ExplosionType.DEFEND;
        explosionStatus = ExplosionStatus.SPREADING;
        if (gameController.isGodMode()) {
            destructionRange = 100;
        } else {
            destructionRange = 60;
        }
        radius = 20;
        playSound();
    }

    /**
     * Constructor for creating new enemy explosion
     *
     * @param gameView         object for graphical output
     * @param gameController   object for managing all game elements
     * @param targetX          x coordinate of the explosion
     * @param targetY          y coordinate of the explosion
     * @param destructionRange destruction range, in which defensive elements are getting destroyed
     */
    Explosion(GameView gameView, GameController gameController, int targetX, int targetY, int destructionRange) {
        this.gameView = gameView;
        this.gameController = gameController;
        this.currentX = targetX;
        this.currentY = targetY;
        this.hitBox = new Rectangle();
        this.destructionRange = destructionRange;
        explosionType = ExplosionType.ATTACK;
        explosionStatus = ExplosionStatus.SPREADING;
        radius = 20;
        playSound();
    }

    /**
     * Method updates the current explosion by calculating and changing the explosion radius
     * checking for collisions in the radius and drawing the explosion in the game
     */
    public void updateCurrentExplosion() {
        calculateNewExplosionRadius();
        checkCollisionInRadius();
        drawExplosion();
    }


    @Override
    public void playSound() {
        if (explosionType == ExplosionType.DEFEND) {
            gameView.playSound("Explosion+3.wav", false);

        }
        if (explosionType == ExplosionType.ATTACK) {
            gameView.playSound("Explosion+5.wav", false);

        }
    }

    /**
     * Method for calculating the new explosion radius and removing the explosion after a certain radius is reached
     */
    public void calculateNewExplosionRadius() {

        if (explosionStatus == ExplosionStatus.SPREADING) {

            if (radius == destructionRange) {

                explosionStatus = ExplosionStatus.WITHDRAWING;

            }
            radius += 2;
        }
        if (explosionStatus == ExplosionStatus.WITHDRAWING) {

            radius -= 2;
            if (radius == 20) {
                gameController.explosionsList.remove(this);
            }
        }
    }

    /**
     * method draws the current explosion radius in the game
     */
    public void drawExplosion() {

        gameView.addOvalToCanvas(currentX, currentY, radius, radius, 5, true, Color.WHITE);

    }

    /**
     * method checks for collisions in the current explosion radius
     */
    public void checkCollisionInRadius() {
        updateHitBox();
        checkHitboxes();
    }

    /**
     * method updates hitbox of the current explosion
     */
    public void updateHitBox() {

        hitBox.x = currentX - radius;
        hitBox.y = currentY - radius;
        hitBox.height = (int) (radius * 1.5);
        hitBox.width = radius * 2;
    }

    /**
     * method checks the hitboxes of all other game objects that are affected by explosions and removes the corresponding objects of the game
     * For a defense explosion the method checks a collision with enemy missiles (normal and branched) and enemy aircraft
     * For an attack explosion the method checks a collision with missile bases and cities
     */
    public void checkHitboxes() {

        if (explosionType == ExplosionType.DEFEND) {

            for (int i = 0; i < gameController.enemyMissilesList.size(); i++) {

                if (hitBox.contains(gameController.enemyMissilesList.get(i).getCurrentX(), gameController.enemyMissilesList.get(i).getCurrentY())) {
                    gameController.enemyMissilesList.remove(i);
                }
            }
            for (int i = 0; i < gameController.enemyMissileBranchedList.size(); i++) {

                if (hitBox.contains(gameController.enemyMissileBranchedList.get(i).getCurrentX(), gameController.enemyMissileBranchedList.get(i).getCurrentY())) {
                    gameController.enemyMissileBranchedList.remove(i);
                }
            }

            for (int i = 0; i < gameController.enemyAircraftList.size(); i++) {

                if (hitBox.contains(gameController.enemyAircraftList.get(i).getCurrentX(), gameController.enemyAircraftList.get(i).getCurrentY())) {
                    gameController.enemyAircraftList.remove(i);
                }
            }
        }
        if (explosionType == ExplosionType.ATTACK) {

            for (int i = 0; i < gameController.citiesList.size(); i++) {

                if (hitBox.contains(gameController.citiesList.get(i).getPositionX(), gameController.citiesList.get(i).getPositionY())) {
                    gameController.citiesList.remove(i);
                }

            }
            for (int i = 0; i < gameController.missileBasesList.size(); i++) {

                if (hitBox.contains(gameController.missileBasesList.get(i).getPositionX(), gameController.missileBasesList.get(i).getPositionY())) {
                    gameController.missileBasesList.get(i).setDestroyed();
                }
            }
        }
    }
}