package entity;

public class Ennemy extends Entity
{
    
    IDestructable destructableF;
    public Ennemy(int x, int y)
    {
        super(x, y);
        destructableF = new FallableDestrutable();
    }
    
}
