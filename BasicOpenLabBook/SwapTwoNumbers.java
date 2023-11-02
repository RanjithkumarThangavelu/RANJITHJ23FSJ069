package BasicProgram;

import java.util.Scanner;

public class SwapTwoNumbers {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Number1:");
	float n1=sc.nextFloat();
	System.out.println("Enter the number2:");
	float n2=sc.nextFloat();
	System.out.println("Before Swap");
	System.out.println("First Number ="+n1);
	System.out.println("Second Number ="+n2);
	
	float temp=n1;
	n1=n2;
	n2=temp;
	System.out.println("After Swap");
	System.out.println("First Number ="+n1);
	System.out.println("Second Number ="+n2);
}
}
