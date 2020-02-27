/**
 * 
 */
package r3.game.verifier;

import r3.game.enums.CellType;
import r3.game.enums.GameState;
import r3.game.grid.Grid;

/**
 *  This class represents the Verifier of the Cross and Noughts Game. The class is implemented to verify the state of a Grid of any size. 
 *  The Referee tells whether the game is won, tied or still under play
 *  
 */
public class Referee {

	/** instance of currentGrid*/
	private Grid currentGrid;
	
	/**
	 * Parameterized constructor taking a representation of a Grid
	 * 
	 * @param grid Grid board representation of a grid NxN
	 */
	public Referee(Grid grid) {
		if(grid == null) throw new NullPointerException("Grid cannot be null");
		currentGrid = grid;
	}

	/**
	 * Checks if there's any winner at the current stage of the Grid. 
	 * 
	 * @return GameState - X if X has won, GameState - O if O has won, GameState - Tie if none wins, 
	 */
	public GameState getOutCome() {
		
		if (hasWinner(CellType.CROSS_CELL)) 
		    return GameState.CROSS_WINS;
		
		if (hasWinner(CellType.NOUGHT_CELL)) 
		    return GameState.NOUGHT_WINS;
		
		if (isEmptyCellAvailable())
		    return GameState.PLAYING;

		return GameState.TIE;
		
	}
	
	
	/**
	 * Checks whether the grid(NxN) has any empty cells left
	 * 
	 * @return true if an empty cell cell available, else false
	 */
	private boolean isEmptyCellAvailable() {
		
		 for(int i = 0; i < currentGrid.getGridSize(); i++) 
		      for(int j = 0; j < currentGrid.getGridSize(); j++) 
		    	  if (currentGrid.isCellTypeEmptyForLocation(i,j)) 
		    		  return true;
		 
		 return false;
	}

	/**
	 * Checks if the grid has any succession of cellType in any row or column or both diagonals
	 * 
	 * @param cellType Cross(X) or Nought(O)
	 * @return true if the grid has a winner, false, if there is no winner yet
	 */
	private boolean hasWinner(CellType cellType) {
		
		 for(int i = 0; i < currentGrid.getGridSize(); i++) {
		      if (isInARow(i,cellType)) 
		    	  return true;

		      if (isInAColumn(i,cellType)) 
		    	  return true;
		 }

	    if(isInAPrimaryDiagonal(cellType)) return true;

	    if(isInACrossDiagonal(cellType)) return true;

	    return false;
	}
	
	
	/**
	 * Checks whether the Grid has any X or O in succession for the given row
	 * 
	 * @param row rowNumber to be checked for successive cellType
	 * @param cellType Cross(X) or Nought(O) to be checked in the row
	 * @return true if the X or O are found in succession in the row, false otherwise 
	 */
	private boolean isInARow(int row,CellType cellType) {
		
		for(int i=0;i<currentGrid.getGridSize();i++) 
			if(currentGrid.getCellTypeForLocation(row,i) != cellType)
				return false;
		
		return true;
	}
	
	/**
	 * Checks whether the Grid has any X or O in succession for the given column
	 * 
	 * @param column columnNumber to be checked for successive cellType
	 * @param cellType Cross(X) or Nought(O) to be checked in the column
	 * @return true if the X or O are found in succession in the column, false otherwise 
	 */
	private boolean isInAColumn(int column,CellType cellType) {
		
		for(int i=0;i<currentGrid.getGridSize();i++) 
			if(currentGrid.getCellTypeForLocation(i,column) != cellType)
				return false;
		
		return true;
	}
	
	/**
	 * Checks whether the Grid has any X or O in succession in a Diagonal from Left to Right
	 * 
	 * @param cellType Cross(X) or Nought(O) to be checked in the diagonal
	 * @return true if the X or O are found in succession in the diagonal, false otherwise 
	 */
	private boolean isInAPrimaryDiagonal(CellType cellType) {
		
		for(int i=0;i<currentGrid.getGridSize();i++) 
			if(currentGrid.getCellTypeForLocation(i,i) != cellType)
				return false;
		
		return true;
	}
	
	/**
	 * Checks whether the Grid has any X or O in succession in a Diagonal from Right to Left
	 * 
	 * @param cellType Cross(X) or Nought(O) to be checked in the diagonal
	 * @return true if the X or O are found in succession in the diagonal, false otherwise 
	 */
	private boolean isInACrossDiagonal(CellType cellType) {
		
		for(int i=0,j=currentGrid.getGridSize()-1;i<currentGrid.getGridSize() && j>=0;i++,j--) 
			if(currentGrid.getCellTypeForLocation(i,j) != cellType)
				return false;
		
		return true;
	}
	
}



