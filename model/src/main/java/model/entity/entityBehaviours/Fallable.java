package model.entity.entityBehaviours;

import contract.showboard.BoardFrame;
import model.entity.Diamond;
import model.entity.Empty;
import model.entity.Entity;
import model.entity.Player;

public class Fallable
{
    /**
     * the entity variable is used to allow the fallable class access to the variables of entity such as x, y, or map
     */
    public Entity  entity;
    /**
     * this boolean is used to prevent the player from being squished when under a rock with no momentum
     */
    public boolean falling = false;
    public Fallable(Entity entity)
    {
        this.entity = entity;
    }

    /**
     * the method simply checks if the fallable object can go downwards and moves it and sets its falling bool to true. It resets it to false when it can no longer fall any further
     */
    public void fall()
    {
        if (entity.map[entity.x][entity.y + 1].getSprite() == 'v')
        {
            entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
            entity.y++;
            setFalling(true);
            entity.map[entity.x][entity.y] = entity;
        }
        else
        {
            entity.map[entity.x][entity.y].fallable.setFalling(false);
        }
        if (entity.map[entity.x][entity.y + 1].getSprite() == 'p')
        {
            if (entity.map[entity.x][entity.y].fallable.falling == true)
            {
                Player.getInstance().die();
                BoardFrame.kill(); //kill from BoardFrame
            }
        }
        else if (entity.map[entity.x][entity.y + 1].getSprite() == 'm')
        {
            entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
        }
        if (entity.map[entity.x][entity.y + 1].getSprite() == 'f' || entity.map[entity.x][entity.y + 1].getSprite() == 'd')
        {
            if (entity.map[entity.x - 1][entity.y + 1].getSprite() == 'v')
            {
                entity.pushable.pushLeft();
            }
            if (entity.map[entity.x + 1][entity.y + 1].getSprite() == 'v')
            {
                entity.pushable.pushRight();
            }
        }
        if (entity.map[entity.x][entity.y + 1].getSprite() == 'm')
        {
            if (entity.map[entity.x][entity.y].getSprite() != 'w')
            {
                entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
            }
            if (entity.map[entity.x][entity.y + 1].getSprite() != 'w')
            {
                entity.map[entity.x][entity.y + 1] = new Empty(entity.x, entity.y, entity.map);
            }
            if (entity.map[entity.x][entity.y].getSprite() != 'w')
            {
                entity.map[entity.x][entity.y] = new Diamond(entity.x, entity.y, entity.map);
            }
            if (entity.map[entity.x][entity.y + 2].getSprite() != 'w')
            {
                entity.map[entity.x][entity.y + 2] = new Diamond(entity.x, entity.y, entity.map);
            }
            if (entity.map[entity.x + 1][entity.y].getSprite() != 'w')
            {
                entity.map[entity.x + 1][entity.y] = new Diamond(entity.x, entity.y, entity.map);
            }
            if (entity.map[entity.x + 1][entity.y + 2].getSprite() != 'w')
            {
                entity.map[entity.x + 1][entity.y + 2] = new Diamond(entity.x, entity.y, entity.map);
            }
            if (entity.map[entity.x + 1][entity.y + 1].getSprite() != 'w')
            {
                entity.map[entity.x + 1][entity.y + 1] = new Diamond(entity.x, entity.y, entity.map);
            }
            if (entity.map[entity.x - 1][entity.y].getSprite() != 'w')
            {
                entity.map[entity.x - 1][entity.y] = new Diamond(entity.x, entity.y, entity.map);
            }
            if (entity.map[entity.x - 1][entity.y + 2].getSprite() != 'w')
            {
                entity.map[entity.x - 1][entity.y + 2] = new Diamond(entity.x, entity.y, entity.map);
            }
            if (entity.map[entity.x - 1][entity.y + 1].getSprite() != 'w')
            {
                entity.map[entity.x - 1][entity.y + 1] = new Diamond(entity.x, entity.y, entity.map);
            }
        }
    }

    /**
     * set the falling attribute
     */
    public void setFalling(boolean b) {
        falling = b;
    }
    
}