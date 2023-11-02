package BasicProgram;

import java.util.Scanner;

public class AreaOfCircle {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Radius");
	double radius=sc.nextDouble();
	double area=Math.PI*(radius*radius);
	System.out.println("The area of the circle is:"+area);
	double circumference=Math.PI*2*radius;
	System.out.println("The area of Circumference is:"+circumference);
}
}
