package BasicProgram;

import java.util.Scanner;

public class FloydsTriangle {
public static void main(String[] args) {
		int i,number =1,counter,j;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of rows in Floyds triangle:");
		i =input.nextInt();
		System.out.println("Floyds Triangle");
		System.out.println("************************");
		for(counter=1;counter<=i;counter++) {
			for(j=1;j<=counter;j++) {
				System.out.print(number+" ");
				number++;
			}
			System.out.println();
		}
}
}
