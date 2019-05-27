package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Contain some tests concerning the DAO class.
 * @author Théo Weimann
 * @version 1.1
 */
public class DAOTest {
    private DAO dao;
    private Map map;
    /**
     * Instantiate a new DOAMap object.
     */
    @Before
    public void setUp() {
        this.dao = DAO.getInstance();
        this.map = Map.getInstance();
    }

    @Test
    public void mapLoadingTest() {
        this.dao.aquireFromDB(1);
        assertNotNull(this.map.getMap());
    }
}