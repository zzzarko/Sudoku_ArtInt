package sudoku;


import java.util.Arrays;


import dmi.vi1.search.datastructure.XYLocation;

public class SudokuTable {

	public static final int X_DIM = 6;
	public static final int Y_DIM = 6;
	public static final int EMPTY = 0;

	// Tabla se zapravo sastoji od 4 table svaka dimenzije 3x3
	/*
	 * 5, 3, - | -, 7, -
	 * 6, -, - | 1, 9, 5
	 * -, 9, 8 | -, -, -
	 * _________________
	 * 8, -, - | 0, 6, -
	 * 4, -, - | 8, -, 3
	 * 7, -, - | -, 2, -
	 */

	private int[][] board = {
			{ 5, 3, EMPTY, EMPTY, 7, EMPTY },
			{ 6, EMPTY, EMPTY, 1, 9, 5 },
			{ EMPTY, 9, 8, EMPTY, EMPTY, EMPTY },
			{ 8, EMPTY, EMPTY, EMPTY, 6, EMPTY },
			{ 4, EMPTY, EMPTY, 8, EMPTY, 3 },
			{ 7, EMPTY, EMPTY, EMPTY, 2, EMPTY }
		};

	public SudokuTable(int[][] board) {
		super();
		this.board = board;
	}
	public SudokuTable() {}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public void setPos(int x, int y, int num) {
		this.board[x][y] = num;
	}

	public int getPos(int x, int y) {
		return this.board[x][y];
	}

	public void print() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	public XYLocation getEmpty() {
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				if (board[i][j] == EMPTY)
					return new XYLocation(i, j);
		return null;
	}

	public SudokuTable clone() {
		SudokuTable newBoard = new SudokuTable();
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				newBoard.setPos(i, j, this.getPos(i, j));

		return newBoard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(board);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SudokuTable other = (SudokuTable) obj;
		if (!Arrays.deepEquals(board, other.board))
			return false;
		return true;
	}

	

}
