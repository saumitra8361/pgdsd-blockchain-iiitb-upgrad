public class HelloFriend{
  public static void main(String[] args) {
          
	    printGreeting("Danny");  // inside the brackets, you pass a value
	}

	public static void printGreeting(String name) {   // the function reads the value passed and uses it. You also specify what kind of input the function is going to get.
      System.out.println("Hello " + name);            // variable name contains the string value that you passed into the function
	}
}

