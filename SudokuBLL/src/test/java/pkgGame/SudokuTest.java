package pkgGame;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

import org.junit.Test;

import pkgGame.Sudoku.Cell;

public class SudokuTest {
	Cell c;

	private void PrintStars() {
		for (int i = 0; i < 50; i++)
			System.out.print("*");
		System.out.println();
	}

	@Test
	public void Sudoku_Test1() {

		try {
			Sudoku s1 = new Sudoku(9);
		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}

	@Test(expected = Exception.class)
	public void Sudoku_Test2() throws Exception {

		Sudoku s1 = new Sudoku(10);

	}

	@Test
	public void getRegion_Test1() {

		int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		int[] ExpectedRegion = { 3, 4, 1, 2 };

		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region 0 = 1 2 3 4
		// region 1 = 3 4 1 2

		int[] region;
		try {
			Sudoku s1 = new Sudoku(puzzle);

			region = s1.getRegion(1);
			System.out.println(Arrays.toString(region));
			assertTrue(Arrays.equals(ExpectedRegion, region));

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}

	@Test
	public void getRegion_Test2() {

		int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		int[] ExpectedRegion = { 2, 1, 4, 3 };

		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region at 0,2 = 2 1 4 3

		int[] region;
		try {
			Sudoku s1 = new Sudoku(puzzle);

			region = s1.getRegion(0, 2);
			System.out.println(Arrays.toString(region));
			assertTrue(Arrays.equals(ExpectedRegion, region));

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}

	@Test
	public void Sudoku_test1() {
		int[][] puzzle = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertTrue(s1.isSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}

	@Test
	public void Sudoku_test2() {
		int[][] puzzle = { { 5, 5, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertFalse(s1.isSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}

	@Test
	//TODO remove
	public void GetNextCell_test(){
		try {
			int[][] puzzle = new int[4][4];
			Sudoku s1 = new Sudoku(puzzle);
			Sudoku.Cell c = s1.getCell(0, 0);
			while (c != null){
				System.out.println(c.getiCol()+","+c.getiRow());
				c=c.GetNextCell(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail("Test failed to build a Sudoku");
		}
	}

	@Test
	public void getRegionNbr_test(){
		try {
			int[][] puzzle = new int[][]{
					{0,0,1,1},
					{0,0,1,1},
					{2,2,3,3},
					{2,2,3,3}
			};
			Sudoku s1 = new Sudoku(puzzle);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					assertTrue(s1.getRegionNbr(i,j)==puzzle[i][j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test failed to build a Sudoku");
		}
	}

	@Test
	public void getRegion_test(){
		try {
			int[][] puzzle = new int[][]{
					{0,0,1,1},
					{0,0,1,1},
					{2,2,3,3},
					{2,2,3,3}
			};
			Sudoku s1 = new Sudoku(puzzle);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
//					System.out.println(Arrays.toString(s1.getRegion(i))+","+i);
					assertEquals(s1.getRegion(i)[j],i);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail("Test failed to build a Sudoku");
		}
	}

	@Test
	//TODO remove
	public void GetAllValidCellValues_test(){
		try {
			int[][] puzzle = new int[][]{
				{4,2,0,0},
				{3,1,0,0},
				{1,4,0,0},
				{2,3,0,0}
			};
			Sudoku s1 = new Sudoku(puzzle);
			Set<Integer> set=s1.getAllValidCellValues(0,2);
			assertTrue(set.contains(1));
			assertTrue(set.contains(3));
			assertTrue(set.size()==2);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test failed to build a Sudoku");
		}
	}



	@Test
	public void fillRemining_test(){
		try{
			int[][] puzzle =new int[9][9];
			Sudoku s1 = new Sudoku(puzzle);
			for (int i = 0; i < 20; i++) {
				s1.fillRemaining(s1.getCell(0,0));
				assertTrue(s1.isSudoku());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test failed to build a Sudoku");
		}
	}
	
	@Test
	public void equals_test1() {
		int[][] puzzle = {{1,2,3,4 },{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		int[] ExpectedRegion = {1,2,3,4};
		int[] region;
		try {
			Sudoku s1 = new Sudoku(puzzle);
			region = s1.getRegion(1);
			System.out.println(Arrays.toString(region));
			assertFalse(Arrays.equals(ExpectedRegion, region));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test failed to build a Sudoku");
		}
	}





}
