package dharia.maahi;

public class Cell {
	private CellState state;

	Cell(){
		state=CellState.EMPTY;
	}
	
	public CellState getState(){
		return state;
	}
	
	/*public void setStateEMPTY(){
		state=CellState.EMPTY;
	}*/
	
	
}
