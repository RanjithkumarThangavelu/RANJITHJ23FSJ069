package BasicProgram;

import java.util.Scanner;

public class ArrayInput {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int[] array=new int[10];
	int sum=0;
	System.out.println("Enter the Elements:");
	for(int i=0;i<10;i++) {
		array[i]=sc.nextInt();
	}
	for(int j:array) {
		sum=sum+j;
	}
	System.out.println("The array Elements is:"+sum);
}
}
