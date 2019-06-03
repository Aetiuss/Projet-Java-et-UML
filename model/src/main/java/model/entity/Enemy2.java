package model.entity;


import contract.showboard.BoardFrame;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

/**
 * Enemy with his AI
 *
 * @author Luc Anthoni
 * @version 1.1
 */
public class Enemy2 extends Entity {

    /**
     * The instance of the player
     */
    private Player player = Player.getInstance();

    /**
     * Constructor of the class enemy.
     *
     * @param x   The X coordinate of the future object.
     * @param y   The Y coordinate of the future object.
     * @param map The map.
     */
    public Enemy2(int x, int y, Entity[][] map) {
        super(x, y, map);
    }

    /**
     * Return sprite associate to the object.
     *
     * @return Return the sprite.
     */
    @Override
    public char getSprite() {
        return 'm';
    }

    /**
     * Load the image from a local folder
     */
    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("./sprites/creeper.png")));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The AI of the enemy
    */
    public void move() {
        if (player.x < this.x) {
            if (!(map[x - 1][y].getSprite() == 'r' || map[x - 1][y].getSprite() == 'w' || map[x - 1][y].getSprite() == 'd' || map[x - 1][y].getSprite() == 'f')) {
                map[x][y] = new Empty(x, y, map);
                this.x--;
                map[x][y] = this;
            }

        } else if (player.x > this.x) {
            if (!(map[x + 1][y].getSprite() == 'r' || map[x + 1][y].getSprite() == 'w' || map[x + 1][y].getSprite() == 'd' || map[x + 1][y].getSprite() == 'f')) {
                map[x][y] = new Empty(x, y, map);
                this.x++;
                map[x][y] = this;

            }
        }
        if (player.y < this.y) {
            if (!(map[x][y - 1].getSprite() == 'r' || map[x][y - 1].getSprite() == 'w' || map[x][y - 1].getSprite() == 'd' || map[x][y - 1].getSprite() == 'f')) {
                map[x][y] = new Empty(x, y, map);
                this.y--;
                map[x][y] = this;
            }
        } else if (player.y > this.y) {
            if (!(map[x][y + 1].getSprite() == 'r' || map[x][y + 1].getSprite() == 'w' || map[x][y + 1].getSprite() == 'd' || map[x][y + 1].getSprite() == 'f')) {
                map[x][y] = new Empty(x, y, map);
                this.y++;
                map[x][y] = this;
            }
        }
        if (this.x == player.x && this.y == player.y) {
            map[x][y] = new Empty(x, y, map);
            this.x--;
            map[x][y] = this;
            player.die();
            BoardFrame.kill();
        }
    }
}

