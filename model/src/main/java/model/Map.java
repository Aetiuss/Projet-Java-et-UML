package model;

import Java.entity.*;

/**
 * Create a map from a sprite Tab and his dimension.
 *
 * @author Théo Weimann
 * @version 1.0
 */
public class Map {
    private static Map instance = new Map();
    private int height;
    private int width;
    private Entity[][] map;


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

    private void setHeight(int height) {
        this.height = height;
    }

    private void setWidth(int width) {
        this.width = width;
    }

    private void setMap(char[][] spriteTab) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                switch (spriteTab[i][j]) {
                    case 'w':
                        this.map[i][j] = new Wall(i,j);
                    case 'r':
                        this.map[i][j] = new Rock(i,j);
                    case 'd':
                        this.map[i][j] = new Diamond(i,j);
                    case 'v':
                        this.map[i][j] = null;
                    case 'f':
                        this.map[i][j] = new FallingRock(i,j);
                    case 'm':
                        this.map[i][j] = new Ennemy(i,j);
                    case 'p':
                        this.map[i][j] = Player.getInstance(i,j);
                    case 'e':
                        this.map[i][j] = new Exit(i,j);
                }
            }
        }
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
    public void changeMap(int height, int width, char spriteTab[][]){
        setWidth(width);
        setHeight(height);
        this.map = new Entity[height][width];
        setMap(spriteTab);
    }

}
