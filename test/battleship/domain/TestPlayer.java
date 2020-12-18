package battleship.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		
		int count = player.countDestroyedShips();
		
		assertEquals(name, retrievedName);
		assertEquals(expectedSize, oceanMatrix.length);
		assertEquals(expectedSize, oceanMatrix[0].length);
		assertEquals(0, count);
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
		
		assertEquals(ship5.getType(),"Aircraft Carrier");
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
	
	@Test
	void test_player_count_destoryed_ships() 
	{
		String name = "Dan";
		char orientation = 'E';
		int xCoord = 0;
		int yCoord = 0;
		ArrayList<Ship> shipList = new ArrayList<Ship>();
		Player player = new Player(name);
		
		Ship ship1 = player.nextShip();
		player.addShip(ship1, orientation, xCoord, yCoord);
		shipList.add(ship1);
		
		Ship ship2 = player.nextShip();
		player.addShip(ship2, orientation, xCoord, ++yCoord);
		shipList.add(ship2);
		
		Ship ship3 = player.nextShip();
		player.addShip(ship3, orientation, xCoord, ++yCoord);
		shipList.add(ship3);
		
		Ship ship4 = player.nextShip();
		player.addShip(ship4, orientation, xCoord, ++yCoord);
		shipList.add(ship4);
		
		Ship ship5 = player.nextShip();
		player.addShip(ship5, orientation, xCoord, ++yCoord);
		shipList.add(ship5);
		
		for(Ship ship: shipList)
		{
			for(int i = 0; i < ship.getSize(); i++)
			{
				ship.addHits(1);
			}
		}
		
		int count = player.countDestroyedShips();
		assertEquals(player.countDestroyedShips(), 5);
	}
	
	@Test
	void test_player_placeShip_N_success() 
	{
		String name = "Dan";
		char orientation = 'N';
		int xCoord = 0;
		int yCoord = 4;
		int size = 3;
		
		Player player = new Player(name);
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		boolean result = player.placeShip(ship);
		assertEquals(result, true);
	}
	
	@Test
	void test_player_placeShip_N_occupied() 
	{
		String name = "Dan";
		char orientation1 = 'N';
		int xCoord1 = 5;
		int yCoord1 = 4;
		int size = 3;

		char orientation2 = 'E';
		int xCoord2 = 3;
		int yCoord2 = 4;
		
		Player player = new Player(name);
		
		Ship ship1 = new Ship(orientation1, size, xCoord1, yCoord1);
		Ship ship2 = new Ship(orientation2, size, xCoord2, yCoord2);
		
		boolean result2 = player.placeShip(ship2);
		boolean result1 = player.placeShip(ship1);
		assertEquals(result2, true);
		assertEquals(result1, false);
	}
	
	@Test
	void test_player_placeShip_N_boundry() 
	{
		String name = "Dan";
		char orientation = 'N';
		int xCoord = 0;
		int yCoord = 0;
		int size = 3;
		
		Player player = new Player(name);
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		boolean result = player.placeShip(ship);
		assertEquals(result, false);
	}
	
	@Test
	void test_player_placeShip_S_success() 
	{
		String name = "Dan";
		char orientation = 'S';
		int xCoord = 0;
		int yCoord = 4;
		int size = 3;
		
		Player player = new Player(name);
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		boolean result = player.placeShip(ship);
		assertEquals(result, true);
	}
	
	@Test
	void test_player_placeShip_S_occupied() 
	{
		String name = "Dan";
		char orientation1 = 'S';
		int xCoord1 = 5;
		int yCoord1 = 2;
		int size = 3;

		char orientation2 = 'E';
		int xCoord2 = 3;
		int yCoord2 = 4;
		
		Player player = new Player(name);
		
		Ship ship1 = new Ship(orientation1, size, xCoord1, yCoord1);
		Ship ship2 = new Ship(orientation2, size, xCoord2, yCoord2);
		
		boolean result2 = player.placeShip(ship2);
		boolean result1 = player.placeShip(ship1);
		assertEquals(result2, true);
		assertEquals(result1, false);
	}
	
	@Test
	void test_player_placeShip_S_boundary() 
	{
		String name = "Dan";
		char orientation = 'S';
		int xCoord = 9;
		int yCoord = 9;
		int size = 3;
		
		Player player = new Player(name);
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		boolean result = player.placeShip(ship);
		assertEquals(result, false);
	}
	
	@Test
	void test_player_placeShip_E_success() 
	{
		String name = "Dan";
		char orientation = 'E';
		int xCoord = 0;
		int yCoord = 4;
		int size = 3;
		
		Player player = new Player(name);
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		boolean result = player.placeShip(ship);
		assertEquals(result, true);
	}
	
	@Test
	void test_player_placeShip_E_occupied() 
	{
		String name = "Dan";
		char orientation1 = 'S';
		int xCoord1 = 5;
		int yCoord1 = 2;
		int size = 3;

		char orientation2 = 'E';
		int xCoord2 = 3;
		int yCoord2 = 4;
		
		Player player = new Player(name);
		
		Ship ship1 = new Ship(orientation1, size, xCoord1, yCoord1);
		Ship ship2 = new Ship(orientation2, size, xCoord2, yCoord2);
		
		boolean result1 = player.placeShip(ship1);
		boolean result2 = player.placeShip(ship2);
		assertEquals(result1, true);
		assertEquals(result2, false);
	}
	
	@Test
	void test_player_placeShip_E_boundary() 
	{
		String name = "Dan";
		char orientation = 'E';
		int xCoord = 9;
		int yCoord = 9;
		int size = 3;
		
		Player player = new Player(name);
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		boolean result = player.placeShip(ship);
		assertEquals(result, false);
	}
	
	@Test
	void test_player_placeShip_W_success() 
	{
		String name = "Dan";
		char orientation = 'W';
		int xCoord = 4;
		int yCoord = 4;
		int size = 3;
		
		Player player = new Player(name);
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		boolean result = player.placeShip(ship);
		assertEquals(result, true);
	}
	
	@Test
	void test_player_placeShip_W_occupied() 
	{
		String name = "Dan";
		char orientation1 = 'S';
		int xCoord1 = 5;
		int yCoord1 = 2;
		int size = 3;

		char orientation2 = 'W';
		int xCoord2 = 6;
		int yCoord2 = 4;
		
		Player player = new Player(name);
		
		Ship ship1 = new Ship(orientation1, size, xCoord1, yCoord1);
		Ship ship2 = new Ship(orientation2, size, xCoord2, yCoord2);
		
		boolean result1 = player.placeShip(ship1);
		boolean result2 = player.placeShip(ship2);
		assertEquals(result1, true);
		assertEquals(result2, false);
	}
	
	@Test
	void test_player_placeShip_W_boundary() 
	{
		String name = "Dan";
		char orientation = 'W';
		int xCoord = 0;
		int yCoord = 0;
		int size = 3;
		
		Player player = new Player(name);
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		boolean result = player.placeShip(ship);
		assertEquals(result, false);
	}
	
	@Test
	void test_player_placeShip_bad_value() 
	{
		String name = "Dan";
		char orientation = 'X';
		int xCoord = 0;
		int yCoord = 0;
		int size = 3;
		
		Player player = new Player(name);
		
		Ship ship = new Ship(orientation, size, xCoord, yCoord);
		
		boolean result = player.placeShip(ship);
		assertEquals(result, false);
	}
}
