package model.entity.entityBehaviours;

import contract.showboard.BoardFrame;
import model.entity.Empty;
import model.entity.Entity;

public class Fallable
{
    
    public Entity  entity;
    public boolean falling = false;
    public Fallable(Entity entity)
    {
        this.entity = entity;
    }
    public void fall()
    {
        if (entity.map[entity.x][entity.y + 1].getSprite() == 'v')
        {
            entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
            entity.y++;
            setFalling(true);
            entity.map[entity.x][entity.y] = entity;
        }
        else {entity.map[entity.x][entity.y].fallable.setFalling(false);}
        if (entity.map[entity.x][entity.y + 1].getSprite() == 'p')
        {
            if (entity.map[entity.x][entity.y].fallable.falling == true)
            {
                BoardFrame.kill(); //kill from BoardFrame
            }
        }
    }
    public void setFalling(boolean b)
    {
        falling = b;
    }
    
}
