package battleship.domain;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;

public class GameApp 
{	
	public static void main(String[] args)
	{
		int numPlayers = 2;
		int numShips = 5;
		
		UserInterface ui = new UserInterface();
		String player1Name = ui.promptPlayerName(1);
		String player2Name = ui.promptPlayerName(2);
		
		Controller controller = new Controller(player1Name, player2Name);
		
		for (int p = 0; p < numPlayers; p++)
		{
			Player player = controller.getCurrentPlayer();
			
			ui.printTurn(player.getName());
			
			int placedShips = 0;
			
			while(placedShips < numShips)
			{
				ui.drawPlayerOcean(player.getOceanMatrix());
				
				int[] coords = ui.promptPlaceShip(player.nextShip());
				char orientation = ui.promptPlaceShipOrientation();
				
				boolean placed = controller.placeNextShip(coords, orientation);
				
				if (placed == true)
				{
					placedShips++;
				}
				else
				{
					ui.printInvalid();
				}
			}
			ui.drawPlayerOcean(player.getOceanMatrix());
			ui.promptEndTurn();
			controller.nextPlayer();
			ui.clearConsole();
		}
			
		
		while(true)
		{
			boolean gameOver = false;
			
			while(true)
			{
				Player player = controller.getCurrentPlayer();
				Player opponent = controller.getOpposingPlayer();
				String name = player.getName();
				
				ui.printTurn(name);
				boolean drawOcean = ui.promptDraw(name);
				
				if(drawOcean)
				{
					ui.drawPlayerOcean(player.getOceanMatrix());
				}
				
				ui.drawOpponentOcean(opponent.getOceanMatrix());
				
				int[] coords = ui.promptFire(name);
				
				Square fireSquare = opponent.getOceanMatrix()[coords[1]][coords[0]];
				boolean hitShip = fireSquare.setHit(true);
				ui.drawOpponentOcean(opponent.getOceanMatrix());
				
				ui.fireResult(hitShip);
				
				int destroyed = player.countDestroyedShips();
				ui.printDestoryedShips(destroyed);
				
				if ( destroyed == 5)
				{
					ui.printGameOver(name);
					gameOver = true;
					break;
				}
				
				ui.promptEndTurn();
				controller.nextPlayer();
				ui.clearConsole();
			}
			
			if (gameOver == true)
			{
				break;
			}
		}
	}
}
