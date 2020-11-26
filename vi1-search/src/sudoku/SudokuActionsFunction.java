package sudoku;

import static sudoku.SudokuTable.*;

import java.util.ArrayList;
import java.util.List;

import dmi.vi1.search.datastructure.XYLocation;
import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ActionsFunction;

public class SudokuActionsFunction implements ActionsFunction {

	@Override
	public List<Action> actions(Object s) {
		SudokuTable table = (SudokuTable) s;

		List<Action> actions = new ArrayList<>();
		for (int num = 1; num <= 9; num++) {
			for (int i = 0; i < X_DIM; i++) {
				checkAndPut(table, i, num, actions);
			}
		}

		return actions;
	}
	//Proverava i ako moze stavlja
	private void checkAndPut(SudokuTable tab, int row, int num, List<Action> list) {
		boolean thereIsInRow = false; //PP da nema tog broja u i-tom redu

		for (int j = 0; j < Y_DIM; j++) {
			if (tab.getPos(row, j) == num)
				thereIsInRow = true;
		}

		//Ako stvarno nema tog broja
		if (!thereIsInRow) {
			for (int j = 0; j < Y_DIM; j++) {
				//Moze broj samo ako je polje prazno
				if (tab.getPos(row, j) == EMPTY)
					list.add(new SudokuAction(new XYLocation(row, j), num));
			}
		}

	}

}
