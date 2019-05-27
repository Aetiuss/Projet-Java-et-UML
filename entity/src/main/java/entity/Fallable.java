package entity;

public class Fallable
{
    
    boolean falling = false;
    Entity  entity;
    void fall()
    {
        entity.y--;
        setFalling(true);
    }
    public void setFalling(boolean b)
    {
        falling = b;
    }
    public Fallable(Entity entity)
    {
        this.entity = entity;
    }
    
}
