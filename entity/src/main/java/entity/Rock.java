package entity;

public class Rock extends Entity
{
    
    IDestructable destructable;
    public Rock(int x, int y)
    {
        super(x, y);
        destructable = new PlayerDestructable();
    }
    
}
