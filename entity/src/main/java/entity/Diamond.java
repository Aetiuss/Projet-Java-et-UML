package entity;

import contract.IView;

public class Diamond extends Entity implements IView
{
    
    public Fallable fallable;
    IDestructable destructableP;
    public Diamond(int x, int y)
    {
        super(x, y);
        fallable = new Fallable(this);
        destructableP = new PlayerDestructable();
    }
    
    @Override
    public void printMessage(String message)
    {
    
    }
    
}
