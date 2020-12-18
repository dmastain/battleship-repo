package battleship.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSquare {

	@Test
	void test_init_square() 
	{
		Square square = new Square();
		assertEquals(square.isHit(), false);
		assertEquals(square.isOccupied(), false);
	}
	
	@Test
	void test_square_hit_unoccupied() 
	{
		Square square = new Square();
		boolean hit = true;
		
		square.setHit(hit);
		assertEquals(square.isHit(), hit);
		assertEquals(square.isOccupied(), false);
	}
	
	@Test
	void test_square_hit_occupied() 
	{
		Square square = new Square();
		boolean hit = true;
		
		char orientation = 'E';
		int size = 2;
		int xCoord = 0;
		int yCoord = 0;
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		square.setOccupyingShip(ship);
				
		square.setHit(hit);
		assertEquals(square.isHit(), hit);
		assertEquals(square.isOccupied(), true);
		assertEquals(ship.getHits(), 1);
	}
	
	@Test
	void test_square_set_occupied() 
	{
		Square square = new Square();
		
		char orientation = 'E';
		int size = 2;
		int xCoord = 0;
		int yCoord = 0;
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		square.setOccupyingShip(ship);
		
		assertEquals(square.getOccupyingShip(), ship);
		assertEquals(square.isOccupied(), true);
	}
	
	@Test
	void test_square_clear_occupied() 
	{
		Square square = new Square();
		
		char orientation = 'E';
		int size = 2;
		int xCoord = 0;
		int yCoord = 0;
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		square.setOccupyingShip(ship);
		
		assertEquals(square.getOccupyingShip(), ship);
		assertEquals(square.isOccupied(), true);
		
		square.clearOccupyingShip();
		
		assertEquals(square.getOccupyingShip(), null);
		assertEquals(square.isOccupied(), false);
	}

}
