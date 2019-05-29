package model.entity;

public class Factory
{
    
    public Diamond getDiamond(int x, int y, Entity[][] map)
    {
        return new Diamond(x, y, map);
    }
    public Player getPlayer(int x, int y, Entity[][] map)
    {
        return Player.getInstance(x, y, map);
    }
    public Ennemy getEnnemy(int x, int y, Entity[][] map)
    {
        return new Ennemy(x, y, map);
    }
    public Rock getRock(int x, int y, Entity[][] map)
    {
        return new Rock(x, y, map);
    }
    public FallingRock getFallingRock(int x, int y, Entity[][] map)
    {
        return new FallingRock(x, y, map);
    }
    public Wall getWall(int x, int y, Entity[][] map)
    {
        return new Wall(x, y, map);
    }
    public Exit getExit(int x, int y, Entity[][] map)
    {
        return Exit.getInstance(x, y, map);
    }
    
}
