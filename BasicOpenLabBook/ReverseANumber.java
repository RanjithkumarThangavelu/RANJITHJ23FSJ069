package BasicProgram;

import java.util.Scanner;

public class ReverseANumber {
public static void main(String[] args) {
	int num,reversenum=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Number:");
	num=sc.nextInt();
	while(num!=0) {
		reversenum=reversenum*10;
		reversenum=reversenum+num%10;
		num=num/10;
		
	}
	System.out.println("Reverse of the input is:"+reversenum);
}
}
