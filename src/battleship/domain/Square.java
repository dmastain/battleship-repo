package battleship.domain;

public class Square
{
	private Ship occupyingShip;
	private boolean occupied;
	private boolean hit;

	public Square()
	{
		this.occupied = false;
		this.hit = false;
	}
	
	public boolean isOccupied()
	{
		return occupied;
	}

	public void setOccupied(boolean occupied) 
	{
		this.occupied = occupied;
	}

	public boolean isHit() 
	{
		return hit;
	}

	public boolean setHit(boolean hit)
	{
		boolean hitShip = false;
		this.hit = hit;
		if(occupyingShip != null)
		{
			hitShip = true;
			occupyingShip.addHits(1);
		}
		return hitShip;
	}

	public Ship getOccupyingShip()
	{
		return occupyingShip;
	}

	public void setOccupyingShip(Ship occupyingShip)
	{
		this.occupyingShip = occupyingShip;
		setOccupied(true);
	}
	

	public void clearOccupyingShip()
	{
		this.occupyingShip = null;
		setOccupied(false);
	}
}
