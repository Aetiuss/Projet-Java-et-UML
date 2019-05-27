package model;

import java.sql.SQLException;
import java.util.Observable;

import Java.entity.HelloWorld;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	DAOMap yolo = new DAOMap(DBConnection.getInstance().getConnection());


	@Override
	public HelloWorld getHelloWorld() {
		return null;
	}

	@Override
	public void loadHelloWorld(String code) {

	}

	@Override
	public Observable getObservable() {
		return null;
	}
}
