package battleship.domain;

import java.io.IOException;

import edu.princeton.cs.introcs.*;

public class UserInterface
{
	private static char[] yAxisList = {'A','B','C','D','E','F','G','H','I','J'};
	
	public void drawPlayerOcean(Square[][] oceanMatrix)
	{
		StdOut.println("Your Ocean Status:");
		String rowString = "     |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 1 0 |";
		StdOut.println(rowString);
		printDividerLine();
		for(int y = 0; y < oceanMatrix[0].length; y++)
		{
			rowString = "  " + yAxisList[y] + "  |";
			
			for (int x = 0; x < oceanMatrix.length; x++)
			{
				Square square = oceanMatrix[x][y];
				char contents;
				if(square.isHit() && square.isOccupied())
					contents = 'X';
				else if(square.isHit())
					contents = '*';
				else if(square.isOccupied())
					contents ='#';
				else
					contents = ' ';
				
				rowString += "  " + contents + "  |";
			}
			StdOut.println(rowString);
			printDividerLine();
 		}
	}
	
	public void drawOpponentOcean(Square[][] oceanMatrix)
	{
		StdOut.println("Opponent Ocean Status:");
		String rowString = "     |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 1 0 |";
		StdOut.println(rowString);
		printDividerLine();
		for(int y = 0; y < oceanMatrix[0].length; y++)
		{
			rowString = "  " + yAxisList[y] + "  |";
			
			for (int x = 0; x < oceanMatrix.length; x++)
			{
				Square square = oceanMatrix[x][y];
				char contents;
				if(square.isHit() && square.isOccupied())
					contents = 'X';
				else if(square.isHit())
					contents = '*';
				else
					contents = ' ';
				
				rowString += "  " + contents + "  |";
			}
			StdOut.println(rowString);
			printDividerLine();
 		}
	}
	
	private void printDividerLine()
	{
		String rowString = "-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+";
		StdOut.println(rowString);
	}
	
	public void clearConsole()
	{
	   for(int i=0; i<100; i++)
	   {
		   StdOut.println();
	   }
	}
	
	public String promptPlayerName(int playerNum)
	{	
		StdOut.print("Enter player " + playerNum + " name:");
		
		String name = StdIn.readString();
		
		return name;
	}
	
	public boolean promptDraw(String name)
	{
		boolean draw;
		
		StdOut.print("Print " + name + "'s Ocean(Y/N):");
		
		String end = StdIn.readString();

		if (end.equalsIgnoreCase("Y") || end.equalsIgnoreCase("Yes")) 
		{
			draw = true;
		}
		else if(end.equalsIgnoreCase("N") || end.equalsIgnoreCase("No"))
		{
			draw = false;
		}
		else
		{
			StdOut.println("Invalid response");
			draw = promptDraw(name);
		}
		return draw;
	}
	
	public void fireResult(boolean hit)
	{
		if (hit)
		{
			StdOut.println("It's a HIT!");
		}
		else
		{
			StdOut.println("Missed...");
		}
		
	}
	
	public int[] promptPlaceShip(Ship ship)
	{
		StdOut.println();
		StdOut.println("Placing " + ship.getType() + "...");
		StdOut.println("Size of: " + ship.getSize());
		
		int[] coords = promptCoords();

		return coords;
	}
	
	public int[] promptFire(String name)
	{
		StdOut.println(name + "'s Firing Round!");
		
		int[] coords = promptCoords();

		return coords;
	}
	
	public int[] promptCoords()
	{
		StdOut.print("Select Row (A-J):");
		
		String row = StdIn.readString();
		
		int numRow = charToInt(row);
		
		if (numRow == -1)
		{
			StdOut.println("Invalid Coordinates, please try again!");
			return promptCoords();
		}
		
		StdOut.print("Select Column (1-10):");
		
		int column = StdIn.readInt();
		
		if (column == -1)
		{
			StdOut.println("Invalid Coordinates, please try again!");
			return promptCoords();
		}
		
		column -= 1;
		
		int[] coords = {numRow, column};
		
		return coords;
	}
	
	public char promptPlaceShipOrientation()
	{
		StdOut.print("Select Ship Orientation (N/S/W/E):");
		
		String orient = StdIn.readString();
	
		char o = orient.charAt(0);
		
		o = Character.toUpperCase(o);
		
		return o;
	}
	
	public void promptEndTurn() 
	{
		StdOut.print("Ready to end turn? (Y/N):");
		
		String end = StdIn.readString();
		
		if (end.equalsIgnoreCase("Y") || end.equalsIgnoreCase("Yes")) 
		{
			return;
		}
		else if(end.equalsIgnoreCase("N") || end.equalsIgnoreCase("No"))
		{
			promptEndTurn();
		}
		else
		{
			StdOut.println("Invalid response");
			promptEndTurn();
		}
	}
	
	private int charToInt(String character)
	{
		char c = character.charAt(0);
		c = Character.toUpperCase(c);
		
		for (int i=0; i < yAxisList.length; i++)
		{
			if (c == yAxisList[i])
			{
				return i;
			}
		}
		return -1;
	}
	
	public void printDestoryedShips(int destoryedCount)
	{
		StdOut.println("Ships destoryed: " + destoryedCount);
	}
	
	public void printGameOver(String name)
	{
		StdOut.println(name + "loses...");
	}
	
	public void printTurn(String name)
	{
		StdOut.println(name + "'s turn starting...");
	}
	
	public void printInvalid()
	{
		StdOut.println("----------------------------------");
		StdOut.println("Invalid placement please try again");
		StdOut.println("----------------------------------");
	}
}