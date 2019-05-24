package entity;

public class Factory
{
    
    public Diamond getDiamond()
    {
        return new Diamond(new BehaviourCollectable());
    }
    public Player getPlayer()
    {
        return new Player(new BehaviourImmovable());
    }
    public Ennemy getEnnemy()
    {
        return new Ennemy(new BehaviourImmovable());
    }
    public Rock getRock()
    {
        return new Rock(new BehaviourImmovable());
    }
    public FallingRock getFallingRock()
    {
        return new FallingRock(new BehaviourMovable());
    }
    public Wall getWall()
    {
        return new Wall(new BehaviourImmovable());
    }
    
}
