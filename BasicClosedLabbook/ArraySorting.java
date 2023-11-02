package BasicClosedLabbook;

import java.util.Arrays;

public class ArraySorting {
public static void main(String[] args) {
	int a[]={3,6,2,7,1,9,8,0};    
    Arrays.sort(a);       
    for(int i=0;i<a.length;i++)   
    {
        System.out.print(a[i]+" ");
    }
    System.out.println();   
      for(int i=a.length-1;i>=0;i--)    
    {
        System.out.print(a[i]+" ");
    }        }
}
