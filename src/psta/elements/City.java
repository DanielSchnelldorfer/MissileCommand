package psta.elements;

import psta.controllers.GameController;
import psta.opticsandsound.OpticalElements;
import psta.opticsandsound.GameView;

import java.util.Objects;

/**
 * Class for creating cities
 */
public class City implements Cloneable {


    protected enum CityStatus {INTACT, DESTROYED}

    protected City.CityStatus cityStatus;
    private int positionX;
    private int positionY;
    private final GameView gameView;
    private final OpticalElements opticalElements;


    /**
     * Constructor for creating new city objects
     *
     * @param positionX       the x coordinate of the city
     * @param positionY       the y coordinate of the city
     * @param gameView        object for graphical output
     * @param opticalElements object for graphical elements
     */
    public City(GameView gameView, OpticalElements opticalElements, int positionX, int positionY) {
        this.gameView = gameView;
        this.opticalElements = opticalElements;
        this.positionX = positionX;
        this.positionY = positionY;
        cityStatus = CityStatus.INTACT;
    }

    /**
     * method draws the city object in the game
     */
    public void drawCity() {

        gameView.addImageToCanvas(opticalElements.getCity(), positionX, positionY, 2);

    }

    /**
     * method for cloning city object
     * {@inheritDoc}
     */
    @Override
    public City clone() throws CloneNotSupportedException {
        City other = (City) super.clone();
        other.positionX = positionX;
        other.positionY = positionY;
        other.cityStatus = cityStatus;
        return other;
    }

    /**
     * method for comparing two city objects
     *
     * @param obj given object city
     * @return returns true if the city object are identical, if they are not identical, then false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        City other = (City) obj;
        return gameView.equals(other.gameView) && opticalElements.equals(other.opticalElements) && positionX == other.positionX && positionY == other.positionY && cityStatus.equals(other.cityStatus);
    }

    /**
     * method returns corresponding hash value for city
     *
     * @return hash value as integer for a city object
     */
    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY, cityStatus);  //andere Variablen/Objekte d. Klasse auch?
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    

}
