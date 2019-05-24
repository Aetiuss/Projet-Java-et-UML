package entity;

public class Factory
{
    
    public Diamond getDiamond()
    {
        return new Diamond(new GravityTrue());
    }
    public Player getPlayer()
    {
        return new Player(new GravityFalse());
    }
    public Ennemy getEnnemy()
    {
        return new Ennemy(new GravityFalse());
    }
    public Rock getRock()
    {
        return new Rock(new GravityFalse());
    }
    public FallingRock getFallingRock()
    {
        return new FallingRock(new GravityTrue());
    }
    public Wall getWall()
    {
        return new Wall(new GravityFalse());
    }
    
}
