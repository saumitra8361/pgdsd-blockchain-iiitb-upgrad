public class StringLibrary {

	 public static void main(String[] args) {
	
	 String string1 = "hero";  
	 
	 int stringLength = string1.length(); // FINDING LENGTH
	 
     boolean compare1;
     boolean compare2;


     compare1 = string1.equals("Hero");  // COMPARING STRINGS
     System.out.println(compare1);

     compare2 = string1.equalsIgnoreCase("Hero"); // IGNORING CASE DIFFERENCE WHILE COMPARING
     System.out.println(compare2);
	 
	 
	 string1 = "Firstname";
	 String string2 = "Secondname";
	 String string3 = string1.concat(string2); // CONCATENATING
	 System.out.println(string3);
	}
}