package Java.entity;

public class Diamond extends Entity
{
    
    Fallable      fallable;
    IDestructable destructableP;
    private char sprite = 'd';

    public Diamond(int x, int y)
    {
        super(x, y);
        fallable = new Fallable(this);
        destructableP = new PlayerDestructable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
