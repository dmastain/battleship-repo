package battleship.domain;

public class AircraftCarrier extends Ship
{
	private static int aircraftCarrierSize = 5;
	private String type = "Aircraft Carrier";
	
	public AircraftCarrier()
	{
		super(aircraftCarrierSize);
	}

	public AircraftCarrier(char orientation, int xCoord, int yCoord) 
	{
		super(orientation, aircraftCarrierSize, xCoord, yCoord);
	}

	public String getType() 
	{
		return type;
	}
	
	public int getSize() 
	{
		return aircraftCarrierSize;
	}

}
