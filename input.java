public class input 
{
	public static void main(String[] args)
	{
		/*
		 * Program that written to take in an n number of lines of input via
		 * pipes through the linux terminal.
		 */
		 
		 java.util.Scanner text = new java.util.Scanner(System.in);
		 int rowSize, colSize, ticks, row, col;
		 int count = 0;
		 
		 while(text.hasNext())
		 {
		 	 if(count == 0)
		 	 {
			 	 //The first line of three variables
				 rowSize = text.nextInt();
				 colSize = text.nextInt();
				 ticks = text.nextInt();
				 System.out.println("# ROWS: "+rowSize +" # COLS: "+ colSize +" # GENERATIONS: " + ticks);
		 	 }
		 	 else
		 	 {
		 	 	 row = text.nextInt();
		 	 	 col = text.nextInt();
		 	 	 System.out.println("Line #: "+count+" ROW: "+row+" COL: "+col);
		 	 }
			 count++;
		 }

	}
}
