package entity;

public class Diamond extends Entity
{
    public Fallable fallable;
    IDestructable destructableP;
    public Diamond(int x, int y, Entity[][] map)
    {
        super(x, y);
        fallable = new Fallable(this);
        destructableP = new PlayerDestructable();
        this.map = map;
    }
    
}
