

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import r3.game.enums.CellType;
import r3.game.grid.Grid;

public class GridTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public final void testGridParamConstructor() {
		{
			Grid grid = new Grid(4);
			assertTrue(grid.getGridSize() == 4);
		}
	}

	@Test
	public final void testGridConstructor() {
		{
			Grid grid = new Grid();
			assertTrue(grid.getGridSize() == 3);
		}
	}

	@Test
	public final void testReset() {
		{
			Grid grid = new Grid();
			grid.reset();
			boolean flag = false;
			for(int i=0;i<grid.getGridSize();i++) {
				for(int j=0;j<grid.getGridSize();j++) {
					if(grid.getCellTypeForLocation(i, j) != CellType.EMPTY_CELL)
					{
						flag = true;
						break;
					}
				}
			}
			assertTrue(!flag);
		}
	}

	@Test
	public final void testGetCellTypeForLocation() {
		/** Positive Cases */
		{
			Grid grid = new Grid();
			grid.makeMove(0, 0, CellType.CROSS_CELL);
			assertTrue(grid.getCellTypeForLocation(0, 0) == CellType.CROSS_CELL);
		}
		
		/** Negative Cases */
		{
			Grid grid = new Grid();
			grid.makeMove(0, 0, CellType.CROSS_CELL);
			assertTrue(grid.getCellTypeForLocation(0, 0) != CellType.EMPTY_CELL);
		}
	}

	@Test
	public final void testMakeMoveForNull() {
		
		/** Positive Cases */
		try {
			Grid grid = new Grid();
			grid.makeMove(1, 1, null);
			fail("Should throw a null Pointer Exception");
		}catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public final void testMakeMove() {
		

		/** Positive Cases */
		{
			Grid grid = new Grid();
			grid.makeMove(1, 1, CellType.CROSS_CELL);
			assertTrue(grid.getCellTypeForLocation(1, 1) == CellType.CROSS_CELL);
		}
		{
			Grid grid = new Grid();
			grid.makeMove(0, 1, CellType.EMPTY_CELL);
			assertTrue(grid.getCellTypeForLocation(1, 1) == CellType.EMPTY_CELL);
		}
		
		/** Negative Cases */
		{
			Grid grid = new Grid();
			grid.makeMove(0, 0, CellType.CROSS_CELL);
			assertTrue(grid.getCellTypeForLocation(0, 0) != CellType.EMPTY_CELL);
			
		}
	}
	
	@Test
	public final void testMakeMoveForIllegalMove() {
		
		/** Positive Cases */
		
		/** Place on a non-empty Cell*/
		try {
			Grid grid = new Grid();
			grid.makeMove(1, 1, CellType.CROSS_CELL);
			grid.makeMove(1, 1, CellType.CROSS_CELL);
			fail("Should throw a IllegalArgument Exception");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		
		/** Place on a non-empty Cell*/
		try {
			Grid grid = new Grid();
			grid.makeMove(1, 1, CellType.CROSS_CELL);
			grid.makeMove(1, 1, CellType.NOUGHT_CELL);
			fail("Should throw a IllegalArgument Exception");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		
		/** Place outside the grid*/
		try {
			Grid grid = new Grid();
			grid.makeMove(-1, 1, CellType.CROSS_CELL);
			fail("Should throw IllegalArgument Exception");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		
		/** Place outside the grid*/
		try {
			Grid grid = new Grid();
			grid.makeMove(1, 4, CellType.CROSS_CELL);
			fail("Should throw IllegalArgument Exception");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public final void testGetGridSize() {
		{
			Grid grid = new Grid();
			assertTrue(grid.getGridSize() == 3); 
		}
		
		{
			Grid grid = new Grid(5);
			assertTrue(grid.getGridSize() == 5);
		}
	}

	@Test
	public final void testGetIsCellTypeEmptyForLocation() {
		{
			Grid grid = new Grid();
			assertTrue(grid.isCellTypeEmptyForLocation(0, 0));
		}
	}

}
