
public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Addable ad1 = (a,b)->(a+b);
		
		System.out.println(ad1.add(204,806));
		
		Addable ad2 = (int a,int b) ->{
			return (a+b);
		};
		
		System.out.println(ad2.add(333,222));
		

	}
@FunctionalInterface 
	 interface Addable{
		public int add(int num1,int num2);
	}
}
