package model.entity;

import org.junit.Before;

public class ExitTest {

    @Before
    public void setUp() {
        Entity[][] map = new Entity[3][3];
        Exit exit = Exit.getInstance(1, 1, map);
        exit.map[1][1] = exit;
    }

    /* Not working cause it require user input and that's not a good practice.
    @Test
    public void exitOpen() {
        boolean expectedState = true;
        exit.setScore(100);
        exit.exitOpen();
        assertEquals(expectedState, exit.exitIsOpen);
    }
     */
}