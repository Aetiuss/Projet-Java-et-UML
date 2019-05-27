package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Use to load the map from a distant or local DB.
 * Used to load the map from a distant or local DB using the "../../resources/model.properties" files to get database log in.
 *
 * @author Théo Weimann
 * @version 1.1
 */

class DAOMap {
    /**
     * The connection parameter inherited from the "../../resources/model.properties" and get by the Abstract class Connection.
     */
    private final Connection connection;
    /**
     * The width of a map.
     */
    private int width;
    /**
     * The height of a map.
     */
    private int height;

    private char[][] charTab;

    /**
     * @param connection
     */
    public DAOMap(final Connection connection) {
        this.connection = connection;
    }

    public void addToDB(String filePath) throws Exception {
        aquireFromFile(filePath);
        final String sqlAddMapElement = "{call addNewObject(?,?,?,?)}";
        final String sqlAddMapInfomation = "{call addNewMap(?,?,?,?)}";
        final CallableStatement callAddMapInformation= this.connection.prepareCall(sqlAddMapInfomation);
        int id = getLastMapID() + 1;
        callAddMapInformation.setInt(1, id);
        callAddMapInformation.setString(2, "NULL");
        callAddMapInformation.setInt(3, this.height);
        callAddMapInformation.setInt(4, this.width);
        callAddMapInformation.execute();
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                final CallableStatement callAddMapElement = this.connection.prepareCall(sqlAddMapElement);
                callAddMapElement.setInt(1, id);
                switch (charTab[i][j]){
                    case 'w':
                        callAddMapElement.setInt(2,1);
                        break;
                    case 'r':
                        callAddMapElement.setInt(2,2);
                        break;
                    case 'v':
                        callAddMapElement.setInt(2,3);
                        break;
                    case 'f':
                        callAddMapElement.setInt(2,4);
                        break;
                    case 'm':
                        callAddMapElement.setInt(2,5);
                        break;
                    case 'p':
                        callAddMapElement.setInt(2,6);
                        break;
                    case 'e':
                        callAddMapElement.setInt(2,7);
                        break;
                    case 'd':
                        callAddMapElement.setInt(2,8);
                        break;
                }
                callAddMapElement.setInt(3, i);
                callAddMapElement.setInt(4, j);
                callAddMapElement.execute();
            }
        }
    }

    private int getLastMapID() {
        try {
            final String sql = "{call getLastID()}";
            final CallableStatement call = this.connection.prepareCall(sql);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                return resultSet.getInt(1);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param pathToFile
     * @return
     * @throws Exception
     */
    public void aquireFromFile(final String pathToFile) throws Exception {
        File file = new File(pathToFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        this.height = Integer.parseInt(br.readLine());
        this.width = Integer.parseInt(br.readLine());
        this.charTab = new char[this.width][this.height];
        String line;
        for (int i = 0; i < this.width; i++) {
            line = br.readLine();
            for (int j = 0; j < this.height ; j++) {
                this.charTab[i][j] = line.toCharArray()[j];
            }
        }
    }

    /**
     * Import a map from a distant DB.
     *
     * @param id The id of the map you want to import.
     * @return The map that you asked for by her ID
     */
    public char[][] aquireFromDB(final int id) {
        this.acquireDimensionFromDB(id);
        char[][] map = new char[this.width][this.height];
        try {
            final String sql = "{call getMap(?)}";
            final CallableStatement call = this.connection.prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                while (!resultSet.isAfterLast()) {
                    map[resultSet.getInt(1) - 1][resultSet.getInt(2) - 1] = resultSet.getString(3).toCharArray()[0];
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
    private void acquireDimensionFromDB(final int id) {
        try {
            final String sql = "{call getDimension(?)}";
            final CallableStatement call = this.connection.prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                this.width = resultSet.getInt(1);
                this.height = resultSet.getInt(2);
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

}
