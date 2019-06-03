package model.entity;

import model.entity.entityBehaviours.FallableDestrutable;
import model.entity.entityBehaviours.IDestructable;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Ennemy extends Entity {

    IDestructable destructableF;
    private char sprite = 'm';

    public Ennemy(int x, int y, Entity[][] map) {
        super(x, y, map);
        destructableF = new FallableDestrutable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }

    @Override
    public void loadImage() {

        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("./sprites/zombie.png"));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void move()
    {
        if (map[x - 1][y].getSprite() == 'v')
        {
            map[x][y] = new Empty(x, y, map);
            x--;
            map[x][y] = this;
        }
        else if (map[x][y - 1].getSprite() == 'v')
        {
            map[x][y] = new Empty(x, y, map);
            y--;
            map[x][y] = this;
        }
        else if (map[x + 1][y].getSprite() == 'v')
        {
            map[x][y] = new Empty(x, y, map);
            x++;
            map[x][y] = this;
        }
        else if (map[x][y + 1].getSprite() == 'v')
        {
            map[x][y] = new Empty(x, y, map);
            y++;
            map[x][y] = this;
        }
    }
}
