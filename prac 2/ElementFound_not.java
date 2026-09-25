import java.util.Scanner;
class ElementFound_not
{
	public static void main(String cp[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the no. of row and columns: ");
		int rows=sc.nextInt();
		int cols=sc.nextInt();
		
		int[][] arr=new int[rows][cols];
		System.out.print("Enter the elements of rows & columns: "+ " ");
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				arr[i][j]=sc.nextInt();
			}
		}
		System.out.print("Enter the number to search: ");
		int search=sc.nextInt();
		int count=0;
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				if(arr[i][j]==search)
				{
					System.out.println("Element found.");
					count++;
				}
			}
		}
		if(count==0)
		{
			System.out.println("Element not found.");
		}
	}
}