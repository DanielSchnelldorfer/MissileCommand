package psta.controllers;

import psta.elements.*;
import psta.missilecommand.Menu;
import psta.opticsandsound.OpticalElements;
import psta.opticsandsound.GameView;
import psta.opticsandsound.Sound;

import java.util.ArrayList;

/**
 * Class for initializing, updating and managing all game elements for every level
 * The class stores all game objects in central arraylists that are managed (initialized) by all different controller objects
 * and repeatedly updated.
 */
public class GameController implements Controller, Sound {

    private final GameView gameView;
    private final OpticalElements opticalElements;
    private final Menu menu;
    private final int level;
    private final int missileSupply;
    private int missilesAlreadyAdded;
    private final boolean godMode;
    private boolean gameRunning;
    ArrayList<Controller> controllers = new ArrayList<>();
    public ArrayList<City> citiesList = new ArrayList<>(6);
    public ArrayList<EnemyMissile> enemyMissilesList = new ArrayList<EnemyMissile>(18);
    public ArrayList<EnemyMissileBranched> enemyMissileBranchedList = new ArrayList<>(20);
    public ArrayList<EnemyAircraft> enemyAircraftList = new ArrayList<>(2);
    public ArrayList<Explosion> explosionsList = new ArrayList<>(48);
    public ArrayList<DefendMissile> defendMissilesList = new ArrayList<>(30);
    public ArrayList<MissileBase> missileBasesList = new ArrayList<>(3);
    public ArrayList<StationedDefendMissile> stationedDefendMissilesListB1 = new ArrayList<StationedDefendMissile>(10);
    public ArrayList<StationedDefendMissile> stationedDefendMissilesListB2 = new ArrayList<StationedDefendMissile>(10);
    public ArrayList<StationedDefendMissile> stationedDefendMissilesListB3 = new ArrayList<StationedDefendMissile>(10);

    /**
     * Constructor for creating a new game controller.
     *
     * @param level           the current game level
     * @param gameView        object for graphical output
     * @param opticalElements object containing graphical elements
     * @param menu            object for querying settings of the menue
     */
    public GameController(int level, GameView gameView, OpticalElements opticalElements, Menu menu) {
        this.level = level;
        this.gameView = gameView;
        this.opticalElements = opticalElements;
        this.menu = menu;
        missileSupply = 30;
        godMode = menu.getGodMode();
        gameRunning = true;
        playSound();

        var backgroundController = new BackgroundController(gameView, opticalElements);
        var instructionController = new InstructionController(gameView, opticalElements);
        var missileBaseController = new MissileBaseController(gameView, opticalElements, this);
        var cityController = new CityController(gameView, opticalElements, this);
        var missileController = new EnemyMissileController(gameView, opticalElements, this);
        var enemyAircraftController = new EnemyAircraftController(gameView, opticalElements, this);
        var explosionController = new ExplosionController(this);
        var defendMissileController = new DefendMissileController(gameView, opticalElements, this);

        controllers.add(backgroundController);
        controllers.add(instructionController);
        controllers.add(missileBaseController);
        controllers.add(cityController);
        controllers.add(missileController);
        controllers.add(enemyAircraftController);
        controllers.add(explosionController);
        controllers.add(defendMissileController);
    }

    /**
     * Method for updating all controller elements and printing game.
     * {@inheritDoc}
     */
    @Override
    public void update() {
        for (var controller : controllers) {
            controller.update();
        }
        gameView.printCanvas();
    }

    /**
     * Method for repeatedly updating the game.
     */
    public void runNewLevel() {
        while (gameRunning) {
            update();
        }
    }

    /**
     * Method for playing the constant background sound of the game.
     * {@inheritDoc}
     */
    @Override
    public void playSound() {
        gameView.playSound("RocketsIncoming.wav", true);
    }

    /**
     * Method is stopping the game.
     */
    public void setGameToStopRunning() {
        gameRunning = false;
    }

    /**
     * Method clears missile supply.
     */
    public void setNoMissilesLeft() {
        missilesAlreadyAdded = missileSupply;
    }

    /**
     * Adds a certain number of missiles to the "fired missiles"-list.
     *
     * @param number the number of fired missiles that is added to the list.
     */
    public void setMissilesAlreadyAdded(int number) {
        missilesAlreadyAdded += number;
    }

    /**
     * Method returns the defend missiles, that have been already fired per level.
     *
     * @return the number of fired defend missiles.
     */
    public int getMissilesAlreadyAdded() {
        return missilesAlreadyAdded;
    }

    /**
     * Method returns the defend missiles, that are left per missile base.
     *
     * @return the number of left missiles
     */
    public int getMissileSupply() {
        return missileSupply;
    }

    /**
     * Method returns the current game level.
     *
     * @return the current game level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Method checks, if godMode is activated and returns boolean value, regarding godMode.
     *
     * @return if godMode is activated or not.
     */
    public boolean isGodMode() {
        return godMode;
    }


}


