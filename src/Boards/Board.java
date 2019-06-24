package Boards;


public abstract class Board {  // save as Board.java
   
Position[][] cells;  // a board composes of ROWS-by-COLS position instances
int currentRow, currentCol;  // the current Piece's row and column

/** Constructor to initialize the game board */


abstract void BoardTemplate();

/** Initialize (or re-initialize) the contents of the game board */
public abstract void init();

/** Return true if it is a draw (i.e., no more EMPTY cell) */
public abstract boolean isDraw();

/** Return true if the player with "thePiece" has won after placing at
(currentRow, currentCol) */
public abstract boolean hasWon(Piece thePiece);
/** Paint itself */
public abstract void paint();
}