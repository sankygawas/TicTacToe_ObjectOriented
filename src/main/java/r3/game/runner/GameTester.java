/**
 * 
 */
package r3.game.runner;

import java.util.Scanner;

import r3.game.grid.Grid;
import r3.game.enums.CellType;
import r3.game.enums.GameState;
import r3.game.verifier.Referee;

/**
 * @author Sanket
 *
 */
public class GameTester {

	public static Scanner in = new Scanner(System.in); // the input Scanner
	
	
	/**
	 * @param args arguments 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int gridSize = 3;
		GameTester test = new GameTester();
		Grid board = new Grid(gridSize);
		GameState gameState = GameState.PLAYING;
		CellType currentCell = CellType.NOUGHT_CELL;
		board.displayBoard();
        do {
             /** Play the game once. Players CROSS and NOUGHT move alternately. */
             currentCell = (currentCell == CellType.NOUGHT_CELL) ? CellType.CROSS_CELL : CellType.NOUGHT_CELL;
             
             System.out.print("Player" + currentCell + ", enter your move (row[1-"+gridSize+"] column[1-"+gridSize+"]): ");
             
             try {
            	 int row = test.receiveInt() - 1;  // array index starts at 0 instead of 1
    	         int column = test.receiveInt() - 1;
    	         board.makeMove(row, column, currentCell);

             }catch(IllegalArgumentException e) {
            	 System.out.println(e);
            	 currentCell = (currentCell == CellType.NOUGHT_CELL) ? CellType.CROSS_CELL : CellType.NOUGHT_CELL;
            	 continue;
             }
 	         board.displayBoard();
	         gameState = new Referee(board).getOutCome();
	         
	      } while (GameState.PLAYING == gameState);  // repeat until game-over
	      
	      if(gameState != GameState.TIE)
	    	  System.out.println("Player:"+gameState + " wins this Game");
	      else
	    	  System.out.println("The game is a Tie");

	}
	
		private int receiveInt() {
			while(!in.hasNextInt()) {
				System.out.println("received String expecting int");
				in.next();
			}
			return in.nextInt();
	}

}
