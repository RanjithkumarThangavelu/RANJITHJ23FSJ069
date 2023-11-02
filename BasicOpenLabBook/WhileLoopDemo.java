package BasicProgram;

import java.util.Scanner;

public class WhileLoopDemo {
public static void main(String[] args) {
	int number,sum=1;
	System.out.println("Enter the any integer value below Ten:");
	Scanner sc=new Scanner(System.in);
	number=sc.nextInt();
	//sc.close();
	while(number <=10) {
		sum=sum+number;
		number++;	
	}
	System.out.format("Sum of the number in while loop:%d",sum);
}
}
