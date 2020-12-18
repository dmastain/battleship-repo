package battleship.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void test_player_init() 
	{
		String name = "Dan";
		int expectedSize = 10;
		Player player = new Player(name);
		Square[][] oceanMatrix = player.getOceanMatrix();
		String retrievedName = player.getName();
		assertEquals(name, retrievedName);
		assertEquals(expectedSize, oceanMatrix.length);
		assertEquals(expectedSize, oceanMatrix[0].length);
	}
	
	@Test
	void test_player_nextShip_addShip() 
	{
		String name = "Dan";
		char orientation = 'E';
		int xCoord = 0;
		int yCoord = 0;
		Player player = new Player(name);
		
		Ship ship1 = player.nextShip();
		player.addShip(ship1, orientation, xCoord, yCoord);
		
		Ship ship2 = player.nextShip();
		player.addShip(ship2, orientation, xCoord, ++yCoord);

		Ship ship3 = player.nextShip();
		player.addShip(ship3, orientation, xCoord, ++yCoord);
		
		Ship ship4 = player.nextShip();
		player.addShip(ship4, orientation, xCoord, ++yCoord);
		
		Ship ship5 = player.nextShip();
		player.addShip(ship5, orientation, xCoord, ++yCoord);
		
		assertEquals(ship5.getType(),"AircraftCarrier");
		assertEquals(ship5.getStartSquare()[0],xCoord);
		assertEquals(ship5.getStartSquare()[1],yCoord);
		
		assertEquals(ship4.getType(), "Battleship");
		assertEquals(ship4.getStartSquare()[0],xCoord);
		assertEquals(ship4.getStartSquare()[1],--yCoord);
		
		assertEquals(ship3.getType(), "Cruiser");
		assertEquals(ship3.getStartSquare()[0],xCoord);
		assertEquals(ship3.getStartSquare()[1],--yCoord);
		
		assertEquals(ship2.getType(), "Submarine");
		assertEquals(ship2.getStartSquare()[0],xCoord);
		assertEquals(ship2.getStartSquare()[1],--yCoord);
		
		assertEquals(ship1.getType(), "Destroyer");
		assertEquals(ship1.getStartSquare()[0],xCoord);
		assertEquals(ship1.getStartSquare()[1],--yCoord);
	}

}
