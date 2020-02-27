/**
 * 
 */
package r3.game.grid;

import r3.game.enums.CellType;

/**
 * This class represents a 2D array of type Cell of any size N. It acts as a GameBoard and encapsulates the 2D array 
 * 
 */
public class Grid {
	
	/** Default size of the Grid */
	 private static final int DEFAULT_GRID_SIZE = 3;
	 
	 /** instance of 2d Array of type Cell */
	 private Cell[][] cells;
	 
	 /** size of the Grid */
	 private int gridSize;
	 
	 /**
	  * Parameterized constructor taking the size of the grid
	  * 
	  * @param size of the grid
	  */
	 public Grid(int size){
		 gridSize = size;
		 cells = new Cell[gridSize][gridSize];
		 for(int i=0;i<gridSize;i++)
			 for(int j=0;j<gridSize;j++)
				 cells[i][j] = new Cell();	
	}
	 
	 
	 /**
	  * Default Constructor
	  */
	 public Grid() {
		 this(DEFAULT_GRID_SIZE);	
	 }
	 
	 /**
	  * Resets The Grid to Empty Cell
	  */
	 public void reset() {

		 for(int i=0;i<gridSize;i++)
			 for(int j=0;j<gridSize;j++)
				 cells[i][j].setCellAsEmpty();
	}
	 
	 /**
	  * Gets the CellType- Cross(X) or Nought(O) for the cell at the given location
	  * 
	  * @param row rowNumber of the Grid
	  * @param column column Number of the Grid
	  * @return CellType for the cell in the location
	  */
	 public CellType getCellTypeForLocation(int row, int column) {
		 
		 return cells[row][column].getCellType();

	}
	 
	 /**
	  * Sets the value of a cell at the given location with a Cross(X) or a Nought(O)
	  * 
	  * @param row rowNumber of the Grid
	  * @param column columnNumber of the Grid
	  * @param cellType cellType (X or O) to be set in the cell
	  * @throws IllegalArgumentException throws exception if the placement of X or O isn't valid
	  */
	 public void makeMove(int row, int column, CellType cellType) throws IllegalArgumentException{
		 
		 if(row >= gridSize || row < 0 ||  column >= gridSize || column < 0) 
			 throw new IllegalArgumentException("Placing cannot be done outside the grid");
		 
		 if(cells[row][column].isCellEmpty())
			 cells[row][column].setCell(cellType);
		 else
			 throw new IllegalArgumentException("Invalid move. Not an empty cell");
		 
	}
	 
	 /**
	  * Display the board on the console
	  */
	 public void displayBoard(){
		 
		 for(int i=0;i<gridSize;i++) {
			 for(int j=0;j<gridSize;j++) {
				 System.out.print(getCellTypeForLocation(i,j));
				 if(j != gridSize-1)
					 System.out.print("|");
			 }
			 System.out.println();
			 
			 if(i != gridSize-1) {
				 for(int j=0;j<gridSize;j++) {
					 System.out.print("----");
				 }
				
			 }
			 System.out.println();
		 }
		 
	 }
	 
	 /**
	  * Gets the GridSize
	  * @return gridSize of the Grid
	  */
	 public int getGridSize() {
		return gridSize;
	}

	 
	 /**
	  * Checks whether the cell is Empty for the given location
	  * 
	  * @param row rowNumber of the grid
	  * @param column columnNumber of the Grid
	  * @return true if the cell is Empty, false if not empty
	  */
	public boolean isCellTypeEmptyForLocation(int row, int column) {
		 return cells[row][column].isCellEmpty();
	}


}
