package battleship.domain;

public class Destroyer extends Ship
{
	private static int destroyerSize = 2;
	private String type = "Destroyer";
	
	public Destroyer()
	{
		super(destroyerSize);
	}
	
	public Destroyer(char orientation, int xCoord, int yCoord) 
	{
		super(orientation, destroyerSize, xCoord, yCoord);
	}

	public String getType() 
	{
		return type;
	}

	public int getSize() 
	{
		return destroyerSize;
	}

}
