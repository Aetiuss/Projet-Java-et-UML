package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Ennemy extends Entity {
    
    private char sprite = 'm';
    Player player = Player.getInstance();

    public Ennemy(int x, int y, Entity[][] map) {
        super(x, y, map);
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

    /*
    //The if statements check for empty spaces. If a space is empty then the ennemy will move there.
    @Override
    public void move()
    {
        if (map[x - 1][y].getSprite() == 'v')
        {
            map[x][y] = new Empty(x, y, map);
            x--;
            map[x][y] = this;
        }
        if (map[x][y - 1].getSprite() == 'v')
        {
            map[x][y] = new Empty(x, y, map);
            y--;
            map[x][y] = this;
        }
        if (map[x + 1][y].getSprite() == 'v')
        {
            map[x][y] = new Empty(x, y, map);
            x++;
            map[x][y] = this;
        }
        if (map[x][y + 1].getSprite() == 'v')
        {
            map[x][y] = new Empty(x, y, map);
            y++;
            map[x][y] = this;
        }
        if (map[x - 1][y].getSprite() == 'p')
        {
            map[x][y] = new Empty(x, y, map);
            x--;
            map[x][y] = this;
            BoardFrame.kill();
        }
        if (map[x][y - 1].getSprite() == 'p')
        {
            map[x][y] = new Empty(x, y, map);
            y--;
            map[x][y] = this;
            BoardFrame.kill();
        }
        if (map[x + 1][y].getSprite() == 'p')
        {
            map[x][y] = new Empty(x, y, map);
            x++;
            map[x][y] = this;
            BoardFrame.kill();
        }
        if (map[x][y + 1].getSprite() == 'p')
        {
            map[x][y] = new Empty(x, y, map);
            y++;
            map[x][y] = this;
            BoardFrame.kill();
        }
    }
    */


    public void move() {
        if (player.x < this.x) {
            if (map[x - 1][y].getSprite() != 'r') {
                map[x][y] = new Empty(x, y, map);
                this.x--;
                map[x][y] = this;
            }
        } else if (player.x > this.x) {
            if (map[x + 1][y].getSprite() != 'r') {
                map[x][y] = new Empty(x, y, map);
                this.x++;
                map[x][y] = this;
            }
        }

        if (player.y < this.y) {
            if (map[x][y - 1].getSprite() != 'r') {
                map[x][y] = new Empty(x, y, map);
                this.y--;
                map[x][y] = this;
            }
        } else if (player.y > this.y) {
            if (map[x][y + 1].getSprite() != 'r') {
                map[x][y] = new Empty(x, y, map);
                this.y++;
                map[x][y] = this;
            }
        }
    }
}
