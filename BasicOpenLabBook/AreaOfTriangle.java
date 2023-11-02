package BasicProgram;

import java.util.Scanner;

public class AreaOfTriangle {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Width of the Triangle:");
	double width=sc.nextDouble();
	System.out.println("Enter the height of the Triangle:");
	double height=sc.nextDouble();
	double area=(width*height)/2;
	System.out.println("The area of the Triangle is:"+area);
}
}
