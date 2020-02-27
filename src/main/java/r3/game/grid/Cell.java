/**
 * 
 */
package r3.game.grid;

import r3.game.enums.CellType;

/**
 * This class represents the single cell of a Grid. The class holds an instance of CellType which can be a Cross(X) or Nought(O) or Empty
 */
public class Cell {

	/** Instance of CellType*/
	CellType cellType;
	
	/**
	 * Default Constructor
	 */
	public Cell() {
		cellType  = CellType.EMPTY_CELL;
	}
	
	/**
	 * Setter for the cell
	 * @param cellTypeParam param to be set as the cellType
	 */
	public void setCell(CellType cellTypeParam) throws NullPointerException{
		if(cellTypeParam == null) throw new NullPointerException("Cell value cannot be Null");
		cellType = cellTypeParam;
	}
	
	
	/**
	 * Getter for the cell
	 * @return CellType
	 */
	public CellType getCellType() {
		return cellType;
	}
	
	/**
	 * Sets the cell as Empty
	 */
	public void setCellAsEmpty() {
		cellType = CellType.EMPTY_CELL;
	}
	
	/**
	 * Checks whether the cell is empty
	 * @return true if cell is empty, false otherwise
	 */
	public boolean isCellEmpty() {
		return cellType == CellType.EMPTY_CELL;

	}
	
	
}
