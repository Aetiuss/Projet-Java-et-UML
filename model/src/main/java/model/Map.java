package model;

import Java.entity.*;

/**
 * Create a map from a sprite Tab and his dimension.
 *
 * @author Théo Weimann
 * @version 1.0
 */
public class Map {
    private int height;
    private int width;
    private Entity[][] map;

    /**
     * Build the map attributes and instantiate all the Java.entity.
     *
     * @param height Define the height of the map, the number of Java.entity on the X axis.
     * @param width  Define the width of the map, the number of Java.entity on the Y axis.
     * @param map    The 2 dimension table containing all instances of the Java.entity of the map.
     */
    public Map(int height, int width, char[][] spriteTab) {
        this.height = height;
        this.width = width;
        Entity[][] map = new Entity[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                switch (spriteTab[i][j]) {
                    case 'w':
                        map[i][j] = new Wall(i, j);
                    case 'r':
                        map[i][j] = new Rock(i, j);
                    case 'd':
                        map[i][j] = new Diamond(i, j);
                    case 'v':
                        map[i][j] = null;
                    case 'f':
                        map[i][j] = new FallingRock(i, j);
                    case 'm':
                        map[i][j] = new Ennemy(i, j);
                    case 'p':
                        map[i][j] = Player.getInstance(i, j);
                    case 'e':
                        map[i][j] = new Exit(i, j);
                }
            }
        }

        this.map = map;
    }

    /**
     * Getter from height attribute.
     *
     * @return Return the height of the map.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter from width attribute.
     *
     * @return Return the width of the map.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter from map attribute.
     *
     * @return Return the map. A tab of Entity.
     */
    public Entity[][] getMap() {
        return map;
    }
}
