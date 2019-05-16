public class ReturnFunction {

	public static void main(String[] args) {
		int var = test(); // Store function return in this variable
		System.out.print(var); // print the value returned by function test
	}

	public static int test() { // specify data type of return value
		
		int variable = 9; // define a variable that has a value 9
		return variable; // return this value when the function is called
	}
}
