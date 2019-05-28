package entity;

public class Fallable
{
    
    public boolean falling = false;
    Entity  entity;
    public Fallable(Entity entity)
    {
        this.entity = entity;
    }
    public void fall()
    {
        entity.map[entity.x][entity.y] = null;
        entity.y--;
        setFalling(true);
        entity.map[entity.x][entity.y] = entity;
    }
    public void setFalling(boolean b)
    {
        falling = b;
    }
    
}
