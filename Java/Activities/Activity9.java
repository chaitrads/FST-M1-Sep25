package Activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
	
		ArrayList <String> myList=  new ArrayList<String>();
		myList.add("Liya");
		myList.add("Loki");
		myList.add("Chaitra");
		myList.add("Autharva");
		myList.add("Suja");
		
		for(String names:myList)
		{
			System.out.println(names);
		}
		System.out.println(myList.get(2));
		System.out.println(myList.size());
		System.out.println(myList.contains("Chaitra"));
		System.out.println(myList.remove(4));
		System.out.println(myList.size());

	}

}
