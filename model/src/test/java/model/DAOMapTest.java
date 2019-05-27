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
        daoMap = new DAOMap(DBConnection.getInstance().getConnection());
    }


    @Test
    public void aquireFromFileTest() throws Exception{
        this.daoMap.aquireFromFile("Map1.txt");
        assertEquals(1 ,1);
    }


    @Test
    public void addTest() throws Exception {
        this.daoMap.addToDB("Map5.txt");
        assertEquals(1,1);
    }
}