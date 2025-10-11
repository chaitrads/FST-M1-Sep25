package Activities;

import java.util.Arrays;

public class Activity4 {
	  static void ascendingSort(int array[]) {
	        int size = array.length, i;
	        
	        for (i = 1; i < size; i++) {
	            int key = array[i];
	            int j = i - 1;
	            
	            while (j >= 0 && key < array[j]) {
	                array[j + 1] = array[j];
	                --j;
	            }
	            array[j + 1] = key;
	        }
	    }

	public static void main(String[]args)
	{
		int [] data= {5,65,33,4,65,22,67,2,90,43,1,99,0};
		 ascendingSort(data);
		System.out.println("Before sorting" + Arrays.toString(data));
		Arrays.sort(data);
		System.out.println("After sorting" + Arrays.toString(data));
	}
}
