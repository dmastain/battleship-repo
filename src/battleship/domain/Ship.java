package battleship.domain;

import java.util.ArrayList;
import java.util.List;

public class Ship
{
	private char orientation;
	private int size;
	private int hits;
	private int[] startSquare;
	private boolean destroyed;
	private String type = "Generic ship";
	
	public Ship()
	{
		this.destroyed = false;
	}
	
	public Ship(char orientation, int size, int xCoord, int yCoord) 
	{
		this.orientation = orientation;
		this.size = size;
		this.startSquare = new int[]{xCoord,yCoord};
		this.destroyed = false;
	}

	public char getOrientation() {
		return orientation;
	}

	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}

	public int getSize() 
	{
		return size;
	}

	public void setSize(int size) 
	{
		this.size = size;
	}

	public int getHits()
	{
		return hits;
	}

	public void addHits(int hits) 
	{
		this.hits += hits;
	}

	public int[] getStartSquare() 
	{
		return startSquare;
	}

	public void setStartSquare(int xCoord, int yCoord) 
	{
		if (this.startSquare == null)
		{
			this.startSquare = new int[]{xCoord,yCoord};
		}
		else
		{
			this.startSquare[0] = xCoord;
			this.startSquare[1] = yCoord;	
		}
	}
	
	public boolean isDestroyed()
	{
		if (this.hits >= this.size)
		{
			this.destroyed = true;
		}
		
		return this.destroyed;
	}

	public String getType() 
	{
		return type;
	}
	
	public void nullStart() 
	{
		this.startSquare = null;
	}
}
