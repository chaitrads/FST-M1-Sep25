package Activities;

public abstract class Book {
	 String title;
	 
	  abstract void setTitle(String s);
	
	  public String getTitle()
	  {
		  return title;
	  }
}
	  
class MyBook extends Book
{
	void setTitle(String s)
	{
		title=s;
	}
}




