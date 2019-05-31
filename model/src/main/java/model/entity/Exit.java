package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Exit extends Entity {
    
    static private Exit instance = new Exit();
    private        char sprite   = 'e';


    private int score = 0;
    
    private Exit()
    {
        super();
    }

    static public Exit getInstance() {
        return instance;
    }

    static public Exit getInstance(int x, int y, Entity[][] map) {
        instance.x = x;
        instance.y = y;
        instance.map = map;
        return instance;
    }

    @Override
    public char getSprite() {
        return sprite;
    }

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void displayScore() {

    }

}
