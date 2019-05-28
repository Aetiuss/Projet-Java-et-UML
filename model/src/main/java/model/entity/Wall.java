package model.entity;

import model.entity.entityBehaviours.FallableDestrutable;
import model.entity.entityBehaviours.IDestructable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Wall extends Entity
{
    
    IDestructable destructable;
    private char sprite = 'w';
    
    @Override
    public Image getImage() throws IOException
    {
        return ImageIO.read(new File("$PROJECT_DIR$\\sprites\\wall.png"));
    }
    public Wall(int x, int y, Entity[][] map)
    {
        super(x, y, map);
        destructable = new FallableDestrutable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
