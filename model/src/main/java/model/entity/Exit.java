package model.entity;

public class Exit extends Entity
{
    private char sprite = 'e';

    public Exit(int x, int y, Entity[][] map)
    {
        super(x, y, map);
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
