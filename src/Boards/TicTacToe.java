package Boards;

import java.util.Scanner;

public class TicTacToe extends Board{
	
	/**
	 * The main class for the Xs & Os
	 * overall game controller.
	 */
	 // Named-constants for the dimensions
	   public static final int ROWS = 3;
	   public static final int COLS = 3;
	 
	
	   private GamePhase currentState; // the current state of the game (of enum GamePhase)
	   private Piece currentPlayer;     // the current player (of enum Piece)
	 
	   private static Scanner in = new Scanner(System.in);  // input Scanner
	 
	   /** Constructor to setup the game */
	   public TicTacToe() {
		   
	      BoardTemplate();  // allocate game-board
	 
	      // Initialize the game-board and current status
	      initGame();
	      // Play the game once. Players CROSS and NOUGHT move alternately.
	      do {
	    	  paint();             // ask the board to paint itself
	         playerMove(currentPlayer); // update the content, currentRow and currentCol
	         	         updateGame(currentPlayer); // update currentState
	         // Print message if game-over
	         if (currentState == GamePhase.CROSS_WON) {
		            System.out.println("    ___   _  _  _ ___   ___  _   _ _________        \r\n" + 
		            		"   |  _ \\ / _ \\ |  \\/  ||  ___| |  _  || | | |  ___| __ \\       \r\n" + 
		            		"   | |  \\// /_\\ \\| .  . || |__   | | | || | | | |__ | |_/ /       \r\n" + 
		            		"   | | __ |  _  || |\\/| ||  __|  | | | || | | |  __||    /        \r\n" + 
		            		"   | |_\\ \\| | | || |  | || |___  \\ \\_/ /\\ \\_/ / |___| |\\ \\        \r\n" + 
		            		"    \\____/\\_| |_/\\_|  |_/\\____/   \\___/  \\___/\\____/\\_| \\_|       \r\n" + 
		            		"                                                                  \r\n" + 
		            		"                                                                  \r\n" + 
		            		"____ _                       _       _    _ ____ _   _  ___ \r\n" + 
		            		"| _ \\ |                     /  |     | |  | |_   _| \\ | |/  ___|\r\n" + 
		            		"| |_/ / | _ _ _   _  __ _ __`| |     | |  | | | | |  \\| |\\ `--. \r\n" + 
		            		"|  __/| |/ _` | | | |/ _ \\ '__|| |     | |/\\| | | | | . ` | `--. \\\r\n" + 
		            		"| |   | | (| | |_| |  __/ |  _| |    \\  /\\  /_| |_| |\\  |/\\__/ /\r\n" + 
		            		"\\_|   |_|\\__,_|\\__, |\\___|_|  \\___/     \\/  \\/ \\___/\\_| \\_/\\____/ \r\n" + 
		            		"                __/ |                                             \r\n" + 
		            		"               |___/                                              \r\n" + 
		            		"  ____ _       ___   _   __  ___   _  ___ _   _ _   \r\n" + 
		            		"  | _ \\ |     / _ \\ \\ / /  / _ \\|  _ \\ / _ \\|   | \\ | |_ \\  \r\n" + 
		            		"  | |_/ / |    / /_\\ \\ V /  / /_\\ \\ |  \\// /_\\ \\ | | |  \\| |  ) | \r\n" + 
		            		"  |  _/| |    |  _  |\\ /   |  _  | | _ |  _  | | | | . ` | / /  \r\n" + 
		            		"  | |   | |____| | | || |   | | | | |_\\ \\| | | |_| |_| |\\  ||_|   \r\n" + 
		            		"  \\_|   \\_____/\\_| |_/\\_/   \\_| |_/\\____/\\_| |_/\\___/\\_| \\_/(_)   \r\n" + 
		            		"                                                                  \r\n" + 
		            		"                                                                  \r\n" + 
		            		"                    __   _  __   _                          \r\n" + 
		            		"                   / /\\ \\ / / / / \\ | \\ \\                         \r\n" + 
		            		"                  | |  \\ V / / /|  \\| || |                        \r\n" + 
		            		"                  | |   \\ / / / | . ` || |                        \r\n" + 
		            		"                  | |   | |/ /  | |\\  || |                        \r\n" + 
		            		"                  | |   \\_/_/   \\_| \\_/| |                        \r\n" + 
		            		"                   \\_\\                /_/      ");
		         } else if (currentState == GamePhase.NOUGHT_WON) {
		            System.out.println("    ___   _  _  _ ___   ___  _   _ _________          \r\n" + 
		            		"   |  _ \\ / _ \\ |  \\/  ||  ___| |  _  || | | |  ___| __ \\         \r\n" + 
		            		"   | |  \\// /_\\ \\| .  . || |__   | | | || | | | |__ | |_/ /         \r\n" + 
		            		"   | | __ |  _  || |\\/| ||  __|  | | | || | | |  __||    /          \r\n" + 
		            		"   | |_\\ \\| | | || |  | || |___  \\ \\_/ /\\ \\_/ / |___| |\\ \\          \r\n" + 
		            		"    \\____/\\_| |_/\\_|  |_/\\____/   \\___/  \\___/\\____/\\_| \\_|         \r\n" + 
		            		"                                                                    \r\n" + 
		            		"                                                                    \r\n" + 
		            		"____ _                       ___      _    _ ___ _   _  ___ \r\n" + 
		            		"| _ \\ |                     / _  \\    | |  | |   _| \\ | |/  ___|\r\n" + 
		            		"| |_/ / | _ _ _   _  __ _ __`' / /'    | |  | | | | |  \\| |\\ `--. \r\n" + 
		            		"|  __/| |/ _` | | | |/ _ \\ '__| / /      | |/\\| | | | | . ` | `--. \\\r\n" + 
		            		"| |   | | (| | |_| |  __/ |  ./ /__    \\  /\\  /_| |_| |\\  |/\\__/ /\r\n" + 
		            		"\\_|   |_|\\__,_|\\__, |\\___|_|  \\_____/     \\/  \\/ \\___/\\_| \\_/\\____/ \r\n" + 
		            		"                __/ |                                               \r\n" + 
		            		"               |___/                                                \r\n" + 
		            		"  ____ _       ___   _   __  ___   _  ___ _   _ _     \r\n" + 
		            		"  | _ \\ |     / _ \\ \\ / /  / _ \\|  _ \\ / _ \\|   | \\ | |_ \\    \r\n" + 
		            		"  | |_/ / |    / /_\\ \\ V /  / /_\\ \\ |  \\// /_\\ \\ | | |  \\| |  ) |   \r\n" + 
		            		"  |  _/| |    |  _  |\\ /   |  _  | | _ |  _  | | | | . ` | / /    \r\n" + 
		            		"  | |   | |____| | | || |   | | | | |_\\ \\| | | |_| |_| |\\  ||_|     \r\n" + 
		            		"  \\_|   \\_____/\\_| |_/\\_/   \\_| |_/\\____/\\_| |_/\\___/\\_| \\_/(_)     \r\n" + 
		            		"                                                                    \r\n" + 
		            		"                                                                    \r\n" + 
		            		"                    __   _  __   _                            \r\n" + 
		            		"                   / /\\ \\ / / / / \\ | \\ \\                           \r\n" + 
		            		"                  | |  \\ V / / /|  \\| || |                          \r\n" + 
		            		"                  | |   \\ / / / | . ` || |                          \r\n" + 
		            		"                  | |   | |/ /  | |\\  || |                          \r\n" + 
		            		"                  | |   \\_/_/   \\_| \\_/| |                          \r\n" + 
		            		"                   \\_\\                /_/  ");
		         } else if (currentState == GamePhase.DRAW) {
		            System.out.println("       ___   _  _  _ ___   ___  _   _ _________         \r\n" + 
		            		"      |  _ \\ / _ \\ |  \\/  ||  ___| |  _  || | | |  ___| __ \\        \r\n" + 
		            		"      | |  \\// /_\\ \\| .  . || |__   | | | || | | | |__ | |_/ /        \r\n" + 
		            		"      | | __ |  _  || |\\/| ||  __|  | | | || | | |  __||    /         \r\n" + 
		            		"      | |_\\ \\| | | || |  | || |___  \\ \\_/ /\\ \\_/ / |___| |\\ \\         \r\n" + 
		            		"       \\____/\\_| |_/\\_|  |_/\\____/   \\___/  \\___/\\____/\\_| \\_|        \r\n" + 
		            		"                                                                      \r\n" + 
		            		"                                                                      \r\n" + 
		            		"        ___ ___ _   _      ______  _  _ ___ ___       \r\n" + 
		            		"       /  __|   / _ \\ | |    |  ___|  \\/  | / _ \\   _|  ___|      \r\n" + 
		            		" _____\\ `--.  | |/ /_\\ \\| |    | |_ | .  . |/ /_\\ \\| | | |__ ____ \r\n" + 
		            		"|______|`--. \\ | ||  _  || |    |  __|| |\\/| ||  _  || | |  __|______|\r\n" + 
		            		"       /\\__/ / | || | | || |____| |___| |  | || | | || | | |___       \r\n" + 
		            		"       \\____/  \\_/\\_| |_/\\_____/\\____/\\_|  |_/\\_| |_/\\_/ \\____/       \r\n" + 
		            		"                                                                      \r\n" + 
		            		"                                                                      \r\n" + 
		            		"      ____ _       ___   _   __  ___   _  ___ _   _ _   \r\n" + 
		            		"      | _ \\ |     / _ \\ \\ / /  / _ \\|  _ \\ / _ \\|   | \\ | |_ \\  \r\n" + 
		            		"      | |_/ / |    / /_\\ \\ V /  / /_\\ \\ |  \\// /_\\ \\ | | |  \\| |  ) | \r\n" + 
		            		"      |  _/| |    |  _  |\\ /   |  _  | | _ |  _  | | | | . ` | / /  \r\n" + 
		            		"      | |   | |____| | | || |   | | | | |_\\ \\| | | |_| |_| |\\  ||_|   \r\n" + 
		            		"      \\_|   \\_____/\\_| |_/\\_/   \\_| |_/\\____/\\_| |_/\\___/\\_| \\_/(_)   \r\n" + 
		            		"                                                                      \r\n" + 
		            		"                                                                      \r\n" + 
		            		"                          __   _  __   _                        \r\n" + 
		            		"                         / /\\ \\ / / / / \\ | \\ \\                       \r\n" + 
		            		"                        | |  \\ V / / /|  \\| || |                      \r\n" + 
		            		"                        | |   \\ / / / | . ` || |                      \r\n" + 
		            		"                        | |   | |/ /  | |\\  || |                      \r\n" + 
		            		"                        | |   \\_/_/   \\_| \\_/| |                      \r\n" + 
		            		"                         \\_\\                /_/ ");
		         }
	         // Switch player
	         currentPlayer = (currentPlayer == Piece.CROSS) ? Piece.NOUGHT : Piece.CROSS;
	      } while (currentState == GamePhase.PLAYING);  // repeat until game-over
	   }
	   /** The entry main() method */
	   public static void main(String[] args) {
	      new TicTacToe();  // Let the constructor do the job
	   }
	   
	   /** Initialize the game-board contents and the current states */
	   public void initGame() {
	      init();  // clear the board contents
	      currentPlayer = Piece.CROSS;       // CROSS plays first
	      currentState = GamePhase.PLAYING; // ready to play
	   }
	 
	   /** The player with "thePiece" makes one move, with input validation.
	       Update Cell's content, Board's currentRow and currentCol. */
	   public void playerMove(Piece thePiece) {
	      boolean validInput = false;  // for validating input
	      do {
	         if (thePiece == Piece.CROSS) {
	            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
	         } else {
	            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
	         }
	         int row = in.nextInt() - 1;
	         int col = in.nextInt() - 1;
	         if (row >= 0 && row < ROWS && col >= 0 && col < COLS
	               && cells[row][col].content == Piece.EMPTY) {
	            cells[row][col].content = thePiece;
	            currentRow = row;
	            currentCol = col;
	            validInput = true; // input okay, exit loop
	         } else {
	            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
	                  + ") is not valid. Try again...");
	         }
	      } while (!validInput);   // repeat until input is valid
	   }
	 
	   /** Update the currentState after the player with "thePiece" has moved */
	   public void updateGame(Piece thePiece) {
	      if (hasWon(thePiece)) {  // check for win
	         currentState = (thePiece == Piece.CROSS) ? GamePhase.CROSS_WON : GamePhase.NOUGHT_WON;
	      } else if (isDraw()) {  // check for draw
	         currentState = GamePhase.DRAW;
	      }
	      // Otherwise, no change to current state (still GamePhase.PLAYING).
	   }
	 
	   
	    
		 
		 //ABSTRACT METHODS
		 
		   /** Constructor to initialize the game board */
		   public void BoardTemplate() {
		      cells = new Position[ROWS][COLS];  // allocate the array
		      for (int row = 0; row < ROWS; ++row) {
		         for (int col = 0; col < COLS; ++col) {
		            cells[row][col] = new Position(row, col); // allocate element of the array
		         }
		      }
		   }
		 
		   /** Initialize (or re-initialize) the contents of the game board */
		   public void init() {
		      for (int row = 0; row < ROWS; ++row) {
		         for (int col = 0; col < COLS; ++col) {
		            cells[row][col].clear();  // clear the position content
		         }
		      }
		   }
		 
		   /** Return true if it is a draw (i.e., no more EMPTY cell) */
		   public boolean isDraw() {
		      for (int row = 0; row < ROWS; ++row) {
		         for (int col = 0; col < COLS; ++col) {
		            if (cells[row][col].content == Piece.EMPTY) {
		               return false; // an empty Piece found, not a draw, exit
		            }
		         }
		      }
		      return true; // no empty position, it's a draw
		   }
		 
		   /** Return true if the player with "thePiece" has won after placing at
		       (currentRow, currentCol) */
		   public boolean hasWon(Piece thePiece) {
		      return (cells[currentRow][0].content == thePiece         // 3-in-the-row
		                   && cells[currentRow][1].content == thePiece
		                   && cells[currentRow][2].content == thePiece
		              || cells[0][currentCol].content == thePiece      // 3-in-the-column
		                   && cells[1][currentCol].content == thePiece
		                   && cells[2][currentCol].content == thePiece
		              || currentRow == currentCol            // 3-in-the-diagonal
		                   && cells[0][0].content == thePiece
		                   && cells[1][1].content == thePiece
		                   && cells[2][2].content == thePiece
		              || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
		                   && cells[0][2].content == thePiece
		                   && cells[1][1].content == thePiece
		                   && cells[2][0].content == thePiece);
		   }
		 
		  /** Paint itself */
		   public void paint() {
		      for (int row = 0; row < ROWS; ++row) {
		         for (int col = 0; col < COLS; ++col) {
		            cells[row][col].paint();   // each position paints itself
		            if (col < COLS - 1) System.out.print("|");
		         }
		         System.out.println();
		         if (row < ROWS - 1) {
		            System.out.println("-----------");
		         }
		      }
		   }

		
	   
	   
	   
	   
	}
