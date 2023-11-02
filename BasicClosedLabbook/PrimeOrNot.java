package BasicClosedLabbook;

import java.util.Scanner;

public class PrimeOrNot {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Number:");
	int number=sc.nextInt();
	boolean flag=false;
	for(int i=number;i<=number/2;number++) {
		if(number%i==0) {
			flag=true;
		}
	}
	if(!flag)
		System.out.println("The number is Prime!");
	else
		System.out.println("The number is Not Prime!");
}
}
