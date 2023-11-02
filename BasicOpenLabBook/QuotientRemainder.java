package BasicProgram;

import java.util.Scanner;

public class QuotientRemainder {
	 public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Divident:");
		int Divident=sc.nextInt();
		System.out.println("ENter the Diviser:");
		int Diviser=sc.nextInt();
		int Quotient=Divident/Diviser;
		int Remainder=Divident%Diviser;
		System.out.println("Quotient ="+Quotient);
		System.out.println("Remainder ="+Remainder);
	}
}
