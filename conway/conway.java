/*
 * James Edward Bell
 * CS 280: Programming Language Concepts
 * Prof. Gerard Ryan
 * Project #1: Conway's Game of Life
 */

public class conway {
	public static void main(String[] args) {

		int row, col, ticks, _row, _col;
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		row = input.nextInt();
		col = input.nextInt();
		ticks = input.nextInt();
		
		char[][] a = new char[row + 2][col +2]; // Instantiate the initial grid
		
		/*
		 * Get seed information of initial alive cells
		 * Input is error checked and will skip any ArrayOutOfBound Exceptions
		 */
		while(input.hasNext()) {
			try {
				_row = input.nextInt();
				_col = input.nextInt();
				a[_row + 1][_col + 1] = 'X'; //alive char
			}
			catch(Exception e) { continue; }
		}
		
		populateGrid(a); //fill grid with dead cells and surround with zeros
		
		/*
		 * Make a copy of the initial grid
		 */
		char[][] b = new char[a.length][a[0].length];
		
		for (int i = 0; i < a.length; i++) 
			System.arraycopy(a[i], 0, b[i], 0, a[0].length);
		
		/*
		 * Begin generation processing. Processing is controlled for errors. 
		 * If any cell causes an exception it is skipped so overall processing can continue. 
		 */
		while(ticks > 0) {
			for(int i = 0; i < a.length; i++)
				for(int j = 0; j < a[0].length; j++) {
					try { processGrid(a,b,i,j); }
					catch(Exception e) { continue; }
				}
			
			/*
			 * Synch results of current processing with old grid
			 */
			for (int i = 0; i < b.length; i++)
			    System.arraycopy(b[i], 0, a[i], 0, b[0].length);
			
			printGrid(a);
			ticks--;
		}
	}//END OF MAIN BEGINNING OF PROGRAM METHODS
	
	/*
	 * printGrid(CHAR[][] ARRAY)
	 * Function will print to standard out any 2D char array passed to it
	 */
	public static void printGrid(char[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0'){ continue; };
				System.out.printf("%c ", grid[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	 * populateGrid(CHAR[][] ARRAY)
	 * Function will:
	 * 1. Take an initially empty grid and first surround it with zeros
	 *    to avoid any exceptions during processing. 
	 *    
	 *    e.g. 
	 *    
	 *    3 x 3 matrix becomes:
	 *    
	 *    0 0 0 0 0
	 *    0 - - - 0
	 *    0 - - - 0
	 *    0 - - - 0
	 *    0 0 0 0 0
	 * 
	 * 2. Will make any empty cell dead
	 */
	public static void populateGrid(char[][] grid) {
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid[0].length; j++) {
				if((i == 0) || (j == 0) || (j == (grid.length - 1)) || (i == grid[i].length-1))
				{ grid[i][j] = '0'; }
				else if(grid[i][j] == 'X') { continue; }
				else { grid[i][j] = '_'; } // dead char
			}
	}
	
	/*
	 * processGrid(CHAR[][] ARRAY, CHAR[][] ARRAY, INT ROW, INT COL)
	 * 
	 * Function applies the algorithm logic to either an alive or dead cell. To
	 * implement logic ternary operations are used to increment a counter if
	 * a condition is met. Function reads from one array and writes changes to another.
	 */
	public static void processGrid(char[][] a, char[][] b, int row, int col) {
		int count = 0;
		
		if(a[row][col] == 'X' || a[row][col] == '_') {
			count += (a[row - 1][col - 1] == 'X') ? 1 : 0;		/*topLeft position*/
			count += (a[row - 1][col] == 'X') ? 1 : 0;			/*top position*/
			count += (a[row - 1][col + 1] == 'X') ? 1 : 0;		/*topRight position*/ 
			count += (a[row][col - 1] == 'X') ? 1 : 0;			/*left position*/ 
			count += (a[row][col + 1] == 'X') ? 1 : 0;			/*right position*/ 
			count += (a[row + 1][col - 1] == 'X') ? 1 : 0;		/*bottomLeft position*/ 
			count += (a[row + 1][col] == 'X') ? 1 : 0;			/*bottom position*/ 
			count += (a[row + 1][col + 1] == 'X') ? 1 : 0;		/*bottomRight position*/ 
		}
		
		//Alive Cell Cases
		if(a[row][col] == 'X' && count < 2 ) { b[row][col] = '_'; }
		else if(a[row][col] == 'X' && count == 2 || a[row][col] == 'X' && count == 3) { b[row][col] = 'X'; }
		else if(a[row][col] == 'X' && count > 3) { b[row][col] = '_'; }
		
		if(a[row][col] == '_' && count == 3) { b[row][col] = 'X'; } //dead cell case
	}
}