package battleship.domain;

public class Cruiser extends Ship 
{
	private static int cruiserSize = 3;
	private String type = "Cruiser";

	public Cruiser()
	{
		super();
	}
	
	public Cruiser(char orientation, int xCoord, int yCoord) 
	{
		super(orientation, cruiserSize, xCoord, yCoord);
	}

	public String getType() 
	{
		return type;
	}
	
	public int getSize() 
	{
		return cruiserSize;
	}

}
