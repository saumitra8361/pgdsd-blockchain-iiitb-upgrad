import java.lang.String;

public class FunctionReturn {

	public static void main(String[] args) 
      {
	    String var = test();  // if the function test should return something, it would be stored in this variable
	    System.out.print(var); // lets print var. Should print the value assigned by the function
	}

	public static String test(){
	   String variable = "Hello";  // define a variable that has a value 9
	   return variable;   // return this value when the function is called 
	}
}
