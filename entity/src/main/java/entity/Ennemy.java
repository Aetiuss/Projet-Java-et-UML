package entity;

public class Ennemy extends Entity
{
    IDestructable destructable;
    public Ennemy(int x, int y)
    {
        super(x, y);
        destructable = new PlayerDestructable();
    }
    
}
