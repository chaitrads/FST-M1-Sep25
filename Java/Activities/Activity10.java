package Activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
	
		HashSet<String> hs = new HashSet<String> ();
		
		
		hs.add("Liya");
		hs.add("Loki");
		hs.add("Chaitra");
		hs.add("Atharva");
		hs.add("Suja");
		hs.add("apple");
		hs.add("Orange");
		
		for(String set:hs)
		{
			System.out.println(set);
		}
		
		System.out.println(hs.size());
		System.out.println(hs.remove("Atharva"));
		System.out.println(hs.remove("Lokibdf"));
		System.out.println(hs.contains("Liya"));
		System.out.println(hs.size());
		
	}

}
