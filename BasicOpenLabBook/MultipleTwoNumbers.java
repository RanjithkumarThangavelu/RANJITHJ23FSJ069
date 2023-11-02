package BasicProgram;

import java.util.Scanner;

public class MultipleTwoNumbers {
 public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter the First Number:");
	int i=sc.nextInt();
	System.out.println("enter the Second Number:");
	int j=sc.nextInt();
	int mul=i*j;
	System.out.println("The number is:"+mul);
}
}
