package model;

import entity.*;

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
     * Build the map attributes and instantiate all the entity.
     *
     * @param height Define the height of the map, the number of entity on the X axis.
     * @param width  Define the width of the map, the number of entity on the Y axis.
     * @param map    The 2 dimension table containing all instances of the entity of the map.
     */
    public Map(int height, int width, char[][] spriteTab) {
        this.height = height;
        this.width = width;
        Entity[][] map = new Entity[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                switch (spriteTab[i][j]) {
                    case 'w':
                        map[i][j] = new Wall(new BehaviourImmovable());
                    case 'r':
                        map[i][j] = new Rock(new BehaviourImmovable());
                    case 'd':
                        map[i][j] = new Diamond(new BehaviourCollectable());
                    case 'v':
                        map[i][j] = null;
                    case 'f':
                        map[i][j] = new FallingRock(new BehaviourMovable());
                    case 'm':
                        map[i][j] = new Ennemy(new BehaviourMovable());
                    case 'p':
                        map[i][j] = Player.getInstance();
                    case 'e':
                        map[i][j] = new Exit(new BehaviourImmovable());
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
