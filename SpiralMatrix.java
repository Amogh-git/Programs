import java.util.*;
public class SpiralMatrix {
	static void locateElementRow(int number, int[][] matrix, int start_location, int end_location,int row) {
		for(int i=start_location;i<=end_location;i++)
		{
			if(number==matrix[row][i])
			{
				System.out.println("Location of "+number+" is "+row+","+i);
				return;
			}
		}
		System.out.println("No such number !!");
	}
	static void locateElementColumn(int number, int[][] matrix, int start_location, int end_location,int column) {
		for(int i=start_location;i<=end_location;i++)
		{
			if(number==matrix[i][column])
			{
				System.out.println("Location of "+number+" is "+i+","+column);
				return;
			}
		}
		System.out.println("No such number !!");
	}
	static int getInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number to search its location in spiral matrix");
		return s.nextInt();
		
	}
	static int[][] initializeMatrix() {
		int[][] matrix= {{1,2,3,4,5},
						{16,17,18,19,6},
						{15,24,25,20,7},
						{14,23,22,21,8},
						{13,12,11,10,9}}; 
		return matrix;
	}
	static void getlocation(int[][] matrix, int number, int size) {
		int row=0,column=0,start_element=matrix[0][0];
		int end_element = matrix[1][0];
		int upper_left_corner_element,upper_right_corner_element,lower_left_corner_element,lower_right_corner_element;
		int temp = size;
		while(number>end_element && temp>1) {
			start_element = matrix[++row][++column];
			temp -=2;
			end_element = matrix[row+1][column];
		}
		upper_left_corner_element = start_element;
		upper_right_corner_element = matrix[row][size-column-1];
		lower_left_corner_element = matrix[size-row-1][column];
		lower_right_corner_element = matrix[size-row-1][size-column-1];
		if(number>=upper_left_corner_element && number<=upper_right_corner_element)
		{
			locateElementRow(number,matrix,row,size-column-1,row);
		}
			
		else if(number>=upper_right_corner_element && number<=lower_right_corner_element)
		{
			locateElementColumn(number,matrix,row,size-row-1,size-column-1);
		}
			
		else if(number<=lower_left_corner_element && number>=lower_right_corner_element)
		{
			locateElementRow(number,matrix,column,size-column-1,size-row-1);
		}
			
		else
		{
			locateElementColumn(number,matrix,row,size-row-1,column);
		}
			
	}
	
	public static void main(String[] args) {
		int[][] matrix=initializeMatrix();
		int number;
		number = getInput();
		getlocation(matrix,number,5);
	}

}
