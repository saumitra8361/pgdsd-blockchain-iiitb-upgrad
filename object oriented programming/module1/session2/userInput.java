import java.util.Scanner;

class userInput {
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        int result;
        //Write your code here
        //You can import the scanner class as discussed in the videos
        Scanner input = new Scanner(System.in);

        //System.out.println("Enter value of a:");
        a=input.nextInt();
        //System.out.println("Enter value of b:");
        b=input.nextInt();
        //System.out.println("Enter value of c:");
        c=input.nextInt();
        result = (a*b)+c;
        System.out.println(result);
    }
}
