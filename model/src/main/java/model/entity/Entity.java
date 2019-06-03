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

    public int x;
    public int y;
    public char sprite;
    public Entity[][] map;
    public Fallable fallable;
    public Pushable pushable;
    public PlayerCollectible collectibleP;
    Image image;
    private boolean Checked;

    /**
     * @param x
     * @param y
     * @param map
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
     *
     * @return the sprite of the class
     */
    public char getSprite() {
        return this.sprite;
    }

    /**
     *
     * @return x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return the position of the entity
     */
    @Override
    public Point getPosition() {
        return new Point(this.x, this.y);
    }

    /**
     * load the image of the class
     */
    public void loadImage() {
    }

    /**
     *
     * @return the image of the entity
     */
    @Override
    public Image getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
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
     *
     * @param hasBeenChecked
     */
    public void setChecked(boolean hasBeenChecked) {
        this.Checked = hasBeenChecked;
    }
}
