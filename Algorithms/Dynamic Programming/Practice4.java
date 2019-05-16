import java.util.Scanner;
public class Practice4 {
    public static int count(int[] d, int amount) {

        int[][] V = new int[amount + 1][d.length + 1];

        /* Write down the base solution*/
        for (int j = 0; j <= d.length; j++) {
            V[0][j] = 1;
        }

        // if you are supposed to use the first coin only then you there is only one way of paying for any amount, as first coin has value 1
        for (int i = 0; i <= amount; i++) {
            V[i][0] = 1;
        }

        /* Fill in the rest of the matrix using recursion relation */
        for (int i = 1; i <= amount; i++) {
            System.out.println("Ith Iteration: "+i);
            for (int j = 1; j <= d.length; j++) {
                System.out.println("Jth Iteration: "+j);

                // check if the coin value is less than the amount needed
                if (d[j - 1] <= i) {
                    System.out.println("d[j-1]: "+d[j-1]);
                    System.out.println("V[i][j - 1]: "+V[i][j - 1]);
                    System.out.println("V[i - d[j - 1]][j]: "+V[i - d[j - 1]][j]);
                    V[i][j] = V[i][j - 1] + V[i - d[j - 1]][j];
                    System.out.println("IF: V[i][j]: "+V[i][j]);
                } else {
                    V[i][j] = V[i][j - 1];
                    System.out.println("ELSE: V[i][j]: "+V[i][j]);
                }
            }
        }

        return V[amount][d.length-1];
    }

    public static void main(String args[]) {
        int[] d = {1,2,4};
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        System.out.println(count(d, amount));
        scan.close();
    }
}
