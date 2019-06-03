package model;

import model.entity.*;


/**
 * Create a map from a sprite Tab and his dimension.
 *
 * @author Théo Weimann
 * @version 1.1
 */
public class Map {
    /**
     * The unique instance of the class Map.
     */
    final private static Map instance = new Map();
    /**
     * The actual map containing all the entity.
     */
    Entity[][] map;
    /**
     * The height of the map
     */
    private int height;
    /**
     * The width of the map.
     */
    private int width;

    public static Map getInstance() {
        return instance;
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
     * Change the height of the map.
     *
     * @param height New height of the map.
     */
    private void setHeight(int height) {
        this.height = height;
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
     * Change the width of the map.
     *
     * @param width New width of the map.
     */
    private void setWidth(int width) {
        this.width = width;
    }

    /**
     * Getter from map attribute.
     *
     * @return Return the map. A tab of Entity.
     */
    public Entity[][] getMap() {
        return map;
    }

    /**
     * Set the map and instantiate all of the object using the model furnished by a 2 dimensional char tab.
     *
     * @param spriteTab The 2dimensional char tab you want to transform in map
     */
    private void setMap(char[][] spriteTab) {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                switch (spriteTab[i][j]) {
                    case 'w':
                        this.map[i][j] = new Wall(i, j, map);
                        break;
                    case 'r':
                        this.map[i][j] = new Rock(i, j, map);
                        break;
                    case 'd':
                        this.map[i][j] = new Diamond(i, j, map);
                        break;
                    case 'v':
                        this.map[i][j] = new Empty(i, j, map);
                        break;
                    case 'f':
                        this.map[i][j] = new FallingRock(i, j, map);
                        break;
                    case 'm':
                        long random = Math.round(Math.random());
                        if (random == 0) {
                            this.map[i][j] = new Enemy1(i, j, map);
                        } else if (random == 1) {
                            this.map[i][j] = new Enemy2(i, j, map);
                        }

                        break;
                    case 'p':
                        this.map[i][j] = Player.getInstance(i, j, map);
                        break;
                    case 'e':
                        this.map[i][j] = Exit.getInstance(i, j, map);
                        break;
                }
            }
        }
    }

    /**
     * Set a new map with the height and the width at the same time because this application are related.
     *
     * @param height    Height of the map you want to apply.
     * @param width     Width of the map you want to apply.
     * @param spriteTab The 2 dimensional char tab corresponding to the map you want to apply
     */
    void changeMap(int height, int width, char[][] spriteTab) {
        setWidth(width);
        setHeight(height);
        this.map = new Entity[this.height][this.width];
        setMap(spriteTab);
    }

}
