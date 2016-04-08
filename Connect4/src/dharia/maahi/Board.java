package dharia.maahi;

import java.util.*;
import java.math.*;
/**
 * Prints, updates, checks board for input validity and if there are any winners
 * @author dharia.maahi, visvalingam.manoj
 *
 */
public class Board {

	final int ROW = 7;
	final int COLUMN = 7;
	private Cell[][] board = new Cell[ROW][COLUMN];
	final int LASTROW = ROW - 1;

	/**
	 * Initializes the board
	 */
	public Board() {
		for (int a = 0; a < ROW; a++) {
			for (int b = 0; b < COLUMN; b++) {
				board[a][b] = new Cell();
			}
		}
	}
	
	/**
	 * Checks if column is full
	 * @param col
	 * @return
	 */
	public boolean isColumnFull(int col){
			if (board[0][col].getState()!=CellState.EMPTY){
				return true;
			}
		return false;
	}

	/**
	 * Updates the state of the board once it finds the empty cell
	 * @param colNum
	 * @param cs
	 * @return
	 */
	public int updateBoard(int colNum, CellState cs) {
		int rowVal = ROW - 1;
		boolean isEmptyFound = false;
		while (!isEmptyFound) {
			if (board[rowVal][colNum].getState() == CellState.EMPTY) {
				board[rowVal][colNum].setState(cs);
				isEmptyFound = true;
			} else {
				rowVal--;
			}
		}
		return rowVal;
	}

	/**
	 * Switches cell state into text [X] or [O]
	 * @param state
	 */
	public void switchCase(CellState state) {
		switch (state) {
		case P1:
			System.out.println("[X]");
		case P2:
			System.out.println("[O]");
		}
	}

	/**
	 * Prints the board
	 */
	public void printBoard() {
		for (int a = 0; a < ROW; a++) {
			for (int b = 0; b < COLUMN; b++) {
				if (board[a][b].getState() == (CellState.EMPTY)) {
					System.out.print("[-]");
				} else if (board[a][b].getState() == (CellState.P1)) {
					System.out.print("[X]");
				} else if (board[a][b].getState() == (CellState.P2)) {
					System.out.print("[O]");
				}
			}
			System.out.println(" ");
		}
	}

	/**
	 * checks if there is a draw
	 * @return
	 */
	public boolean isDraw() {
		for (int a = 0; a < ROW; a++) {
			for (int b = 0; b < COLUMN; b++) {
				if (board[a][b].getState() == (CellState.EMPTY)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * checks for Vertical win
	 * @param row
	 * @param colNum
	 * @return
	 */
	public boolean isWinVertical(int row, int colNum) {
		boolean isDone = false;
		int length = 1;
		int currentRow = row;
		int currentCol = colNum;
		CellState state = board[currentRow][currentCol].getState();

		while (!isDone && currentRow < ROW - 1) {
			if (board[currentRow][currentCol].getState() == state && board[currentRow][currentCol].getState() != CellState.EMPTY) {
				length++;
				currentRow++;
			} else {
				isDone = true;
			}
		}

		if (length == 4) {
			return true;
		} else {
			return false;
		}
		
		/*for (int a = 0; a < ROW; a++) {
			int length=0;
			for (int b = 0; b < COLUMN; b++) {
				if (board[currentRow][currentCol] == board[currentRow][currentCol+1]){
					length++
				}
				if (length == 4) {
				return true;
		}
			}
		
		}*/
	}

	/**
	 * checks for horizontal win
	 * @param row
	 * @param colNum
	 * @return
	 */
	public boolean isWinHorizontal(int row, int colNum) {
		
		int length = 1;
		boolean isDone = false;
		int currentRow = row;
		int currentCol = colNum;
		CellState state = board[currentRow][currentCol].getState();

		while (!isDone && currentCol > 0) {

			if (state == board[currentRow][currentCol - 1].getState() && board[currentRow][currentCol].getState() != CellState.EMPTY ) {
				length++;
				currentCol--;
			} else {
				isDone = true;
			}
		}
		if (length == 4) {
			return true;
		}

		isDone = false;
		currentCol = colNum;

		while (!isDone && currentCol < COLUMN - 1) {
			if (board[currentRow][currentCol + 1].getState() == state && board[currentRow][currentCol].getState() != CellState.EMPTY) {
				length++;
				currentCol++;
			} else {
				isDone = true;
			}
		}

		if (length >= 4) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checks for win diagonally downwards
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isWinDiagonalDown(int row, int col) {
		boolean isDone = false;
		int length = 1;
		int currentRow = row;
		int currentCol = col;
		CellState state = board[currentRow][currentCol].getState();

		while (!isDone && currentCol > 0 && currentRow > 0) {
			if (board[currentRow - 1][currentCol - 1].getState() == state && board[currentRow][currentCol].getState() != CellState.EMPTY) {
				length++;
				currentCol--;
				currentRow--;
			} else {
				isDone = true;
			}
		}
		if (length == 4) {
			return true;
		}

		isDone = false;
		currentRow = row;
		currentCol = col;

		while (!isDone && currentCol < COLUMN - 1 && currentRow < LASTROW) {
			if ( state == board[currentRow + 1][currentCol + 1].getState() && board[currentRow][currentCol].getState() != CellState.EMPTY) {
				length++;
				currentCol++;
				currentRow++;
			} else {
				isDone = true;
			}
		}

		if (length >= 4) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checks for win diagonally upwards
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isWinDiagonalUp(int row, int col) {
		int length = 1;
		boolean isDone = false;
		int currentRow = row;
		int currentCol = col;
		CellState state = board[currentRow][currentCol].getState();

		while (!isDone && currentCol > 0 && currentRow < LASTROW) {
			if (state == board[currentRow + 1][currentCol - 1].getState() && board[currentRow][currentCol].getState() != CellState.EMPTY) {
				length++;
				currentCol--;
				currentRow++;
			} else {
				isDone = true;
			}
		}
		if (length == 4) {
			return true;
		}

		isDone = false;
		currentRow = row;
		currentCol = col;

		while (!isDone && currentCol > COLUMN - 1 && currentRow > 0) {
			if (state == board[currentRow - 1][currentCol + 1].getState() && board[currentRow][currentCol].getState() != CellState.EMPTY) {
				length++;
				currentCol++;
				currentRow--;
			} else {
				isDone = true;
			}
		}
		if (length >= 4) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * computer randomly generates a column value to drop the token
	 * @return
	 */
	public int AiRandom() {
		boolean isDone=false;
		int randCol = 0;
		while(!isDone){
			Random num = new Random();
			randCol = num.nextInt(7);
			if (!isColumnFull(randCol)){
				isDone=true;
			}
		}
		return randCol;
	}

	
}