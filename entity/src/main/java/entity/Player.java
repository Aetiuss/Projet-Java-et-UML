package entity;

public class Player extends Entity
{
    
    private static Player ourInstance = new Player(new BehaviourImmovable());
    
    public static Player getInstance()
    {
        return ourInstance;
    }
    
    private Player(IBehaviour behaviour)
    {
        super(behaviour);
    }
    
}
