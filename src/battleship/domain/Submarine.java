package battleship.domain;

public class Submarine extends Ship
{
	private static int subSize = 3;
	private String type = "Submarine";
	
	public Submarine()
	{
		super();
	}

	public Submarine(char orientation, int column, int row) 
	{
		super(orientation, subSize, column, row);
	}

	public String getType() 
	{
		return type;
	}
	
	public int getSize() 
	{
		return subSize;
	}

}
