package Players;


public class ArcadePlayer {
    // the attributes
    private String playerId;
    private String playerName;
    private double score;

    // the methods

    // the constructor
    public ArcadePlayer(String numberIn, String nameIn)
    {
        playerId = numberIn;
        playerName = nameIn;
        score = 0;
    }

    // methods to read the attributes
    public String getPlayerName()
    {
        return playerName;
    }

    public String getPlayerId()
    {
        return playerId;
    }

    public double getScore()
    {
        return score;
    }

    // setter methods to assign new values individually to the attributes
    public void setPlayerName(String playerName)
   {
       this.playerName= playerName;
   }
   
   
   public void setPlayerId(String playerId)
   {
       this.playerId= playerId;
   }
   
   public void setScore(double score)
   {
       this.score = score;
   }
   
   
    // methods to deposit and withdraw money
    public void add(double scoreIn)
    {
        score = score + scoreIn;
    }

    public boolean reduce(double scoreIn)
    {
        if(scoreIn > score)
        {
            return false;
        }	
        else
        {
            score = score - scoreIn;
            return true;
        }
    }
    public String toString()
    {
    	return "Player Id: " + playerId + " Player Id:  " + playerName + "  Score: " + score;
    }

}

