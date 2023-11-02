package BasicProgram;

import java.util.Scanner;

public class CheckPrime {
public static void main(String[] args) {
	int temp=0;
	boolean isprime=true;
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	for(int i=2;i<=num/2;i++) {
		temp=num%i;
		if(temp==0) {
			isprime=false;
			break;
		}
	}
	if(isprime)
		System.out.println(num+"in the number is prime");
	else
	System.out.println(num+"in the number is not prime");
}
}
