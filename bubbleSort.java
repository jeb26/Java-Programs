public class bubbleSort 
{
	public static void main(String[] args)
	{
		int h[] = {56,34,100,4,15};
		printArray(h,'u');
		sortArray(h);
		printArray(h, 's');
	}
	
	public static void sortArray(int[] a)
	{		
		for(int i = 0; i < a.length; i++)
		{
			if((i < (a.length -1)) && (a[i] > a[i + 1]))
			{
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
				i = -1;
			}
		}
	}
	
	public static void printArray(int[] a, char flag)
	{
		if(flag == 'u')
			System.out.printf("Unsorted Array:%n");
		else
			System.out.printf("Sorted Array:%n");
		
		for(int i = 0; i < a.length; i++)
		{
			System.out.printf("%d\t",a[i]);
		}
		System.out.println();
	}
}
