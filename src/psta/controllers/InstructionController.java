package psta.controllers;

import psta.opticsandsound.GameView;
import psta.opticsandsound.Instructions;
import psta.opticsandsound.OpticalElements;

/**
 * Class for initializing and updating player instructions (for 10 seconds) at the beginning of every level.
 */
public class InstructionController implements Controller {
    Instructions instructions;
    GameView gameView;
    OpticalElements opticalElements;

    /**
     * Constructor for creating new instruction controller object.
     *
     * @param gameView        object for graphical output
     * @param opticalElements object containing graphical elements
     */
    InstructionController(GameView gameView, OpticalElements opticalElements) {
        this.gameView = gameView;
        this.opticalElements = opticalElements;
        initializeInstructions();
    }

    /**
     * Method for currently updating the player instructions.
     */
    @Override
    public void update() {
        instructions.showInstructions();
    }

    /**
     * Method for initializing player instructions.
     */
    public void initializeInstructions() {

        instructions = new Instructions(gameView, opticalElements);
    }
}
