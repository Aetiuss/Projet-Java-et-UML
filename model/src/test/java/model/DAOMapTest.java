package model;

import Java.entity.Entity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Contain some tests concerning the DAOMap class.
 * @author Théo Weimann
 * @version 1.1
 */
public class DAOMapTest {
    private DAOMap daoMap;

    /**
     * Instantiate a new DOAMap object.
     */
    @Before
    public void setUp() {
        daoMap = new DAOMap(DBConnection.getInstance().getConnection(), 1);
    }


    /**
     * Check if the DB is loadable.
     *
     * @throws Exception
     */
    @Test
    public void findConnectionTest() throws Exception {
        int mapId = 1;
        try {
            this.daoMap.find(mapId);
        } catch (final Exception e) {
            throw new Exception("Can't link to Database.");
        }


    }

    /**
     * Check if the DB is loadable.
     *
     * @throws Exception
     */
    @Test
    public void setSizeConnectionTest() throws Exception {
        int mapId = 1;
        try {
            this.daoMap.find(mapId);
        } catch (final Exception e) {
            throw new Exception("Can't link to Database.");
        }
    }

    /**
     * Check if the find method can load a map from a DB.
     */
    @Test
    public void findLoadTest() {
        int idMap = 1;
        Entity[][] result = daoMap.find(idMap);
        assertNotNull(result);
    }

    /**
     * Check if the method
     */
    @Test
    public void getSizeLoadTest() {
        int mapSize = 25;
        assertEquals(mapSize, this.daoMap.getWidth());
        assertEquals(mapSize, this.daoMap.getHeight());
    }

    @Test
    public void addTest() throws Exception {
        int expectedHeight = 34;
        int expectedWidth = 40;
        assertNotNull(this.daoMap.add("Map1.txt"));
    }
}