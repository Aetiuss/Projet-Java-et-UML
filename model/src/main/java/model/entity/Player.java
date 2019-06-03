package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    /**
     * Singleton of the player
     */
    private static Player ourInstance = new Player();
    private Exit exit = Exit.getInstance();
    private boolean alive = true;

    /**
     * return the player to Entity
     */
    private Player() {
        super();
        loadImage();
    }

    /**
     * @return the instance of the player
     */
    public static Player getInstance() {
        return ourInstance;
    }

    /**
     *
     * @param x
     * @param y
     * @param map
     * @return
     */
    public static Player getInstance(int x, int y, Entity[][] map) {
        ourInstance.x = x;
        ourInstance.y = y;
        ourInstance.map = map;
        return ourInstance;
    }

    /**
     * Move the player Up by incrementing y
     */
    public void moveUp() {
        if (this.alive) {
            if (map[x][y - 1].getSprite() != 'w') {
                if (map[x][y - 1].getSprite() != 'f') {
                    if (map[x][y - 1].getSprite() == 'd') {
                        map[x][y - 1].collectibleP.collect();
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.y--;
                        map[x][y] = this;
                    } else if (map[x][y - 1].getSprite() == 'e') {
                        exit.exitOpen();
                    } else {
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.y--;
                        map[x][y] = this;
                    }
                }
            }
        }
    }

    /**
     * Move the player Down by decrementing y
     */
    public void moveDown() {
        if (this.alive) {
            if (map[x][y + 1].getSprite() != 'w') {
                if (map[x][y + 1].getSprite() != 'f') {
                    if (map[x][y + 1].getSprite() == 'd') {
                        map[x][y + 1].collectibleP.collect();
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.y++;
                        map[x][y] = this;
                    } else if (map[x][y + 1].getSprite() == 'e') {
                        exit.exitOpen();
                    } else {
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.y++;
                        map[x][y] = this;
                    }
                }

            }
        }
    }

    /**
     * Move the player Left by incrementing x
     */
    public void moveLeft() {
        if (this.alive) {
            if (map[x - 1][y].getSprite() != 'w') {
                if (map[x - 1][y].getSprite() != 'f') {
                    if (map[x - 1][y].getSprite() == 'd') {
                        map[x - 1][y].collectibleP.collect();
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.x--;
                        map[x][y] = this;
                    } else if (map[x - 1][y].getSprite() == 'e') {
                        exit.exitOpen();
                    } else {
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.x--;
                        map[x][y] = this;
                    }

                } else {
                    if (map[x - 2][y].getSprite() == 'v') {
                        map[x - 1][y].pushable.pushLeft();
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.x--;
                        map[x][y] = this;
                    }
                }
            }
        }
    }

    /**
     * Move the player Right by decrementing x
     */
    public void moveRight() {
        if (this.alive) {
            if (map[x + 1][y].getSprite() != 'w') {
                if (map[x + 1][y].getSprite() != 'f') {
                    if (map[x + 1][y].getSprite() == 'd') {
                        map[x + 1][y].collectibleP.collect();
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.x++;
                        map[x][y] = this;
                    } else if (map[x + 1][y].getSprite() == 'e') {
                        exit.exitOpen();
                    } else {
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.x++;
                        map[x][y] = this;
                    }

                } else {
                    if (map[x + 2][y].getSprite() == 'v') {
                        map[x + 1][y].pushable.pushRight();
                        map[x][y] = new Empty(x, y, map);
                        ourInstance.x++;
                        map[x][y] = this;
                    }
                }
            }
        }
    }

    /**
     * @return the sprite of the class
     */
    @Override
    public char getSprite() {
        return 'p';
    }

    /**
     * load the image of the class
     */
    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("./sprites/player.png")));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * make the player unplayable
     */
    public void die() {
        alive = false;
    }

    /**
     *
     * @return if the player is alive
     */
    public boolean isAlive() {
        return alive;
    }
}

