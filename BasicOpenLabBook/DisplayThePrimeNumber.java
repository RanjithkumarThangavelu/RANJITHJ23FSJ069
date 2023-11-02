package BasicProgram;

import java.util.Scanner;

public class DisplayThePrimeNumber {
public static void main(String[] args) {
	int i=0;
	int num=0;
	String primenumber="";
	for(i=1;i<=100;i++) {
		int counter=0;
		for(num=i; num>=1; num--) {
			if(i%num==0) {
				counter=counter+1;
			}
		}
		if(counter==2) {
			primenumber=primenumber+i+"";
		}
	}
	System.out.println("1 to 100 prime numbers are:");
	System.out.println(primenumber);
}
}
