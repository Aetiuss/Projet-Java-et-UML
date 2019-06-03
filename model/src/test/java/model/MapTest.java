package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test class of the Map class
 *
 * @author Théo Weimann
 * @version 1.4
 */
public class MapTest {
    /**
     * The map
     */
    private Map map;
    /**
     * The expected height of the test
     */
    private int expectedWidth = 1;
    /**
     * The expected Width of the test
     */
    private int expectedHeight = 1;
    /**
     * A small tab used for testing purposes
     */
    private char[][] furnishedTab = {{'v'}};

    /**
     * Get the instance of the Map class and load a basic map in it.
     */
    @Before
    public void setup() {
        this.map = Map.getInstance();
        this.map.changeMap(this.expectedHeight, this.expectedWidth, this.furnishedTab);
    }

    /**
     * Get the height and compare it  the the height expected.
     */
    @Test
    public void getHeight() {
        assertEquals(this.expectedHeight, this.map.getHeight());
    }

    /**
     * Get the width and compare it  the the width expected.
     */
    @Test
    public void getWidth() {
        assertEquals(this.expectedWidth, this.map.getWidth());
    }

    /**
     * Get the map and compare it  the the map expected.
     */
    @Test
    public void getMap() {
        assertSame('v', this.map.getMap()[0][0].getSprite());
    }

    /**
     * Try to change the map and see if it change something.
     */
    @Test
    public void changeMap() {
        map.changeMap(0, 0, furnishedTab);
        assertNotEquals(this.expectedWidth, this.map.getWidth());
    }
}