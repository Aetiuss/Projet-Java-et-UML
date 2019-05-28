package model.entity.entityBehaviours;

import model.entity.Empty;
import model.entity.Entity;

public class Pushable
{
    
    Entity entity;
    public Pushable(Entity entity)
    {
        this.entity = entity;
    }
    public void pushRight()
    {
        entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
        entity.x++;
        entity.map[entity.x][entity.y] = entity;
    }
    public void pushLeft()
    {
        entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
        entity.x--;
        entity.map[entity.x][entity.y] = entity;
    }
    
}
