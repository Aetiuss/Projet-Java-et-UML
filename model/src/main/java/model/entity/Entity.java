package model.entity;

import contract.showboard.IPawn;
import model.entity.entityBehaviours.Fallable;
import model.entity.entityBehaviours.PlayerCollectible;
import model.entity.entityBehaviours.Pushable;

import java.awt.*;

/**
 * The Class entity.
 *
 * @author Jean-Aymeric Diet
 */

public abstract class Entity implements IPawn
{
    
    public int               x;
    public int               y;
    public char              sprite;
    public Entity[][]        map;
    public Fallable          fallable;
    public Pushable          pushable;
    public PlayerCollectible collectibleP;
    Image    image;

    public Entity(int x, int y, Entity[][] map) {
        this.x = x;
        this.y = y;
        this.sprite = getSprite();
        this.map = map;
        loadImage();
    }

    private boolean Checked;

    public Entity() {
    }

    public char getSprite() {
        return this.sprite;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Point getPosition() {
        return new Point(this.x, this.y);
    }

    public void loadImage() {
    }

    @Override
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public void move() {}

    public boolean isChecked() {
        return Checked;
    }

    public void setChecked(boolean hasBeenChecked) {
        this.Checked = hasBeenChecked;
    }
}
