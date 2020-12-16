package battleship.domain;

import edu.princeton.cs.introcs.StdOut;

public class Player
{
	private String name;
	private Square[][] oceanMatrix = new Square[10][10];
	private Destroyer destroyer;
	private Submarine sub;
	private Cruiser cruiser;
	private Battleship battleship;
	private AircraftCarrier carrier;
	
	public Player(String name)
	{
		this.setName(name);
		this.destroyer = new Destroyer();
		this.sub = new Submarine();
		this.cruiser = new Cruiser();
		this.battleship = new Battleship();
		this.carrier = new AircraftCarrier();
		
		for (int i = 0; i < oceanMatrix.length; i++)
		{
			for (int j = 0; j < oceanMatrix[0].length; j++)
			{
				oceanMatrix[i][j] = new Square();
			}
		}
	}
	
	public Ship nextShip()
	{
		Ship nextShip = null;
		
		if (destroyer.getStartSquare() == null)
		{
			nextShip = this.destroyer;
		}
		else if (sub.getStartSquare() == null)
		{
			nextShip = this.sub;
		}
		else if (cruiser.getStartSquare() == null)
		{
			nextShip = this.cruiser;
		}
		else if (battleship.getStartSquare() == null)
		{
			nextShip = this.battleship;
		}
		else if (carrier.getStartSquare() == null)
		{
			nextShip = this.carrier;
		}
		
		return nextShip;
	}
	
	public int countDestroyedShips()
	{
		int numDestroyed = 0;
		
		if (destroyer.isDestroyed() == true)
		{
			numDestroyed++;
		}
		if (sub.isDestroyed() == true)
		{
			numDestroyed++;
		}
		if (cruiser.isDestroyed() == true)
		{
			numDestroyed++;
		}
		if (battleship.isDestroyed() == true)
		{
			numDestroyed++;
		}
		else if (carrier.isDestroyed() == true)
		{
			numDestroyed++;
		}
		
		return numDestroyed;
	}
	
	public boolean addShip(Ship ship, char orientation, int xCoord, int yCoord)
	{
		boolean unoccupied = false;
		String type = ship.getType();
		
		switch(type)
		{
		  case "Destroyer":
			this.destroyer.setOrientation(orientation);
			this.destroyer.setStartSquare(xCoord, yCoord);
			unoccupied = placeShip(this.destroyer);
		    break;
		  case "Submarine":
			this.sub.setOrientation(orientation);
			this.sub.setStartSquare(xCoord, yCoord);
			unoccupied = placeShip(this.sub);
		    break;
		  case "Cruiser":
			this.cruiser.setOrientation(orientation);
			this.cruiser.setStartSquare(xCoord, yCoord);
			unoccupied = placeShip(this.cruiser);
		    break;
		  case "Battleship":
			this.battleship.setOrientation(orientation);
			this.battleship.setStartSquare(xCoord, yCoord);
			unoccupied = placeShip(this.battleship);
		    break;
		  case "AircraftCarrier":
			this.carrier.setOrientation(orientation);
			this.carrier.setStartSquare(xCoord, yCoord);
			unoccupied = placeShip(this.carrier);
		    break;
		  default:
		    break;
		}
		return unoccupied;
	}
	
	public boolean placeShip(Ship ship)
	{
		int[] coords = ship.getStartSquare();
		int xCoord = coords[0];
		int yCoord = coords[1];
		int size = ship.getSize();
		char orient = ship.getOrientation();
		boolean placed = true;
		
		switch (orient)
		{
		case 'N':
			for (int i = yCoord; i > yCoord - size; i--)
			{	
				if (i < 0)
				{
					placed = false;
				}
				else
				{
					Square square = oceanMatrix[xCoord][i];
					
					if (square.isOccupied())
					{
						placed = false;
					}
					else
					{
						square.setOccupyingShip(ship);
					}
				}
				
				if (placed == false)
				{
					for (int j = i + 1; j <= yCoord; j++)
					{
						Square square = oceanMatrix[xCoord][j];
						square.clearOccupyingShip();
					}
					break;
				}
			}
			break;
		case 'S':
			for (int i = yCoord; i < yCoord + size; i++)
			{		
				if(i >= oceanMatrix.length)
				{
					placed = false;
				}
				else
				{
					Square square = oceanMatrix[xCoord][i];
					
					if (square.isOccupied())
					{
						placed = false;
					}
					else
					{
						square.setOccupyingShip(ship);
					}
				}
				
				if (placed == false)
				{
					for (int j = i - 1; j >= yCoord; j--)
					{
						Square square = oceanMatrix[xCoord][j];
						square.clearOccupyingShip();
					}
					break;
				}
			}
			break;
		case 'E':
			for (int i = xCoord; i < xCoord + size; i++)
			{
				
				if(i >= oceanMatrix[0].length)
				{
					placed = false;
				}
				else
				{				
					Square square = oceanMatrix[i][yCoord];		
					
					if (square.isOccupied())
					{
						placed = false;
					}
					else
					{
						square.setOccupyingShip(ship);
					}
				}
				
				if (placed == false)
				{
					for (int j = i - 1; j >= xCoord; j--)
					{
						Square square = oceanMatrix[j][yCoord];
						square.clearOccupyingShip();
					}
					break;
				}
			}
			break;
		case 'W':
			for (int i = xCoord; i > xCoord - size; i--)
			{			
				if(i < 0)
				{
					placed = false;
				}
				else
				{
					Square square = oceanMatrix[i][yCoord];
					
					if (square.isOccupied())
					{
						placed = false;	
					}
					else
					{
						square.setOccupyingShip(ship);
					}
				}
				
				if (placed == false)
				{
					for (int j = i + 1; j <= xCoord; j++)
					{
						Square square = oceanMatrix[j][yCoord];
						square.clearOccupyingShip();
					}
					break;
				}
			}
			break;
		default:
			placed = false;
		}
		
		return placed;	
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Square[][] getOceanMatrix() 
	{
		return oceanMatrix;
	}
}
