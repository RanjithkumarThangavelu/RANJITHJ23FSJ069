package BasicProgram;

import java.util.Scanner;

public class FindAreaOfSquare {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Square of the side:");
	double side=sc.nextDouble();
	double area=side*side;
	System.out.println("The area of the Square is:"+area);
}
}
