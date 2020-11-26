package sudoku;

import dmi.vi1.search.datastructure.XYLocation;
import dmi.vi1.search.framework.Action;

public class SudokuAction implements Action {

	private XYLocation to; //Koja koordinata
	private int num; // Koji broj

	public SudokuAction(XYLocation to, int num) {
		super();
		this.to = to;
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public XYLocation getTo() {
		return to;
	}

	public void setTo(XYLocation to) {
		this.to = to;
	}

	@Override
	public boolean isNoOpAction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Stavi " + num + " na poziciju: " + to.getPositionX() + ", " + to.getPositionY();
	}

}
