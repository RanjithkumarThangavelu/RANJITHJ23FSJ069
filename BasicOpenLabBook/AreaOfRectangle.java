package BasicProgram;

import java.util.Scanner;

public class AreaOfRectangle {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the length of Rectangle:");
	double length=sc.nextDouble();
	System.out.println("Enter the width of Rectangle:");
	double width=sc.nextDouble();
	double area=length*width;
	System.out.println("The area of Rectangle Is:"+area);
}
}
