package BasicProgram;

import java.util.Scanner;

public class Largestnumber {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Number1:");
	double n1=sc.nextDouble();
	System.out.println("Enter the Number2:");
	double n2=sc.nextDouble();
	System.out.println("Enter the Number3:");
	double n3=sc.nextDouble();
	if(n1>=n2 && n1>=n3)
		System.out.println(n1 +"is the Largest Number");
	else if(n2>=n1 && n2>=n3)
		System.out.println(n2 +"is the Largest Number");
	else 
		System.out.println(n3 +"is the Largest Number");
}
}
