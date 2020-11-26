package sudoku;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.Problem;
import dmi.vi1.search.framework.TreeSearch;
import dmi.vi1.search.informed.AStarSearch;

public class MainProgram {

	public static void main(String[] args) throws Exception {
		int[][] initBoard = new SudokuTable().getBoard();

		SudokuTable state = new SudokuTable(initBoard);

		SudokuActionsFunction actionsFunction = new SudokuActionsFunction();
		SudokuResultFunction resultFunction = new SudokuResultFunction();
		SudokuGoalTest goalTest = new SudokuGoalTest();
		SudokuHeuristicFunctions heuristicFunctions = new SudokuHeuristicFunctions();
		SudokuStepCostFunctions stepCostFunctions = new SudokuStepCostFunctions();

		Problem p = new Problem(state, actionsFunction, resultFunction, goalTest, stepCostFunctions);
		AStarSearch as = new AStarSearch(new TreeSearch(), heuristicFunctions);

		java.util.List<Action> l = as.search(p);
		for (Action a : l) {
			state.print();
			state = (SudokuTable) resultFunction.result(state, a);
			System.out.println(a);
		}
		state.print();

	}

}
