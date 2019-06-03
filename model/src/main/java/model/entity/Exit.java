package model.entity;

import contract.showboard.BoardFrame;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Exit extends Entity {
    
    static private Exit instance = new Exit();
    private        char sprite   = 'e';


    private int score = 0;
    boolean exitIsOpen;
    
    private Exit()
    {
        super();
    }

    /**
     * @return the instance of the singleton
     */
    public static Exit getInstance() {
        return instance;
    }

    /**
     *
     *
     * @return the instance of the singleton if not created with coordonate
     */
    public static Exit getInstance(int x, int y, Entity[][] map) {
        instance.x = x;
        instance.y = y;
        instance.map = map;
        return instance;
    }

    /**
     *
     *
     * @return the sprite
     */
    @Override
    public char getSprite() {
        return sprite;
    }

    /**
     *
     *
     * load the sprite
     */
    @Override
    public void loadImage() {

        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("./sprites/nether_portal.png"));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *
     * get the Score
     */
    public int getScore() {
        return score;
    }

    /**
     *
     *
     * set the Score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     *
     * check if the exit can open
     */
    public void exitOpen() {
        if (score >= 100) {
            this.exitIsOpen = true;
            this.end();
        } else {
            this.exitIsOpen = false;
        }
    }

    /**
     *
     *
     * end the game if the score is high enough
     */
    public void end() {
        if (this.exitIsOpen == true) {
            BoardFrame.end();
        }
    }

}
