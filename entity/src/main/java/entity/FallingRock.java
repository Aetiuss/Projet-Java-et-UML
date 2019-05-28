package entity;

public class FallingRock extends Entity
{
    
    Fallable fallable;
    public Pushable pushable;
    public FallingRock(int x, int y)
    {
        super(x, y);
        fallable = new Fallable(this);
        pushable = new Pushable(this);
    }
    
}
