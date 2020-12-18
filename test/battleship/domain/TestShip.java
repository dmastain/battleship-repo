package battleship.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestShip {

	@Test
	void test_init_ship()
	{
		char orientation = 'E';
		int size = 6;
		int xCoord = 0;
		int yCoord = 0;
		String type = "Generic ship";
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		assertEquals(ship.getSize(), size);
		assertEquals(ship.getOrientation(), orientation);
		assertEquals(ship.getStartSquare()[0], xCoord);
		assertEquals(ship.getStartSquare()[1], yCoord);
		assertEquals(ship.getType(), type);
	}
	
	@Test
	void test_init_carrier()
	{
		char orientation = 'E';
		int size = 5;
		int xCoord = 0;
		int yCoord = 0;
		String type = "Aircraft Carrier";
		Ship ship = new AircraftCarrier(orientation, xCoord, yCoord);
		assertEquals(ship.getOrientation(), orientation);
		assertEquals(ship.getSize(), size);
		assertEquals(ship.getStartSquare()[0], xCoord);
		assertEquals(ship.getStartSquare()[1], yCoord);
		assertEquals(ship.getType(), type);
	}
	
	@Test
	void test_init_battleship()
	{
		char orientation = 'E';
		int size = 4;
		int xCoord = 0;
		int yCoord = 0;
		String type = "Battleship";
		Ship ship = new Battleship(orientation, xCoord, yCoord);
		assertEquals(ship.getOrientation(), orientation);
		assertEquals(ship.getSize(), size);
		assertEquals(ship.getStartSquare()[0], xCoord);
		assertEquals(ship.getStartSquare()[1], yCoord);
		assertEquals(ship.getType(), type);
	}
	
	@Test
	void test_init_cruiser()
	{
		char orientation = 'E';
		int size = 3;
		int xCoord = 0;
		int yCoord = 0;
		String type = "Cruiser";
		Ship ship = new Cruiser(orientation, xCoord, yCoord);
		assertEquals(ship.getOrientation(), orientation);
		assertEquals(ship.getSize(), size);
		assertEquals(ship.getStartSquare()[0], xCoord);
		assertEquals(ship.getStartSquare()[1], yCoord);
		assertEquals(ship.getType(), type);
	}

	@Test
	void test_init_destroyer()
	{
		char orientation = 'E';
		int size = 2;
		int xCoord = 0;
		int yCoord = 0;
		String type = "Destroyer";
		Ship ship = new Destroyer(orientation, xCoord, yCoord);
		assertEquals(ship.getOrientation(), orientation);
		assertEquals(ship.getSize(), size);
		assertEquals(ship.getStartSquare()[0], xCoord);
		assertEquals(ship.getStartSquare()[1], yCoord);
		assertEquals(ship.getType(), type);
	}
	
	@Test
	void test_init_sub()
	{
		char orientation = 'E';
		int size = 3;
		int xCoord = 0;
		int yCoord = 0;
		String type = "Submarine";
		Ship ship = new Submarine(orientation, xCoord, yCoord);
		assertEquals(ship.getOrientation(), orientation);
		assertEquals(ship.getSize(), size);
		assertEquals(ship.getStartSquare()[0], xCoord);
		assertEquals(ship.getStartSquare()[1], yCoord);
		assertEquals(ship.getType(), type);
	}
}
