package model.entity.entityBehaviours;

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
        entity.x++;
    }
    public void pushLeft()
    {
        entity.x--;
    }
    
}
