package model.entity;

import model.entity.entityBehaviours.Fallable;
import model.entity.entityBehaviours.IDestructable;
import model.entity.entityBehaviours.PlayerDestructable;

import javax.imageio.ImageIO;
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
    public void loadImage()
    {
        try {
            this.image = ImageIO.read(new File("C:\\Users\\theow\\Projet\\Code\\Projet-Java-et-UML\\model\\src\\main\\resources\\sprites\\diamond.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
}
