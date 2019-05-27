package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Use to load the map from a distant or local DB.
 * Used to load the map from a distant or local DB using the "../../resources/model.properties" files to get database log in.
 *
 * @author Théo Weimann
 * @version 1.2
 */
public class DAO {

    /**
     * Unique instance of the DAOmap class.
     */
    final static private DAO instance = new DAO(DBConnection.getInstance().getConnection());
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
     * A 2 dimension char tab that contain a map at sprite format
     */
    private char[][] charTab;

    /**
     * Constructor of the DAOmap class.
     * @param connection The connection session get from the
     */
    private DAO(final Connection connection) {
        this.connection = connection;
    }

    /**
     * Use to get the unique instance of the class DAO.
     *
     * @return Return the unique instance of the class DAO.
     */
    public static DAO getInstance() {
        return instance;
    }

    /**
     * Add the map you want stored on a .txt file to the database.
     *
     * @param filePath The path tto the file that you want to import.
     * @throws Exception If the file path specified is incorrect.
     */
    public void addToDB(String filePath) throws Exception {
        acquireFromFile(filePath);
        final String sqlAddMapElement = "{call addNewObject(?,?,?,?)}";
        final String sqlAddMapInformation = "{call addNewMap(?,?,?,?)}";
        final CallableStatement callAddMapInformation = this.connection.prepareCall(sqlAddMapInformation);
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
                switch (charTab[i][j]) {
                    case 'w':
                        callAddMapElement.setInt(2, 1);
                        break;
                    case 'r':
                        callAddMapElement.setInt(2, 2);
                        break;
                    case 'v':
                        callAddMapElement.setInt(2, 3);
                        break;
                    case 'f':
                        callAddMapElement.setInt(2, 4);
                        break;
                    case 'm':
                        callAddMapElement.setInt(2, 5);
                        break;
                    case 'p':
                        callAddMapElement.setInt(2, 6);
                        break;
                    case 'e':
                        callAddMapElement.setInt(2, 7);
                        break;
                    case 'd':
                        callAddMapElement.setInt(2, 8);
                        break;
                }
                callAddMapElement.setInt(3, i);
                callAddMapElement.setInt(4, j);
                callAddMapElement.execute();
            }
        }
    }

    /**
     * Allow the DAO to get the last map id used on the database.
     * @return Return the last id used in the database.
     */
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
     * Read a file with Height and width indicate on the tow first lines and then a tab that contain a all the sprite.
     * @param pathToFile The path tto the file that you want to import.
     * @throws IOException Throws Exception if the path to the furnished file is incorrect.
     */
    public void acquireFromFile(final String pathToFile) throws IOException {
        File file = new File(pathToFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        this.height = Integer.parseInt(br.readLine());
        this.width = Integer.parseInt(br.readLine());
        this.charTab = new char[this.width][this.height];
        String line;
        for (int i = 0; i < this.width; i++) {
            line = br.readLine();
            for (int j = 0; j < this.height; j++) {
                this.charTab[i][j] = line.toCharArray()[j];
            }
        }
    }

    /**
     * Import a map from a distant DB.
     * @param id The id of the map you want to import.
     * @return The map that you asked for by her ID.
     */
    public void aquireFromDB(final int id) {
        this.acquireDimensionFromDB(id);
        this.charTab = new char[this.width][this.height];
        try {
            final String sql = "{call getMap(?)}";
            final CallableStatement call = this.connection.prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                while (!resultSet.isAfterLast()) {
                    this.charTab[resultSet.getInt(1)][resultSet.getInt(2)] = resultSet.getString(3).toCharArray()[0];
                    resultSet.next();
                }

            }
            Map.getInstance().changeMap(this.height, this.width, charTab);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the dimension of a map by searching her from her ID on a DB.
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