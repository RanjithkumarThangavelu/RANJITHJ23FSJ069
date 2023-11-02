package BasicClosedLabbook;

public class LocationOfElementInTheArray {
	public static int  findIndex (int[] array, int t) {
        if (array == null) return -1;
        int len = array.length;
        int i = 0;
        while (i < len) {
            if (array[i] == t) return i;
            else i=i+1;
        }
        return -1;
    }
    public static void main(String[] args) {
      int[] array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
      System.out.println("Index position of 25 is: " + findIndex(array, 15));
      System.out.println("Index position of 77 is: " + findIndex(array, 77));
       }
}
