package dharia.maahi;


public class Board  {
	final int WIDTH = 7;
	final int HEIGHT = 6; 
	private Cell[][] board= new Cell [WIDTH][HEIGHT];
	
	
	Board(){
		for (int i = 0 ; i <  WIDTH ; i++)
		{
		    for (int n = 0 ; n < HEIGHT; n++)
		    {
		    	board[i][n] = new Cell ();
		    }
		}
	}
	
	public  void display(){	
		  System.out.println("");
		  System.out.println("");
		  System.out.println("");
		  System.out.println("");
		for (int i = 0 ; i <  WIDTH ; i++)
		{
		    for (int n = 0 ; n < HEIGHT; n++)
		    {
		    	if(board[i][n].getState()==CellState.EMPTY){
		    	System.out.print(" [  ] ");
		    	}
		    }
		    System.out.println("");
		}
	}
	
	
	
	
	
	
	
	
	}
	

