package psta.elements;


import psta.controllers.GameController;
import psta.opticsandsound.GameView;

/**
 * Class for spawning and initializing a new enemy missile
 * This class uses methods and variables from it's mother class
 */
public class EnemyMissile extends Missile {
    private int randomTargetObject;

    /**
     * Constructor of the class
     * When creating a new object enemyMissile the coordinates are chosen randomly
     *
     * @param gameView       object for graphical output
     * @param gameController object for managing all game elements
     */
    public EnemyMissile(GameView gameView, GameController gameController) {
        super(gameView, gameController);
        super.startX = (int) (Math.random() * (800 - 50 + 1) + 50);
        super.startY = (int) (Math.random() * (1 - 1000 + 1) + 1000) * -1;
        super.missileStatus = MissileStatus.INTACT;
        super.missileAffiliation = MissileAffiliation.ENEMY;
        branch = false;
        setLevelOfVelocity();
        setTarget();
        setVelocity(velocity);
        setTurbo(1);
        calculateIfMissileBranches();

    }

    /**
     * method chooses a random target object, gets the coordinates of the chosen target
     * and calculates the total path length from the start to the target
     * Additionally the method throws an exception if the chosen target number isn't a number
     * from 1 to 9
     */
    public void setTarget() {
        selectRandomTargetObject();
        setCoordinatesOfTarget();
        calculateTotalPathLength();
    }

    /**
     * method chooses for a given number (between 1 and 9) the corresponding target (missile base or city)
     * and hands over the coordinates of the target
     * If the target number isn't in the according interval, the method throws a TargetException
     */
    private void setCoordinatesOfTarget() {
        if (randomTargetObject >= 1 && randomTargetObject <= 9) {
            switch (randomTargetObject) {
                //citys
                case 1 -> {
                    targetX = 160;
                    targetY = 520;
                }
                case 2 -> {
                    targetX = 240;
                    targetY = 520;
                }
                case 3 -> {
                    targetX = 320;
                    targetY = 520;
                }
                case 4 -> {
                    targetX = 500;
                    targetY = 520;
                }
                case 5 -> {
                    targetX = 600;
                    targetY = 520;
                }
                case 6 -> {
                    targetX = 690;
                    targetY = 520;
                }
                //Bases
                case 7 -> {
                    targetX = 60;
                    targetY = 510;
                }
                case 8 -> {
                    targetX = 445;
                    targetY = 510;
                }
                case 9 -> {
                    targetX = 890;
                    targetY = 510;
                }

            }
        }

    }

    /**
     * method calculates a new random target number
     */
    private void selectRandomTargetObject() {
        randomTargetObject = (int) (Math.random() * (9 - 1 + 1) + 1);
    }

    /**
     * method sets the velocity of the missile for the corresponding game level
     */
    public void setLevelOfVelocity() {
        if (gameController.getLevel() == 1) {
            velocity = 25;
        }
        if (gameController.getLevel() == 2) {
            velocity = 15;
        }
        if (gameController.getLevel() == 3) {
            velocity = 10;
        }
    }

    /**
     * method calculates the probability if the enemy missile branches at a given y-coordinate
     * the chance of the missile to branch at height 100 or 150 is each 10%
     */
    public void calculateIfMissileBranches() {
        //10% each
        randomNumber = (int) (Math.random() * (10 - 1 + 1) + 1);
        if (randomNumber == 1) {
            branch = true;
            branchStartY = 100;
        }
        if (randomNumber == 2) {
            branch = true;
            branchStartY = 150;

        }

    }


}

