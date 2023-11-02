package BasicClosedLabbook;

import java.util.Scanner;

public class AverageOfTheNNumber {
public void Calculate() {
	int n;
	double Average=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter how many inputs are Entered by User:");
	n=sc.nextInt();
	double a[]=new double[n];
	System.out.println("Enter the numbers");
	for(int i=0;i<n;i++) 
		a[i]=sc.nextInt();
	int i = 0;
	for(int j=0;j<n;j++)
		Average=Average+a[i];
	System.out.println(Average);
}
	
public static void main(String[] args) {
	AverageOfTheNNumber rk=new AverageOfTheNNumber();
	rk.Calculate();
}
}
