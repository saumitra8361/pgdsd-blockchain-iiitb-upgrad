import java.util.Scanner;
public class HelloAdvanced {
    public static void main(String[] args) {

        System.out.println("Whom would you like to say hello to?  ");
        Scanner scan = new Scanner(System.in);
        String name;
        name = scan.next();
        printGreeting(name);  // if the function should return something, it would be stored in this variable
    }

    public static void printGreeting(String name) {
        System.out.println("Hello " + name);
    }
}