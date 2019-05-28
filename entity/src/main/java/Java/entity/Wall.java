package Java.entity;

public class Wall extends Entity
{
    
    IDestructable destructable;
    private char sprite = 'w';

    public Wall(int x, int y)
    {
        super(x, y);
        destructable = new FallableDestrutable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
