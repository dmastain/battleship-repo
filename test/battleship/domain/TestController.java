package battleship.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestController 
{
	@Test
	void test_init_controller() 
	{
		String name1 = "Dan";
		String name2 = "Zoe";
		
		Controller controller = new Controller(name1, name2);
		
		assertEquals(controller.getPlayer1().getName(), name1);
		assertEquals(controller.getPlayer2().getName(), name2);
		assertEquals(controller.getPlayer1(), controller.getCurrentPlayer());
		assertEquals(controller.getPlayer2(), controller.getOpposingPlayer());
	}
	
	@Test
	void test_controller_next_player() 
	{
		String name1 = "Dan";
		String name2 = "Zoe";
		
		Controller controller = new Controller(name1, name2);
		
		assertEquals(controller.getPlayer1(), controller.getCurrentPlayer());
		assertEquals(controller.getPlayer2(), controller.getOpposingPlayer());
		
		controller.nextPlayer();
		
		assertEquals(controller.getPlayer2(), controller.getCurrentPlayer());
		assertEquals(controller.getPlayer1(), controller.getOpposingPlayer());
		
		controller.nextPlayer();
		
		assertEquals(controller.getPlayer1(), controller.getCurrentPlayer());
		assertEquals(controller.getPlayer2(), controller.getOpposingPlayer());
	}
	
	@Test
	void test_controller_place_next()
	{
		int numShips = 5;
		int placedShips = 0;
		String name1 = "Dan";
		String name2 = "Zoe";
		
		Controller controller = new Controller(name1, name2);
		
		for(int i = 0; i < numShips; i++)
		{
			int[] coords = new int[]{i , 0};
			char orientation = 'E';
			
			boolean placed = controller.placeNextShip(coords, orientation);
			
			if (placed)
			{
				placedShips++;
			}
			
		}
		assertEquals(placedShips, numShips);
	}
	
	@Test
	void test_controller_place_next_out_of_range()
	{
		int numShips = 5;
		int placedShips = 0;
		String name1 = "Dan";
		String name2 = "Zoe";
		boolean placed = true;
		
		Controller controller = new Controller(name1, name2);
		
		for(int i = 0; i < numShips + 1; i++)
		{
			int[] coords = new int[]{i , 0};
			char orientation = 'E';
			
			placed = controller.placeNextShip(coords, orientation);
			
			if (placed)
			{
				placedShips++;
			}
			else
			{
				break;
			}
			
		}
		assertEquals(placedShips, numShips);
		assertEquals(placed, false);
	}
	
	@Test
	void test_controller_place_next_ship_occupied() 
	{
		char orientation1 = 'N';
		char orientation2 = 'E';
		int[] Coords1 = {5,4};
		int[] Coords2 = {5,4};
		int size = 3;
		String name1 = "Dan";
		String name2 = "Zoe";
		
		Controller controller = new Controller(name1, name2);
		
		boolean placed1 = controller.placeNextShip(Coords1, orientation1);
		boolean placed2 = controller.placeNextShip(Coords2, orientation2);
		
		assertEquals(placed1, true);
		assertEquals(placed2, false);
	}
}
