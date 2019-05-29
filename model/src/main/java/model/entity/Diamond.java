package model.entity;

import model.entity.entityBehaviours.Fallable;
import model.entity.entityBehaviours.PlayerCollectible;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Diamond extends Entity
{
    public Fallable fallable;
    public PlayerCollectible collectibleP;
    public Diamond(int x, int y, Entity[][] map)
    {
        super(x, y, map);
        fallable = new Fallable(this);
        collectibleP = new PlayerCollectible();
    }

    @Override
    public void loadImage()
    {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("./sprites/diamond_ore.png"));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
}
