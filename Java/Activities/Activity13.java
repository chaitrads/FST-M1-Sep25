import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random indexGen = new Random();
		Scanner number = new Scanner(System.in);
		System.out.println("Enter Integer Values");
		System.out.println("Enter Non integer values to terminate");
		
		while(number.hasNextInt()) {
		    list.add(number.nextInt());
		}
		
		Integer nums[] = list.toArray(new Integer[0]);
		int index = indexGen.nextInt(nums.length);
		
		System.out.println("Index value generated: " + index);
        System.out.println("Value in arary at generated index: " + nums[index]);
 
        number.close();
		
	}

}
