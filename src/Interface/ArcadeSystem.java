package Interface;

import java.util.Scanner;

import Players.Arcade;
import Players.ArcadePlayer;


import Boards.TicTacToe;
import Boards.ConnectFour;


public class ArcadeSystem 
{

	//Attributes / Instance Variables
    private  Scanner input;						//Create a Scanner object called input that can be used by all methods in the class.
    Arcade arcade1;									//Create a Arcade object called arcade1 that can be used by all methods in the class
    // The constructor creates an instance of the Scanner class  - instantiates the above input object
    // and creates an instance of the Arcade class -  instantiates the above arcade1 object.
	public ArcadeSystem()
    {
        input = new Scanner(System.in);    
        arcade1 = new Arcade();
        
   	 System.out.print("Would you like to select a game? (Y/N): ");
     String choose = input.next();
     if (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("n"))		
		{
     	System.out.println("Invalid option entered: ");
     	choose = input.next();
		}
     	runMenu();
     
}   //The main method will create an instance of itself (i.e. the ArcadeSystem class)
   //and call the runMenu method over this instance.
    public static void main (String args[])
    {
    	
    	
    	ArcadeSystem app = new ArcadeSystem();  
        	app.runMenu();
        	
    }
 

    //Methods

    /*
     * mainMenu() - This method displays the menu for the application, 
     * reads the menu option that the user entered and returns it.
     * 
     * @return     the users menu choice
     */
    
      private int mainMenu() 
     {
        System.out.println("*Please select a game*");
		
		System.out.println(" 	1) Connect 4.");										  
		System.out.println("	2) TicTacToe.");

		System.out.println(" 	0) Exit");	
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
	 }
    
    
    private int arcadeDisplay()
    {   
                                          
    	System.out.println(",,,,, ............................................................... ,,,,,");                                        
    	System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");                                          
    	System.out.println(",*,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,  ");                                         
    	System.out.println(",,,,         ▄▄▄· ▄▄▄   ▄▄·  ▄▄▄· ·▄▄▄▄  ▄▄▄ .                   ,,,       ");                                         
    	System.out.println(".,,,,.      ▐█ ▀█ ▀▄ █·▐█ ▌▪▐█ ▀█ ██▪ ██ ▀▄.▀·                 .,,,,       ");                                         
    	System.out.println(",  ,,       ▄█▀▀█ ▐▀▀▄ ██ ▄▄▄█▀▀█ ▐█· ▐█▌▐▀▀▪▄                 ,,.,,.      ");                                       
    	System.out.println(",,. ,,,,,,  ▐█ ▪▐▌▐█•█▌▐███▌▐█ ▪▐▌██. ██ ▐█▄▄▌ ,,,,,,,,,,,,,,,,,,,,,  ,,   ");                                       
    	System.out.println(",,, ,,,,.    ▀  ▀ .▀  ▀·▀▀▀  ▀  ▀ ▀▀▀▀▀•  ▀▀▀                 .,,,, ,,,    ");                                       
    	System.out.println(",,, ,,,,.                                                    .,,,, ,,      ");                                       
    	System.out.println(",, ,,,,.  ,..,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, ..,,,.,,,, ,,.        ");                                      
    	System.out.println(",, ,,,,.  ,  ,, ...................................  ,, ,,,.,,,,.,,        ");                                      
    	System.out.println(",,.,,,,.  , ,,   ####### Arcade Menu #######          , ,,,.,,,, ,         ");                                      
    	System.out.println(", ,,,,.  ,,,,  1) Add a player                       ,,,,,.,,,, ,          ");                                     
    	System.out.println(", ,,,,.  ,,,   2) List all players                   ,,,,,.,,,,,,.         ");                                     
    	System.out.println(", ,,,,.  ,,,   3) Remove player (by index)           ,,,,,.,,,,,,.         ");                                     
    	System.out.println(".,,,,,,.  ,,,  4) Add points                         ,,,,,,.,,,,,,         ");                                      
    	System.out.println(",,,,,,.  ,,,   5) Remove Points                      ,,,,,.,,,,,,          ");
    	System.out.println(",,,,,,.  ,,,   -----------------------------------   ,,,,,.,,,,,,          ");
    	System.out.println(",,,,,,.  ,,,   6) Number of players in the arcade    ,,,,,.,,,,,,          ");                                     
    	System.out.println(",,,,,,.  ,,,,  7) List players with a High score     ,,,,,,,.,,,,,         ");                                     
    	System.out.println(",,,,,,.  ,,,,  8) List average player scores         ,,,,,.,,,,,,          ");                                     
    	System.out.println(",,,,,,.  , ,,. 9) Save Players to players.xml        , ,,,.,,,,,,          ");
    	System.out.println(",,,,,,.  , ,,. 10)Load Players from players.xml      , ,,,.,,,,,,          ");
    	System.out.println(",,,,,,.  , ,,. 11)Play Game                          , ,,,.,,,,,,          ");
    	System.out.println(",,,,,,.  , ,,.                        0) Exit        , ,,,.,,,,,,          ");    	
    	System.out.println(",,,,,,. ,,  ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,  ,,,.,,,,,,          ");                                     
    	System.out.println(",, ,,,,.  ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.,,,,,,.        ");                                      
    	System.out.println(",, ,,,,  . .                                            .  .,,,, ,,        ");                                      
    	System.out.println(",, ,,,, .                                                   ,,,,.,,        ");                                      
    	System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.      ");                                       
    	System.out.println(",,,,    .,,,,,,. ,,,,,       ,,,     ,,,       ,,,,, . ,,,,,.   ,,,,,      ");                                       
    	System.out.println(",,,     .,,, . .,,,,          ,,.   .,,          ,,,,  . ,, .     ,,,      ");                                       
    	System.out.println(",,              .,,,,                             ,,,,.             ,,,.   ");                                        
    	System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,  ");                                         
    	System.out.println(".,,                                                                   ,,.  ");                                         
    	System.out.println(".,,                                                                 ,,.    ");                                        
    	System.out.println(",,,                                                               ,,,      ");                                       
    	System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,        ");                                      
   /* 	System.out.println("  ▄▄▄· ▄▄▄   ▄▄·  ▄▄▄· ·▄▄▄▄  ▄▄▄ .     ");
    	System.out.println(" ▐█ ▀█ ▀▄ █·▐█ ▌▪▐█ ▀█ ██▪ ██ ▀▄.▀·   ");  
    	System.out.println(" ▄█▀▀█ ▐▀▀▄ ██ ▄▄▄█▀▀█ ▐█· ▐█▌▐▀▀▪▄    "); 
    	System.out.println(" ▐█ ▪▐▌▐█•█▌▐███▌▐█ ▪▐▌██. ██ ▐█▄▄▌    "); 
    	System.out.println("  ▀  ▀ .▀  ▀·▀▀▀  ▀  ▀ ▀▀▀▀▀•  ▀▀▀      ");
    	System.out.println("*** Arcade Menu ***");
        System.out.println("---------");     
        System.out.println("  1) Add a player");    
        System.out.println("  2) List all players");
        System.out.println("  3) Remove/Delete a player (by index)");
        System.out.println("  4) Add points");
        System.out.println("  5) Remove Points");
        System.out.println("---------"); 
        System.out.println("  6) Number of players in the arcade");       
        System.out.println("  7) List all players who have a positive score");        
        System.out.println("  8) List average player scores");
        System.out.println("---------");   
        System.out.println("  9) Save Players to players.xml");
        System.out.println("  10) Load Players from players.xml");
        System.out.println("  0) Exit");
        System.out.print("==>> ");    */
         int option = input.nextInt();
         return option;
    }
   
    
    private void runMenu()
    {
        int option = mainMenu();
        while (option != 0)
        {
            switch (option)
            {
                //call up the add Member method
                case 1:     menuC4();
                            break;
            
                //prints list of members that is stored in the array gym1             
                case 2:     menuTTT();
                            break;
                 
                default:   	System.out.println("Invalid option entered: " + option);
                			break;
            				}

                //gives time for reader to read the console, 
                //when finish press any key to display main menu again
                System.out.println("\nPress any key to return to main menu");
                input.nextLine();
                //input.nextLine(); 
            
                //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting the Gym... bye bye");
        System.exit(0);
    }

   
    private void menuC4()
    {
        int option = arcadeDisplay();
        do
        
        {

            switch (option)
            {
            case 1:    	addPlayer();
           				break;
            case 2:    	System.out.println(arcade1.listPlayers());
            			break;
            case 3:    	removePlayer();
						break;
            case 4:    	addScore();
						break;
            case 5:  	reduceScore();
						break;
            case 6:    	System.out.println("Number of players: " + arcade1.numberOfPlayers());
						break;
            case 7:    	System.out.println(arcade1.listPlayersWithPositiveScore());
        				break;
            case 8:    	System.out.println(arcade1.averageScore());
						break;
 			
            case 9: 	try{
                				arcade1.save();
                			}
                			catch(Exception e){
                					System.out.println("Error writing to file:  " + e);
                			}
    						break;
            case 10:	try{
                				arcade1.load();
                			}
                			catch(Exception e)
                			{
                				System.out.println("Error reading from file: " + e);
                			}
                			break;
                			
            case 11:       runC4();
                			
                default:   System.out.println("Invalid option entered: " + option);
                        
            }

            //display the main menu again
            option = arcadeDisplay();
        }while (option != 0);

        //the user chose option 0, so exit the program
        System.out.println("Arcade Closing...bye bye");
        System.exit(0);
    }
    
    private void menuTTT()
    {
        int option = arcadeDisplay();
        do
        
        {

            switch (option)
            {
            case 1:    	addPlayer();
           				break;
            case 2:    	System.out.println(arcade1.listPlayers());
            			break;
            case 3:    	removePlayer();
						break;
            case 4:    	addScore();
						break;
            case 5:  	reduceScore();
						break;
            case 6:    	System.out.println("Number of players: " + arcade1.numberOfPlayers());
						break;
            case 7:    	System.out.println(arcade1.listPlayersWithPositiveScore());
        				break;
            case 8:    	System.out.println(arcade1.averageScore());
						break;
 			
            case 9: 	try{
                				arcade1.save();
                				System.out.println("Players Saved ");
                			}
                			catch(Exception e){
                					System.out.println("Error writing to file:  " + e);
                			}
    						break;
            case 10:	try{
                				arcade1.load();
                				System.out.println("Players Loaded ");
                				
                			}
                			catch(Exception e)
                			{
                				System.out.println("Error reading from file: " + e);
                			}
                			break;
                			
            case 11:    try{   
            	
            	        runTTT();
        	}
			catch(Exception e)
			{
				System.out.println("Error reading from file: " + e);
			}
			break;
                			
                default:   System.out.println("Invalid option entered: " + option);
                        
            }

            //display the main menu again
            option = arcadeDisplay();
        }while (option != 0);

        //the user chose option 0, so exit the program
        System.out.println("Arcade Closing...bye bye");
        System.exit(0);
    }
    
    
   

    
    private void runTTT()
    {
    	TicTacToe TTT = new TicTacToe();
    TTT.BoardTemplate();
    }
   
    private void runC4()
    {
    	ConnectFour C4 = new ConnectFour();
    	C4.BoardTemplate();
    }
    

    private void addPlayer()
    {
        System.out.println("Please enter the following player details...");
        System.out.print("\tPlayer Id: ");
        String playerId = input.next();
        System.out.print("\tName : ");
        String playerName = input.nextLine();
        playerName = input.nextLine();
      
        arcade1.add(new ArcadePlayer(playerId, playerName));
    }
    public void removePlayer()
    {
    	//List the players and ask the user to choose which account to delete
    	System.out.println(arcade1.listPlayers());
    	if(arcade1.getPlayers().size()!=0)
    	{
    		//Only process the delete if products exist in the Arraylist
    	   	System.out.println("Index of ArcadePlayer to delete ==>");
    	   	int index = input.nextInt();
        
    	   	if(index<arcade1.getPlayers().size())
    	   	{
    	   		//If the index number exists in the Arraylist, delete it from the arraylist
    	   		arcade1.getPlayers().remove(index);
    	   		System.out.println("Player Removed");
    	   	}
    	   	else
    	   	{
    	   		System.out.println("There is no Player for this index number");
    	   	}
       	}
    }
        
    public void editPlayer()
    {
        //list the accounts and ask the user to choose the account to edit
    	System.out.println(arcade1.listPlayers());
   
    	if (arcade1.getPlayers().size() != 0){	
    		//only process the update if account exists in the ArrayList
    		System.out.print("Index of player to edit ==>");
    		int index = input.nextInt();
    		
    		if (index < arcade1.getPlayers().size()){	
    			//if the index number exists in the ArrayList, gather the new details from the user
    			 	System.out.print("\tAccount Number: ");
    			 	String playerId = input.next();
    		        System.out.print("\tName : ");
    		        String playerName = input.nextLine();
    		        playerName = input.nextLine();
    	
    			//retrieve the product from the ArrayList and update the details with the user input
    			ArcadePlayer acc = arcade1.getPlayers().get(index);
    			acc.setPlayerName(playerName);
    			acc.setPlayerId(playerId);
    			
    		}
    		else
            {
            	System.out.println("There is no player for this index number");
            }
        }
    }  
 // deposit money in an account
    private void addScore()
    {
    	
    	//list the products and ask the user to choose the product to edit
    	System.out.println(arcade1.listPlayers());
   
    	if (arcade1.getPlayers().size() != 0){	
    		//only process the update if products exist in the ArrayList
    		System.out.print("Index of player to update ==>");
    		int index = input.nextInt();
    		
    		if (index < arcade1.getPlayers().size()){	
    			//if the index number exists in the ArrayList, gather the new details from the player
    			System.out.print("   Enter points to add: ");
    			double addScore = input.nextDouble();
    			
    			
    			//retrieve the ArcadePlayer from the ArrayList and update the details with the user input
    			ArcadePlayer player = arcade1.getPlayers().get(index);
    			player.add(addScore);
    			}
    		else
            {
            	System.out.println("There is no player for this index number");
            }
        }}
    	 // remove points from an player
        private void reduceScore()
        {
        	
        	//list the products and ask the user to choose the product to edit
        	System.out.println(arcade1.listPlayers());
       
        	if (arcade1.getPlayers().size() != 0){	
        		//only process the update if products exist in the ArrayList
        		System.out.print("Index of player to penalise ==>");
        		int index = input.nextInt();
        		
        		if (index < arcade1.getPlayers().size()){	
        			//if the index number exists in the ArrayList, gather the new details from the player
        			System.out.print("   Enter amount to reduce by: ");
        			double reduceScore = input.nextDouble();
        			
        			
        			//retrieve the arcadeplayer from the ArrayList and update the details with the player input
        			ArcadePlayer player = arcade1.getPlayers().get(index);
        			player.reduce(reduceScore);
        			}
        		else
                {
                	System.out.println("There is no arcade player for this index number");
                }
            }
   
    }
}
