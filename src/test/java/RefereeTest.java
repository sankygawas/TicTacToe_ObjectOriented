

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import r3.game.enums.CellType;
import r3.game.enums.GameState;
import r3.game.grid.Grid;
import r3.game.verifier.Referee;

/**
 *  Testing the public methods. These public methods call the private methods inside. 
 *  If the public methods are working, it is assumed that the private methods in the class are working correctly
 *
 */

public class RefereeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testReferee() {
		
		/** Positive Test Cases */
		try
		{
			Grid grid = new Grid();
			Referee referee = new Referee(grid);
			assertTrue(true);
			grid.makeMove(0, 0, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
		}catch(Exception e) {
			fail("Should not throw an Exception");
		}
		
		try
		{
			new Referee(null);
			fail("Should throw Null Pointer Exception");
		}catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public final void testGetOutComeForColumnForNought() {
		
		/** Check All Columns for Nought(O)*/
		{
			Grid grid = new Grid();
			Referee referee = new Referee(grid);
			grid.makeMove(0, 0, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 0, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 0, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.NOUGHT_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(0, 1, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 1, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 1, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.NOUGHT_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(0, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.NOUGHT_WINS);
		}
	}
	
	@Test
	public final void testGetOutComeForColumnForCross() {
		
		/** Check All Columns for Cross(X)*/
		{
			Grid grid = new Grid();
			Referee referee = new Referee(grid);
			grid.makeMove(0, 0, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 0, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 0, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.CROSS_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(0, 1, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 1, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 1, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.CROSS_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(0, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.CROSS_WINS);
		}
	}

	@Test
	public final void testGetOutComeForRowForNought() {
		/** Check All Rows for Nought(O)*/
		{
			Grid grid = new Grid();
			Referee referee = new Referee(grid);
			grid.makeMove(0, 0, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(0, 1, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(0, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.NOUGHT_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(1, 0, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 1, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.NOUGHT_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(2, 0, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 1, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.NOUGHT_WINS);
		}
	}
	
	@Test
	public final void testGetOutComeForRowForCross() {
		
		/** Check All Rows for Cross(X)*/
		{
			Grid grid = new Grid();
			Referee referee = new Referee(grid);
			grid.makeMove(0, 0, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(0, 1, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(0, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.CROSS_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(1, 0, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 1, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.CROSS_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(2, 0, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 1, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.CROSS_WINS);
		}
		
		
	}

	@Test
	public final void testGetOutComeForDiagonalForNought() {
		/** Check Diagonal For NOUGHT(O) */
		{
			Grid grid = new Grid();
			Referee referee = new Referee(grid);
			grid.makeMove(0, 0, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 1, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.NOUGHT_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(0, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.NOUGHT_WINS);
		}
	}
	
	@Test
	public final void testGetOutComeForDiagonalForCross() {
		
		/** Positive Test Cases */
		
		/** Check Diagonal For Cross */
		{
			Grid grid = new Grid();
			Referee referee = new Referee(grid);
			grid.makeMove(0, 0, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 1, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.CROSS_WINS);
			
			grid = new Grid();
			referee = new Referee(grid);
			grid.makeMove(0, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(1, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.PLAYING);
			grid.makeMove(2, 2, CellType.CROSS_CELL);
			assertTrue(referee.getOutCome() == GameState.CROSS_WINS);
		}
		
		
		
		
	}
	
	@Test
	public final void testGetOutComeForDiagonalForTie() {
		
		/** Check For Tie */
		{
			Grid grid = new Grid();
			Referee referee = new Referee(grid);
			grid.makeMove(0, 0, CellType.CROSS_CELL);
			grid.makeMove(0, 1, CellType.NOUGHT_CELL);
			grid.makeMove(0, 2, CellType.CROSS_CELL);
			
			grid.makeMove(1, 0, CellType.NOUGHT_CELL);
			grid.makeMove(1, 1, CellType.NOUGHT_CELL);
			grid.makeMove(1, 2, CellType.CROSS_CELL);
			
			grid.makeMove(2, 0, CellType.CROSS_CELL);
			grid.makeMove(2, 1, CellType.CROSS_CELL);
			grid.makeMove(2, 2, CellType.NOUGHT_CELL);
			assertTrue(referee.getOutCome() == GameState.TIE);
			
		}
		
	}

}
