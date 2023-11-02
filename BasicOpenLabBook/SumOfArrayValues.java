package BasicProgram;

public class SumOfArrayValues {
public static void main(String[] args) {
	int[] array= {10,20,30,40,50};
	int sum=0;
	for(int i:array) {
		sum=sum+i;
		System.out.println("One to one Add Values:"+sum);
	}
	System.out.println("The sum of the array value is:"+sum);
}
}
