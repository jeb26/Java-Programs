import java.util.Arrays;

public class conway {
	public static void main(String[] args)
	{
		int row, col, ticks, _row, _col;
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		row = input.nextInt();
		col = input.nextInt();
		ticks = input.nextInt();
		
		//make intital grid
		char[][] a = new char[row + 2][col +2];
		
		//grab input from file and make certain cells alive
		while(input.hasNext())
		{
			try
			{
				_row = input.nextInt();
				_col = input.nextInt();
				a[_row + 1][_col + 1] = '1';
			}
			catch(Exception e)
			{
				continue;
			}
		}
		
		//fill the grid with dead cells and surround it with zeros
		populateGrid(a);
		
		//make a copy of the grid
		char[][] b = new char[a.length][a[0].length];
		
		for (int i = 0; i < a.length; i++) {
		    System.arraycopy(a[i], 0, b[i], 0, a[0].length);
		}
		
		//process generations
		while(true)
		{
		
			//old
			char[][] old = new char[a.length][a[0].length];
			
			for(int i = 0; i < a.length; i++)
			{
				for(int j = 0; j < a[0].length; j++)
				{
					try
					{
						processGrid(a,b,i,j);
					}
					catch(Exception e)
					{
						continue;
					}
				}
			}
			
			//copy new of board to original grid
			for (int i = 0; i < b.length; i++) {
			    System.arraycopy(b[i], 0, a[i], 0, b[0].length);
			}
			
			printGrid(a);
			ticks--;
			
			if(Arrays.deepEquals(old, a)
			{
				break;
			}
			
			for (int i = 0; i < b.length; i++) {
			    System.arraycopy(b[i], 0, old[i], 0, b[0].length);
			}

		}
		
	}//end of main method
	
	public static void printGrid(char[][] grid)
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j] == '0'){ continue; };
				System.out.printf("%c ", grid[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void populateGrid(char[][] grid)
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if((i == 0) || (j == 0) || (j == (grid.length - 1)) || (i == grid[i].length-1))
				{
					grid[i][j] = '0';
				}
				else if(grid[i][j] == '1')
				{
					continue;
				}
				else {
					grid[i][j] = '-'; //dead char
				}
			}
		}	
	}
	
	public static void processGrid(char[][] a, char[][] b, int row, int col)
	{
		int count = 0;
		
		/*
		 * Applies the algorithm logic to either an alive or dead cell. To
		 * implement logic ternary operations are used to increment a counter if
		 * a condition is met 
		 */
		if(a[row][col] == '1' || a[row][col] == '-')
		{
			count += (a[row - 1][col - 1] == '1') ? 1 : 0;		/*topLeft position*/
			count += (a[row - 1][col] == '1') ? 1 : 0;			/*top position*/
			count += (a[row - 1][col + 1] == '1') ? 1 : 0;		/*topRight position*/ 
			count += (a[row][col - 1] == '1') ? 1 : 0;			/*left position*/ 
			count += (a[row][col + 1] == '1') ? 1 : 0;			/*right position*/ 
			count += (a[row + 1][col - 1] == '1') ? 1 : 0;		/*bottomLeft position*/ 
			count += (a[row + 1][col] == '1') ? 1 : 0;			/*bottom position*/ 
			count += (a[row + 1][col + 1] == '1') ? 1 : 0;		/*bottomRight position*/ 
			//System.out.println(count);
		}
		
		//Alive Cell Cases
		if(a[row][col] == '1' && count < 2 ) { b[row][col] = '-'; }
		else if(a[row][col] == '1' && count == 2 || a[row][col] == '1' && count == 3) { b[row][col] = '1'; }
		else if(a[row][col] == '1' && count > 3) { b[row][col] = '-'; }
		
		//Dead Cell Case
		if(a[row][col] == '-' && count == 3) { b[row][col] = '1'; }
	}

}//end of class

