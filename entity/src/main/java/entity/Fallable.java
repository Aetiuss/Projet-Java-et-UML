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
        entity.y--;
        setFalling(true);
    }
    public void setFalling(boolean b)
    {
        falling = b;
    }
    
}
