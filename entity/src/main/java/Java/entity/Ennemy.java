package Java.entity;

public class Ennemy extends Entity
{
    
    IDestructable destructableF;
    private char sprite = 'm';

    public Ennemy(int x, int y)
    {
        super(x, y);
        destructableF = new FallableDestrutable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
