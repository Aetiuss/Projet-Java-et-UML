package entity;

public class Factory
{
    
    public Diamond getDiamond(int x, int y)
    {
        return new Diamond(x, y);
    }
    public Player getPlayer()
    {
        return Player.getInstance();
    }
    public Ennemy getEnnemy()
    {
        return new Ennemy();
    }
    public Rock getRock()
    {
        return new Rock();
    }
    public FallingRock getFallingRock(int x, int y)
    {
        return new FallingRock(x, y);
    }
    public Wall getWall()
    {
        return new Wall();
    }
    
}
