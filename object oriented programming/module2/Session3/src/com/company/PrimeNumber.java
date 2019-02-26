import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {

		int num;
		System.out.println("Enter the number you wish to check : ");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		System.out.println(prime(num));

	}

	public static String prime(int num) {
		boolean primecheck = true;
		String result;
		System.out.println(Math.sqrt(num));
		for (int i = 2; i <= Math.sqrt(num); i++) {
			// condition for nonprime number
			if (num % i == 0) {

				primecheck = false;
				break;
			}
		}

		if (primecheck == true) {
			result = "Prime";
		} else {
			result = "Not a prime";
		}
		return result;
	}
}