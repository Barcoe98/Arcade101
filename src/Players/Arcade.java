package Players;

import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Arcade {
	 // attributes

		private ArrayList<ArcadePlayer> players; // to hold the players
		// methods
	    // the constructor
	    public Arcade()
	    {
	    	players = new ArrayList<ArcadePlayer>();
	    }
	    //New Method to return all Arcade Players in the arraylist
	    public ArrayList<ArcadePlayer> getPlayers()
	    {
	    	return players;
	    }
	 
	    
	    //Add a arcade player object to the Arraylist
		public void add (ArcadePlayer playeracc){
	        players.add (playeracc); 
	    }

		// Removes a ArcadePlayer from the arcade collection.
	    // @param index The index number of the ArcadePlayer object that will be removed from the arcade collection.
	     public void remove(int index){
	        players.remove(index);
	    }
		

	     //Returns the number of ArcadePlayer stored in the arcade collection.
	     // @return The number of the ArcadePlayer object currently stored in the arcade collection.
	     public int numberOfPlayers(){
	         return players.size();
	     }
	     
	     public String listPlayers(){
	         if (players.size() > 0){
	        	 
	             String listOfPlayers = "";
	             for (int i = 0; i < numberOfPlayers(); i++){
	            	 listOfPlayers += i + ": " + players.get(i) + "\n";        
	             }
	             return listOfPlayers;
	         }
	         else{
	             return "There are no players in the Arcade";
	         }
	     } 
	     public String listPlayersWithPositiveScore()
	 	{
	 		String str = "";    
	 		for (int i = 0; i < players.size(); i++){
	 			if (players.get(i).getScore() >=0)
	 				str = str + i + ": " + players.get(i) + "\n";
	 		}
	 		
	 		if (str.equals(""))
	 			return "No Arcade Player Scores!";
	 		else
	 			return str;	
	 	}    
	 	
	 	//Returns the average Arcade Score
	 	public double averageScore()
	 	{ 
	 		if (players.size() != 0){
	 			double totalScore = 0;
	 			for (int i = 0; i < players.size(); i++){
	 				totalScore = totalScore + players.get(i).getScore();
	 			}
	 			return totalScore / players.size();
	 		}
	 		else{
	 			return 0.0;
	 		}
	 	}
	 	
	 	public String highestScore()
	 	{
	 		if (players.size() != 0){
	 			ArcadePlayer highScore = players.get(0);
	 			for (int i = 0; i < players.size(); i++){
	 				if (players.get(i).getScore() > highScore.getScore() )  
	 					highScore = players.get(i);
	 			}
	 			return highScore.getPlayerName();
	 		}
	 		else 
	 			return "No Scores are in the ArrayList";
	 	} 

	    @SuppressWarnings("unchecked")
	    public void load() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("players.xml"));
	       players = (ArrayList<ArcadePlayer>) is.readObject();
	        is.close();
	    }

	    public void save() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("players.xml"));
	        out.writeObject(players);
	        out.close();    
	    }

	    
	}

	 