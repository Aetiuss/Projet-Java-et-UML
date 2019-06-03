package model.entity.entityBehaviours;

import model.entity.Empty;
import model.entity.Entity;

public class Pushable
{
    
    //the entity variable is used to allow the fallable class access to the variables of entity such as x, y, or map
    Entity entity;
    public Pushable(Entity entity)
    {
        this.entity = entity;
    }
    //the method only checks if the pushable object can move right and moves it if it can
    public void pushRight()
    {
        entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
        entity.x++;
        entity.map[entity.x][entity.y] = entity;
    }
    //the method only checks if the pushable object can move left and moves it if it can
    public void pushLeft()
    {
        entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
        entity.x--;
        entity.map[entity.x][entity.y] = entity;
    }
    
}
