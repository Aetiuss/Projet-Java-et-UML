package model;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * The test of the class model
 *
 * @author Théo Weimann
 * @version 1.1
 */
public class ModelTest {

    private final Model model = new Model();

    /**
     * The test of the thread
     */
    @Test
    public void timedEventTest() {
        try {
            model.timedEvent();
        } catch (final InterruptedException e) {
            e.printStackTrace();
            fail("Thread is waiting for to long");
        }
    }
}