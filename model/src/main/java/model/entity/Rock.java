package model.entity;

public class Rock extends Entity
{
    
    IDestructable destructable;
    private char sprite = 'r';

    public Rock(int x, int y)
    {
        super(x, y);
        destructable = new PlayerDestructable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
