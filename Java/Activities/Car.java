package Activities;

public class Car {

	public String color;
	public String transmission;
	public int make;
	public int tyres;
	public int doors;
	
	Car()
	{
		tyres=4;
		doors=4;
	}
	void displayCharacterstics()
	{
		System.out.println("Color of the Car: " + color);
		System.out.println("Make of the Car: " + make);
		System.out.println("Transmission of the Car: " + transmission);
		System.out.println("Number of doors on the car: " + doors);
	    System.out.println("Number of tyres on the car: " + tyres);
	}
	void accelerate()
	{
		System.out.println("Car is moving forward.");
	}
	void brake()
	{
		System.out.println("Car has stopped.");
	}
}
