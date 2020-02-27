

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import r3.game.enums.CellType;
import r3.game.grid.Cell;

public class CellTest {

	
	@Test
	public final void testCellConstructor() {
		{
			Cell cell = new Cell(); 
			assertFalse(cell.getCellType() == null);
		}
		
		{
			Cell cell = new Cell();
			assertFalse(cell.getCellType() != CellType.EMPTY_CELL);
		}
		
		
	}

	@Test
	public final void testSetCell() {
		{
			Cell cell = new Cell();
			cell.setCell(CellType.CROSS_CELL);
			assertTrue(cell.getCellType() == CellType.CROSS_CELL);
		}
		
		{
			Cell cell = new Cell();
			cell.setCell(CellType.NOUGHT_CELL);
			assertTrue(cell.getCellType() == CellType.NOUGHT_CELL); 
		}
		
		{
			Cell cell = new Cell();
			cell.setCell(CellType.EMPTY_CELL);
			assertTrue(cell.getCellType() == CellType.EMPTY_CELL);
		}
		
	}

	@Test
	public final void testSetCellNullCheck() {
		
		try {
			Cell cell = new Cell();
			cell.setCell(null);
			fail("Should have thrown an exception");
		}
		catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public final void testGetCellType() {
		
		/** Positive Test Cases */
		{
			Cell cell = new Cell();
			cell.setCell(CellType.CROSS_CELL);
			assertTrue(cell.getCellType() == CellType.CROSS_CELL);
		}
		{
			Cell cell = new Cell();
			cell.setCell(CellType.EMPTY_CELL);
			assertTrue(cell.getCellType() == CellType.EMPTY_CELL);
		}
		{
			Cell cell = new Cell();
			cell.setCell(CellType.NOUGHT_CELL);
			assertTrue(cell.getCellType() == CellType.NOUGHT_CELL);
		}
		
		/** Negative Test Cases */
		{
			Cell cell = new Cell();
			cell.setCellAsEmpty();
			assertTrue(cell.getCellType() != CellType.NOUGHT_CELL);
		}
		
		{
			Cell cell = new Cell();
			cell.setCellAsEmpty();
			assertTrue(cell.getCellType() != CellType.CROSS_CELL);
		}
	}
	

	@Test
	public final void testSetCellAsEmpty() {
		/** Positive Test Cases */
		{
			Cell cell = new Cell();
			cell.setCellAsEmpty();
			assertTrue(cell.getCellType() == CellType.EMPTY_CELL);
		}
		
		/** Negative Test Cases */
		{
			Cell cell = new Cell();
			cell.setCellAsEmpty();
			assertTrue(cell.getCellType() != CellType.NOUGHT_CELL);
		}
		
		{
			Cell cell = new Cell();
			cell.setCellAsEmpty();
			assertTrue(cell.getCellType() != CellType.CROSS_CELL);
		}
	}

	@Test
	public final void testIsCellEmpty() {

		/** Positive Test Cases */
		{
			Cell cell = new Cell();
			assertTrue(cell.isCellEmpty() == true);
		}
		
		/** Negative Test Cases */
		{
			Cell cell = new Cell();
			assertTrue(cell.isCellEmpty() != false);
		}
		
		{
			Cell cell = new Cell();
			cell.setCell(CellType.CROSS_CELL);
			assertTrue(cell.isCellEmpty() == false);
		}
		
		{
			Cell cell = new Cell();
			cell.setCell(CellType.NOUGHT_CELL);
			assertTrue(cell.isCellEmpty() == false);
		}
	}

}
