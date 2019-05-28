package model.entity.entityBehaviours;

import model.entity.Empty;
import model.entity.Entity;

public class Fallable
{
    
    public boolean falling = false;
    Entity entity;
    public Fallable(Entity entity)
    {
        this.entity = entity;
    }
    public void fall(){
        entity.map[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
        entity.y--;
        setFalling(true);
        entity.map[entity.x][entity.y] = entity;
    }
    public void setFalling(boolean b){
        falling = b;
    }
}
