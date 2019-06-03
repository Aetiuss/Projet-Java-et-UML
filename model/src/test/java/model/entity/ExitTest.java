package model.entity;

import org.junit.Before;

public class ExitTest {

    Exit exit;
    Entity[][] map;

    @Before
    public void setUp() throws Exception {
        map = new Entity[3][3];
        exit = Exit.getInstance(1, 1, map);
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