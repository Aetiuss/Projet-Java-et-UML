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
    
    @Override
    public void loadHelloWorld(String code)
    {
    
    }
    @Override
    public Observable getObservable()
    {
        return null;
    }
    
}
