package entity;

public class Diamond extends Entity
{
    
    Fallable fallable;
    IDestructable destructable;
    public Diamond(int x, int y)
    {
        super(x, y);
        fallable = new Fallable(this);
        destructable = new PlayerDestructable();
    }
    
}
