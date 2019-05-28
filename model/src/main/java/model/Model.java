package model;

import contract.IModel;
<<<<<<< Updated upstream

import java.util.Observable;
=======
import entity.HelloWorld;
>>>>>>> Stashed changes

/**
 * Model of the project contain all the basic information needed about data and their operations.
 * @author Théo Weimann
 * @version 1.0
 */
public final class Model extends Observable implements IModel {
	public Model() {
		DAO.getInstance().acquireFromDB(1);
	}

}
