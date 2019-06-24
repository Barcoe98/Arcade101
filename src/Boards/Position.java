                              /* Position class - individual Positions on a grid */
package Boards;

public class Position {          // save as Position.java
	                             
	          Piece content;      // content of this cell of type Piece.
	                             // take a value of Piece.EMPTY, Seed.CROSS, or Seed.NOUGHT
	          int row, col;      // row and column of this position, not used in this program
	 
	                          /* Constructor to initialize this position */
public Position(int row, int col) {
	        this.row = row;
	        this.col = col;
	               clear();      // clear content
	   }
	 
	                           /* Clear the position content to EMPTY */
public void clear() {
	  content = Piece.EMPTY;
	   }
	 
	                           /** Paint itself */
public void paint() {
	      switch (content) {
	         case CROSS:  System.out.print(" X "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case EMPTY:  System.out.print("   "); break;
	         case RED:  System.out.print(" R "); break;
	         case YELLOW:  System.out.print(" Y "); break;
	      }
	   }
 
}

