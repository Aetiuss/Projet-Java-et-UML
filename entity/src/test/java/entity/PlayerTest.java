package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	Player player;

	@Before
	public void setUp() throws Exception {
		player = Player.getInstance(0,0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void moveUpTest() {
		int expectedY = 1;
		player.moveUp();
		assertEquals(expectedY, player.y);
	}

	@Test
	public void moveDownTest() {
		int expectedY = -1;
		player.moveDown();
		assertEquals(expectedY, player.y);
	}

	@Test
	public void moveLeftTest() {
		int expectedX = -1;
		player.moveLeft();
		assertEquals(expectedX, player.x);
	}

	@Test
	public void moveRightTest() {
		int expectedX = 1;
		player.moveRight();
		assertEquals(expectedX, player.x);
	}


}
