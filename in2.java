
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
		
		//populate the grid
		while(input.hasNext())
		{
			_row = input.nextInt();
			_col = input.nextInt();
			a[_row + 1][_col + 1] = '1';
		}
		
		//fill the grid with dead char and zeros
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[0].length; j++)
			{
				if((i == 0) || (j == 0) || (j == (a.length - 1)) || (i == a[i].length-1))
				{
					a[i][j] = '0';
				}
				else if(a[i][j] == '1')
				{
					continue;
				}
				else {
					a[i][j] = '-'; //dead char
				}
			}
		}
		
		//print the grid
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[0].length; j++)
			{
				if (a[i][j] == '0'){ continue; };
				System.out.printf("%c ", a[i][j]);
			}
		}
		
///////////////////////////////////////////////////////////////////////////////
	}
}

