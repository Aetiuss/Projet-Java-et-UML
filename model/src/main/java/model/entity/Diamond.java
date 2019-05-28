package model.entity;

public class Diamond extends Entity
{
    public Fallable fallable;
    IDestructable destructableP;
    public Diamond(int x, int y, Entity[][] map)
    {
        super(x, y, map);
        fallable = new Fallable(this);
        destructableP = new PlayerDestructable();
    }
    
}
