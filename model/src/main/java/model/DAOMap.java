package model;

import Java.entity.BehaviourImmovable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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


    /**
     * @param connection
     * @param id
     */
    public DAOMap(final Connection connection, final int id) {
        this.connection = connection;
        new Map(this.height, this.width, this.readFromDB(id));
    }

    /**
     * @param connection
     * @param fileName
     */
    public DAOMap(final Connection connection, String fileName) throws Exception {
        int id;
        this.connection = connection;
        id = getLastMapID();
        addToDB(id, this.height, this, readFromFile(fileName));
        new Map(this.height, this.width, this.readFromDB(id));
    }

    public void addToDB(int id, int height, int width, char[][] spriteChar) throws SQLException {
        final String sqlAddMapElement = "{call addMapElement(?,?,?,?)}";
        final String sqlAddMapInfomation = "{call addMapInformation(?,?,?)}";
        final CallableStatement callAddMapInformation = this.connection.prepareCall(sqlAddMapInfomation);
        callAddMapInformation.setString(1, "NULL");
        callAddMapInformation.setInt(2, this.height);
        callAddMapInformation.setInt(3, this.width);
        callAddMapInformation.execute();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                final CallableStatement callAddMapElement = this.connection.prepareCall(sqlAddMapElement);
                callAddMapElement.setInt(1, id);
                //spriteChar[i][j];
                callAddMapElement.setInt();
                callAddMapElement.setInt(3, i);
                callAddMapElement.setInt(4, i);

                callAddMapElement.execute();
                // RECUP LES ID DES SPRITES DANS LA TABLE SPRITE ET LES LINKER DANS LA REQUETE
            }
        }
    }

    public int getLastMapID() throws Exception {
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
    public char[][] readFromFile(final String pathToFile) throws Exception {
        int j;
        File file = new File(pathToFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        height = Integer.parseInt(br.readLine());
        width = Integer.parseInt(br.readLine());
        char[][] charTab = new char[this.height][this.width];
        String line;
        for (int i = 0; i < this.height; i++) {
            line = br.readLine();
            j = 0;
            for (char sprite : line.toCharArray()) {
                charTab[i][j] = sprite;
                j++;
            }
        }
        return charTab;
    }

    /**
     * Import a map from a distant DB.
     *
     * @param id The id of the map you want to import.
     * @return The map that you asked for by her ID
     */
    public char[][] readFromDB(final int id) {
        this.setSizeFromDB(id);
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
    private void setSizeFromDB(final int id) {

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

    /**
     * Getter of width.
     *
     * @return Return the width parameter of a DAO Object.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter of height.
     *
     * @return Return the height parameter of a DAO Object.
     */
    public int getHeight() {
        return height;
    }
}
