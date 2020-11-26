package sudoku;

import dmi.vi1.search.datastructure.XYLocation;
import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ResultFunction;

public class SudokuResultFunction implements ResultFunction {

	@Override
	public Object result(Object s, Action a) {
		SudokuTable table  = (SudokuTable) s;
		SudokuAction action = (SudokuAction) a;
		
		int num = action.getNum();
		XYLocation to = action.getTo();
		
		SudokuTable newTable = table.clone();
		newTable.setPos(to.getPositionX(), to.getPositionY(), num);
		return newTable;
	}

}
