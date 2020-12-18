package battleship.domain;

import java.util.ArrayList;

public class Controller 
{
	Player player1;
	Player player2;
	Player currentPlayer;

	public Controller(String name1, String name2)
	{
		this.player1 = new Player(name1);
		this.player2 = new Player(name2);
		this.currentPlayer = this.player1;
	}
	
	public boolean placeNextShip(int[] coords, char orientation)
	{
		Ship nextShip = this.currentPlayer.nextShip();
		boolean placed = true;
		
		if (nextShip == null)
		{
			return false;
		}
	
		boolean unoccupied = this.currentPlayer.addShip(nextShip, orientation, coords[1], coords[0]);
		
		if(unoccupied == false)
		{
			nextShip.nullStart();
			placed = false;
		}
		
		return placed;
	}
	
	public void nextPlayer()
	{
		if (this.currentPlayer == this.player1)
		{
			this.currentPlayer = this.player2;
		}
		else
		{
			this.currentPlayer = this.player1;
		}
	}
	
	public Player getPlayer1() 
	{
		return player1;
	}

	public Player getPlayer2() 
	{
		return player2;
	}

	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public Player getOpposingPlayer()
	{
		if (this.currentPlayer == this.player1)
		{
			return this.player2;
		}
		else
		{
			return this.player1;
		}
	}
}
