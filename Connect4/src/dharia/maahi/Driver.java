package dharia.maahi;

import java.util.*;

import javax.swing.JOptionPane;
/**
 * Each player picks a color then takes turns dropping the disks into the grid. The object of the game is to connect four 
 * disks in a row vertically, horizontally, or diagonally.
 * @author dharia.maahi, visvalingam.manoj
 *
 */
public class Driver {
	final static int COLUMN = 7;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int colNum = 0;
		String playTwo = "Y";
		int playerTurn = 0;
		Board board = new Board();
		int rowLocation;
		boolean isGameDone = false;

		instructions();
		
		// Checks for valid input
		System.out.println(" ");
		while (!playTwo.equalsIgnoreCase("Y") || !playTwo.equalsIgnoreCase("N")) {
			System.out.print("Please enter Y if you want to play two player and N if you want to play one player. ");
			playTwo = in.next();
			if (playTwo.equalsIgnoreCase("Y") || playTwo.equalsIgnoreCase("N")) {
				break;
			}
		}
		board.printBoard();
		//2 player game loop
		while (!isGameDone && playTwo.equalsIgnoreCase("Y")) {
			
			if (playerTurn % 2 == 0) {
				boolean isValidInput = false;
				System.out.println(" ");
				System.out.println("Player 1 turn. You are X.");
				while (!isValidInput) {
					System.out.println(" ");
					System.out.print("Enter a column number from 1-7: ");
					colNum = in.nextInt() - 1;
					if (colNum >= 0 && colNum < COLUMN) {
						if (!board.isColumnFull(colNum)){
							isValidInput = true;
							rowLocation = board.updateBoard(colNum, CellState.P1);
							board.printBoard();
							if (board.isDraw()) {
								System.out.print("There is no winner. Game was a draw.");
								isGameDone = true;
							}
							if (board.isWinVertical(rowLocation, colNum) || board.isWinHorizontal(rowLocation, colNum)
									|| board.isWinDiagonalDown (rowLocation,colNum) || board.isWinDiagonalUp (rowLocation,colNum)) {
								System.out.println(" ");
								System.out.print("Player 1 wins! ");
								isGameDone = true;
								break;
							}
						}
						else {
							System.out.println(" ");
							System.out.println("Column is full.");
						}
					} else {
						System.out.print("That was not a valid integer");
						isValidInput = false;
					}
				}
			} else {
				System.out.println("Player 2 turn. You are O.");
				boolean isValidInput = false;
				while (!isValidInput) {
					System.out.println(" ");
					System.out.print("Enter a column number from 1-7: ");
					colNum = in.nextInt() - 1;
					if (colNum >= 0 && colNum < COLUMN) {
						if (!board.isColumnFull(colNum)){ 
							isValidInput = true;
							rowLocation = board.updateBoard(colNum, CellState.P2);
							board.printBoard();
							if (board.isDraw()) {
								System.out.print("There is no winner. Game was a draw.");
								isGameDone = true;
							}
							if (board.isWinVertical(rowLocation, colNum) || board.isWinHorizontal(rowLocation, colNum) 
									|| board.isWinDiagonalDown (rowLocation,colNum) || board.isWinDiagonalUp (rowLocation,colNum)) {
								System.out.print("Player 2 wins! :) ");
								isGameDone = true;
								break;
							}	
						}
						else {
							System.out.println(" ");
							System.out.println("Column is full.");
						}
					} else {
						System.out.print("That was not a valid integer");
						isValidInput = false;
					}
				}
			}
			playerTurn++;
		}

		//Ai game loop
		while (!isGameDone && playTwo.equalsIgnoreCase("N")) {
			if (playerTurn % 2 == 0) {
				System.out.println(" ");
				System.out.println("Player 1 turn. You are X.");
				boolean isValidInput = false;
				while (!isValidInput) {
					System.out.println(" ");
					System.out.print("Enter a column number from 1-7: ");
					colNum = in.nextInt() - 1;
					if (colNum >= 0 && colNum < COLUMN) {
						if (!board.isColumnFull(colNum)){ 
							isValidInput = true;
							rowLocation = board.updateBoard(colNum, CellState.P1);
							board.printBoard();
							if (board.isDraw()) {
								System.out.print("There is no winner. Game was a draw.");
								isGameDone = true;
							}
							if (board.isWinVertical(rowLocation, colNum) || board.isWinHorizontal(rowLocation, colNum) 
									|| board.isWinDiagonalDown (rowLocation,colNum) || board.isWinDiagonalUp (rowLocation,colNum)) {
								System.out.println(" ");
								System.out.print("Player 1 wins! ");
								isGameDone = true;
								break;
							}	
						}
						else {
							System.out.println(" ");
							System.out.println("Column is full.");
						}
					}
					else {
						System.out.print("That was not a valid integer");
						isValidInput = false;
					}
				}
			} else {
				System.out.println("Computer's turn. You are O.");
				colNum = board.AiRandom();
				rowLocation = board.updateBoard(colNum, CellState.P2);
				board.printBoard();
				if (board.isDraw()) {
					System.out.print("There is no winner. Game was a draw.");
					isGameDone = true;
				}
				if (board.isWinVertical(rowLocation, colNum) || board.isWinHorizontal(rowLocation, colNum) || board.isWinDiagonalDown (rowLocation,colNum) ||
						 board.isWinDiagonalUp (rowLocation,colNum)) {
					System.out.print("Player 2 wins! :) ");
					isGameDone = true;
				}
			}
			playerTurn++;
		}
	}

	public static void instructions() {
		System.out.println("Each player picks a color then takes turns dropping the disks into the grid. ");
		System.out.println("The object of the game is to connect four disks in a ");
		System.out.println("row vertically, horizontally, or diagonally.");
	}

}
