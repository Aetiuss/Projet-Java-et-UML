package model;

import contract.IModel;

import java.util.Observable;

/**
 * Model of the project contain all the basic information needed about data and their operations.
 * @author Théo Weimann
 * @version 1.0
 */
public final class Model extends Observable implements IModel {
	public Model() {
		DAO.getInstance().acquireFromDB(1);
	}
    
    Map map = Map.getInstance();
	
	public void run() {
        for (int i = 0; i < map.height; i++)
        {
            for (int j = 0; j < map.width; j++)
            {
                switch (map.map[i][j].getSprite())
                {
                    case 'w':
                        try
                        {
                            map.map[i][j].fallable.fall();
                        }
                        catch (Exception e) {}
                        break;
                    case 'r':
                        try
                        {
                            map.map[i][j].fallable.fall();
                        }
                        catch (Exception e) {}
                        break;
                    case 'd':
                        try
                        {
                            map.map[i][j].fallable.fall();
                        }
                        catch (Exception e) {}
                        break;
                    case 'v':
                        try
                        {
                            map.map[i][j].fallable.fall();
                        }
                        catch (Exception e) {}
                        break;
                    case 'f':
                        try
                        {
                            map.map[i][j].fallable.fall();
                        }
                        catch (Exception e) {}
                        break;
                    case 'm':
                        try
                        {
                            map.map[i][j].fallable.fall();
                        }
                        catch (Exception e) {}
                        break;
                    case 'p':
                        try
                        {
                            map.map[i][j].fallable.fall();
                        }
                        catch (Exception e) {}
                        break;
                    case 'e':
                        try
                        {
                            map.map[i][j].fallable.fall();
                        }
                        catch (Exception e) {}
                        break;
                }
            }
        }
        
    }


}
