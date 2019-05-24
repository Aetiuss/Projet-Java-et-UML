package model;

import entity.BehaviourImmovable;
import entity.Entity;
import entity.Wall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Use to load the map from a distant or local DB.
 * Used to load the map from a distant or local DB using the "../../resources/model.properties" files to get database log in.
 *
 * @author Théo Weimann
 * @version 1.0
 */

class DAOMap {
    /**
     * The connection parameter inherited from the "../../resources/model.properties" and get by the Abstract class Connection.
     */
    private final Connection connection;
    /**
     * The size on the X axis of a map.
     */
    private int sizeX;
    /**
     * The size on the Y axis of a map.
     */
    private int sizeY;

    /**
     * Instantiates a new DAO hello world.
     *
     * @param connection the connection
     * @throws SQLException the SQL exception
     */
    public DAOMap(final Connection connection) throws SQLException {
        this.connection = connection;
    }


    /**
     * Import a map from a distant DB.
     *
     * @param id The id of the map you want to import.
     * @return The map that you asked for by her ID
     */
    public Entity[][] find(final int id) {
        this.setSize(id);
        Entity[][] map = new Entity[this.sizeX][this.sizeY];
        try {
            final String sql = "{call getMap(?)}";
            final CallableStatement call = this.connection.prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                while (!resultSet.isAfterLast()) {
                    switch (resultSet.getString(3)) {
                        case "T":
                            map[resultSet.getInt(1) - 1][resultSet.getInt(2) - 1] = new Wall(new BehaviourImmovable());
                    }

                    resultSet.next();
                }

            }
            return map;
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get the dimension of a map by searching her from her ID on a DB.
     *
     * @param id The id of the map you want to import.
     */
    private void setSize(final int id) {

        try {
            final String sql = "{call getDimension(?)}";
            final CallableStatement call = this.connection.prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                this.sizeX = resultSet.getInt(1);
                this.sizeY = resultSet.getInt(2);
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter of sizeX.
     *
     * @return Return the sizeX parameter of a DAO Object.
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     * Getter of sizeY.
     *
     * @return Return the sizeY parameter of a DAO Object.
     */
    public int getSizeY() {
        return sizeY;
    }
}
