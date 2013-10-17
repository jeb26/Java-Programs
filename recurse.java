public class recurse
{
	public static void recTest(int i) 
	{ 
		if(i > 0) 
		{
			recTest(i - 1);
			System.out.printf("%d %n",i);
		}
	}
	
	public static void main(String[] args)
	{
		recTest(5);
	}
}
