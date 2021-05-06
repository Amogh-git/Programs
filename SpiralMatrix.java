import java.util.*;
public class SpiralMatrix {

	static void getloc(int[][] matrix, int num, int n) {
		int i=0,j=0,start=1,r=0,c=0;
		int m=n;
		int end = start + 4*(m-1) - 1;
		while(num>end && m>1) {
			start = end +1;
			m -=2;
			end = start + 4*(m-1) - 1;
			i++;
			j++;
		}
		System.out.println("Ring starts from "+matrix[i][j]);
		r=i;c=j;
		for(;j<n-r;j++)
		{
			//System.out.println("checking "+i+","+j+"="+matrix[i][j]);
			if(matrix[i][j] == num)
			{
				System.out.println("Location is  "+i+","+j);
				return;
			}
		}
		j--;
		for(;i<n-c;i++)
		{
			//System.out.println("checking "+i+","+j+"="+matrix[i][j]);
			if(matrix[i][j] == num)
			{
				System.out.println("Location is  "+i+","+j);
				return;
			}
		}
		i--;
		for(;j>=c;j--)
		{
			if(matrix[i][j] == num)
			{
				System.out.println("Location is  "+i+","+j);
				return;
			}
		}
		j++;
		for(;i>=r;i--)
		{
			if(matrix[i][j] == num)
			{
				System.out.println("Location is  "+i+","+j);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix= {{1,2,3,4,5},
						{16,17,18,19,6},
						{15,24,25,20,7},
						{14,23,22,21,8},
						{13,12,11,10,9}}; 
		Scanner s = new Scanner(System.in);
		int num;
		System.out.println("enter number to search ");
		num = s.nextInt();
		getloc(matrix,num,5);
	}

}
