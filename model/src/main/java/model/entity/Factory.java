package model.entity;

public class Factory
{
    
    public Diamond getDiamond(int x, int y, Entity[][] map)
    {
        return new Diamond(x, y, null);
    }
    public Player getPlayer(int x, int y)
    {
        return Player.getInstance(x, y);
    }
    public Ennemy getEnnemy(int x, int y)
    {
        return new Ennemy(x, y);
    }
    public Rock getRock(int x, int y)
    {
        return new Rock(x, y);
    }
    public FallingRock getFallingRock(int x, int y)
    {
        return new FallingRock(x, y);
    }
    public Wall getWall(int x, int y)
    {
        return new Wall(x, y);
    }
    public Exit getExit(int x, int y)
    {
        return new Exit(x, y);
    }
    
}
