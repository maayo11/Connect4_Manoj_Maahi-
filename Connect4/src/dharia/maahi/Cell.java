package dharia.maahi;
/**
 * Configures cell states
 * @author dharia.maahi, visvalingam.manoj
 *
 */
public class Cell {
		
		private CellState state;
		
		/**
		 * Cell constructor 
		 */
		Cell(){
			state=CellState.EMPTY;
		}
				
		/**
		 * Sets initial state to empty
		 */
		public void setState(){
			state=CellState.EMPTY;
		}

		/**
		 * Obtains the state of the cell 
		 * @return
		 */
		public CellState getState(){
			return state;
		}
		
		/**
		 * sets the new state as the current states
		 * @param newState
		 */
		public void setState(CellState newState){
			state=newState;
		}
}
