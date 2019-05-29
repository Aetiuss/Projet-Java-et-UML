package model.entity.entityBehaviours;

import model.entity.Empty;
import model.entity.Entity;

public class Fallable
{
    
    Entity entity;
    public boolean falling = false;
    public Fallable(Entity entity)
    {
        this.entity = entity;
    }
    public void fall()
    {
        if (entity.map[entity.x][entity.y + 1].getSprite() != 'w')
        {
            entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
            entity.y++;
            setFalling(true);
            entity.map[entity.x][entity.y] = entity;
        }
        else {setFalling(false);}
    }
    public void setFalling(boolean b)
    {
        falling = b;
    }
    
}
