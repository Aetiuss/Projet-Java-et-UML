package model.entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Empty extends Entity{

    private char sprite = 'v';

    public Empty(int x, int y,Entity[][] map){
        super(x, y, map);
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    @Override
    public Image getImage() throws IOException
    {
        return ImageIO.read(new File("$PROJECT_DIR$\\sprites\\ground.png"));
    }
    
}
