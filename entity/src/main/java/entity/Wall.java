package entity;

public class Wall extends Entity
{
    IDestructable destructable;
    public Wall(int x, int y)
    {
        super(x, y);
        destructable = new FallableDestrutable();
    }
    
}
