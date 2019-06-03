package model;

import contract.IModel;

import java.util.Observable;

/**
 * Model of the project contain all the basic information needed about data and their operations.
 *
 * @author Théo Weimann
 * @version 1.0
 */
public final class Model extends Observable implements IModel
{
    
    Map map = Map.getInstance();
    
    public Model()
    {
        DAO.getInstance()
           .acquireFromDB(5);
    }
    public void run()
    {
    
    }
    @Override
    public void gravity()
    {
        for (int i = 0; i < map.getHeight(); i++)
        {
            for (int j = 0; j < map.getWidth(); j++)
            {
                switch (map.map[i][j].getSprite())
                {
                    case 'd':
                        try
                        {
                            Map.getInstance()
                               .getMap()[i][j].fallable.fall();
                            break;
                        }
                        catch (Exception e) {e.getMessage();}
                    
                    case 'f':
                        try
                        {
                            Map.getInstance()
                               .getMap()[i][j].fallable.fall();
                            break;
                        }
                        catch (Exception e)
                        {
                            e.getMessage();
                        }
                    case 'm':
                        Map.getInstance()
                           .getMap()[i][j].move();
                        break;
                }
            }
        }
        
    }
    
    
}
