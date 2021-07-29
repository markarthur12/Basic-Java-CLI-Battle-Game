package markGabiana;

public class Player {
	
	private String player;
	private String playerType;
	
	private int level;
	private int life;
	private int experience;
	private int damage;
	
	public String getPlayer() 
	{
	     return player;
	}
	
	public String getPlayerType() 
	{
	     return playerType;
	}

	public void setPlayer(String name) 
	{
	     this.player = name;
	}
	
	public void setPlayerType(String type) 
	{
	     this.playerType = type;
	}

}
