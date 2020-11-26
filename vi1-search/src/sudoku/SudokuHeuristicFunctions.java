package sudoku;

import static sudoku.SudokuTable.*;

import dmi.vi1.search.framework.HeuristicFunction;

public class SudokuHeuristicFunctions implements HeuristicFunction {

	@Override
	public double h(Object state) {
		int counter = 0;
		SudokuTable table = (SudokuTable) state;

		for (int i = 0; i < X_DIM; i++) {
			for (int j = 0; j < Y_DIM; j++) {
				if (table.getPos(i, j) < 1)
					counter++;
			}
		}
		return counter;
	}

}
