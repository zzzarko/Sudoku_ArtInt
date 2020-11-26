package sudoku;

import static sudoku.SudokuTable.*;

import dmi.vi1.search.framework.GoalTest;


public class SudokuGoalTest implements GoalTest {



	@Override
	public boolean isGoalState(Object state) {
		SudokuTable table = (SudokuTable) state;

		for (int i = 0; i < X_DIM; i++) {
			for (int j = 0; j < Y_DIM; j++) {
				if (table.getPos(i, j) < 1)
					return false;
			}
		}
		return true;

	}

}
