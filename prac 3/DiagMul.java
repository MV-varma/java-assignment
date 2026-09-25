import java.util.Scanner;

class DiagMul{
	public static void main(String[] cp){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of rows: ");
		int rows = sc.nextInt();
		System.out.print("Enter number of cols: ");
		int cols = sc.nextInt();
		
		int matrix[][] = new int[rows][cols];

		for(int i = 0;i<rows;i++){
			for(int j = 0;j<cols;j++){
				System.out.print("Enter number for row "+i+" and col "+j+" : ");
				matrix[i][j] = sc.nextInt(); 
			}
		}
		
		int prod=1;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(i==j){
					prod*=matrix[i][j];
				}		
			}
		}
		System.out.print(prod+" is the product of diagonal");	
	}
}