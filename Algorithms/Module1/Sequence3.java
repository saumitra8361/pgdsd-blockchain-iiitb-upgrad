import java.util.Scanner;
public class Sequence3 {

    public int fibonacci(int n) {
        int a = 0, b = 1, c = n;
        for (int i=2; i<=n; i++){
            c = (a + b)%10;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String args[]) {

        System.out.println("Enter the fibonacci number to be generated : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Sequence3 sequence = new Sequence3();
        int number = sequence.fibonacci(n);
        System.out.println("Fibonacci number: " + number);
    }
}
