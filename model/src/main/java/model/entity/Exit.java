package model.entity;

public class Exit extends Entity
{
    private char sprite = 'e';

    public Exit(int x, int y)
    {
        super(x, y);
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
