package entity;

public class Player extends Entity
{
    
    private static Player ourInstance = new Player();
    
    public static Player getInstance()
    {
        return ourInstance;
    }
    
    private Player()
    {
        super();
    }
    
}
