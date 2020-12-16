package battleship.domain;

public class Battleship extends Ship 
{
	private static int battleshipSize = 4;
	private String type = "Battleship";

	public Battleship()
	{
		super();
	}
			
	public Battleship(char orientation, int xCoord, int yCoord) 
	{
		super(orientation, battleshipSize, xCoord, yCoord);
	}

	public String getType() 
	{
		return type;
	}
	
	public int getSize() 
	{
		return battleshipSize;
	}

}
