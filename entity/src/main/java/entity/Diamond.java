package entity;

public class Diamond extends Entity
{
    
    Fallable      fallable;
    IDestructable destructableP;
    public Diamond(int x, int y)
    {
        super(x, y);
        fallable = new Fallable(this);
        destructableP = new PlayerDestructable();
    }
    
}
