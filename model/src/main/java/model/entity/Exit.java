package model.entity;

import contract.showboard.BoardFrame;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

/**
 * The class exit that allow to create an object that can be used to end the game
 *
 * @author Luc Anthoni
 * @version 1.2
 */
public class Exit extends Entity {

    /**
     * The unique instance of the class exit
     */
    static private Exit instance = new Exit();
    /**
     * Define if the exit can be used or not
     */
    private boolean exitIsOpen;
    /**
     * The score of the game
     */
    private int score = 0;

    /**
     * Constructor of the class Exit
     */
    private Exit() {
        super();
        loadImage();
    }

    /**
     * Get the unique instance of the class Exit
     *
     * @return Return the unique instance of the class Exit
     */
    public static Exit getInstance() {
        return instance;
    }

    /**
     * Allow the user to redefine coordinate while getting the instance
     *
     * @return the instance of the singleton if not created with coordinate
     */
    public static Exit getInstance(int x, int y, Entity[][] map) {
        instance.x = x;
        instance.y = y;
        instance.map = map;
        return instance;
    }

    /**
     * Get the sprite
     *
     * @return Return the sprite of the exit
     */
    @Override
    public char getSprite() {
        return 'e';
    }

    /**
     * Load an image from local folders
     */
    @Override
    public void loadImage() {

        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("sprites/portal.png")));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the Score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Check if the exit can open
     */
    void exitOpen() {
        if (score >= 100) {
            this.exitIsOpen = true;
            this.end();
        } else {
            this.exitIsOpen = false;
        }
    }

    /**
     * End the game if the score is high enough
     */
    public void end() {
        if (this.exitIsOpen) {
            Player.getInstance().die();
            BoardFrame.end();
        }
    }

}
