package model.entity;

public class Ennemy extends Entity
{
    
    IDestructable destructableF;
    private char sprite = 'm';

    public Ennemy(int x, int y, Entity[][] map)
    {
        super(x, y, map);
        destructableF = new FallableDestrutable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
