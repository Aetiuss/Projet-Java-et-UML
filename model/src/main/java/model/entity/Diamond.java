package model.entity;

import model.entity.entityBehaviours.Fallable;
import model.entity.entityBehaviours.IDestructable;
import model.entity.entityBehaviours.PlayerDestructable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Diamond extends Entity
{
    public Fallable fallable;
    IDestructable destructableP;
    public Diamond(int x, int y, Entity[][] map)
    {
        super(x, y, map);
        fallable = new Fallable(this);
        destructableP = new PlayerDestructable();
    }
    @Override
    public Image getImage() throws IOException
    {
        return ImageIO.read(new File("$PROJECT_DIR$\\sprites\\diamond.png"));
    }
    
}
