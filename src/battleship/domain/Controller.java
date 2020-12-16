package battleship.domain;

public class Controller 
{
	Player player1;
	Player player2;
	
	public Controller(String player1Name, String player2Name)
	{
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player2Name);
	}
	
}
