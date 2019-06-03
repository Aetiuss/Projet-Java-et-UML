package model.entity;

import contract.showboard.IPawn;
import model.entity.entityBehaviours.Fallable;
import model.entity.entityBehaviours.PlayerCollectible;
import model.entity.entityBehaviours.Pushable;

import java.awt.*;

/**
 * The Class entity.
 *
 * @author Luc Antoni
 */

public abstract class Entity implements IPawn {

    /**
     * The position x of the entity
     */
    public int x;
    /**
     * The position y of the entity
     */
    public int y;
    /**
     * The sprite of the entity
     */
    public char sprite;
    /**
     * The local map copy
     */
    public Entity[][] map;
    /**
     * The fallable strategy
     */
    public Fallable fallable;
    /**
     * The pushable strategy
     */
    public Pushable pushable;
    /**
     * The collectible strategy
     */
    public PlayerCollectible collectibleP;
    /**
     * The image of the entity
     */
    Image image;
    /**
     * The checked status of the entity
     */
    private boolean Checked;

    /**
     * Create entity
     * @param x The x position of the object
     * @param y The y position of the object
     * @param map The map
     */
    public Entity(int x, int y, Entity[][] map) {
        this.x = x;
        this.y = y;
        this.sprite = getSprite();
        this.map = map;
        loadImage();
    }

    /**
     * Constructor of the class
     */
    public Entity() {
    }

    /**
     * Return the sprite
     * @return Return the sprite of the class
     */
    public char getSprite() {
        return this.sprite;
    }

    /**
     * Get the x position
     * @return Return the x position
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Set the x position
     * @param x The x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the y position
     * @return Return the y position
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Set the y position
     * @param y The y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the position of the entity
     * @return the position of the entity
     */
    @Override
    public Point getPosition() {
        return new Point(this.x, this.y);
    }

    /**
     * Load the image of the class
     */
    public void loadImage() {
    }

    /**
     *Get the image of the entity
     * @return The image of the entity
     */
    @Override
    public Image getImage() {
        return image;
    }

    /**
     * move the entity (specified in concrete classes of the enemies
     */
    public void move() {
    }

    /**
     *
     * @return if the entity is checked
     */
    public boolean isChecked() {
        return Checked;
    }

    /**
     * Set the Checked Status
     * @param hasBeenChecked A boolean value
     */
    public void setChecked(boolean hasBeenChecked) {
        this.Checked = hasBeenChecked;
    }
}
