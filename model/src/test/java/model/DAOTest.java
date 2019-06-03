package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Contain some tests concerning the DAO class.
 *
 * @author Théo Weimann
 * @version 1.2
 */
public class DAOTest {
    private DAO dao;

    /**
     * Get the instance of the DAO.
     */
    @Before
    public void setup() {
        this.dao = DAO.getInstance();
    }

    /**
     * Test the connection between the DAO and the database.
     */
    @Test
    public void DBConnectionTest() {
        try {
            this.dao.acquireFromDB(1);
        } catch (final Error e) {
            fail();
        }
    }

}