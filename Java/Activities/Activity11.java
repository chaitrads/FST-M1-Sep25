package Activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		HashMap<Integer, String> hs1 = new HashMap<Integer, String> ();
		hs1.put(1, "Ornage");
		hs1.put(2, "Blue");
		hs1.put(3, "Pink");
		hs1.put(4, "Black");
		hs1.put(5, "Peach");
		
		System.out.println(hs1);
		
		System.out.println(hs1.remove(3));
		System.out.println(hs1.containsKey("green"));
		System.out.println(hs1.size());
		

	}

}
