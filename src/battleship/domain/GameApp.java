package battleship.domain;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;

public class GameApp 
{
	
	private static boolean placeNextShip(Player player, UserInterface ui)
	{
		Ship nextShip = player.nextShip();
		
		if (nextShip == null)
		{
			return true;
		}
		
		int[] coords = ui.promptPlaceShip(nextShip);
		char orientation = ui.promptPlaceShipOrientation();
		
		boolean unoccupied = player.addShip(nextShip, orientation, coords[1], coords[0]);
		
		if(unoccupied == false)
		{
			nextShip.nullStart();
			ui.printInvalid();
			return placeNextShip(player, ui);
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Player> playerList = new ArrayList<Player>(2);
		
		UserInterface ui = new UserInterface();
		String player1Name = ui.promptPlayerName(1);
		String player2Name = ui.promptPlayerName(2);
		
		Player player1 = new Player(player1Name);
		playerList.add(player1);
		Player player2 = new Player(player2Name);
		playerList.add(player2);
	
		Ship nextShip = null;
		
		for (Player player: playerList)
		{
			ui.printTurn(player.getName());
			ui.drawPlayerOcean(player.getOceanMatrix());
			while(true) 
			{
				boolean end = placeNextShip(player, ui);
				
				if (end == true)
				{
					break;
				}
				
				ui.drawPlayerOcean(player.getOceanMatrix());	
			}
			ui.clearConsole();
		}
		
		while(true)
		{
			boolean gameOver = false;
			
			for (Player player: playerList)
			{
				Square[][] opponentOcean;
				String name = player.getName();
				ui.printTurn(name);
				boolean drawOcean = ui.promptDraw(name);
				
				if(drawOcean)
				{
					ui.drawPlayerOcean(player.getOceanMatrix());
				}
				
				if (player == player1)
				{
			        opponentOcean = player2.getOceanMatrix();
					ui.drawOpponentOcean(player2.getOceanMatrix());
				}
				else
				{
					opponentOcean = player1.getOceanMatrix();
				}
				
				ui.drawOpponentOcean(opponentOcean);
				int[] coords = ui.promptFire(name);
				
				Square fireSquare = opponentOcean[coords[1]][coords[0]];
				boolean hitShip = fireSquare.setHit(true);
				ui.fireResult(hitShip);
				ui.drawOpponentOcean(opponentOcean);
				
				if (player.countDestroyedShips() == 5)
				{
					ui.printGameOver(name);
					gameOver = true;
					break;
				}
			}
			
			if (gameOver == true)
			{
				break;
			}
		}
	}
}
