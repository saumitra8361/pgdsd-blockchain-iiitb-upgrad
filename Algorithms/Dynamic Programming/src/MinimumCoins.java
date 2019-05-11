// backtracking. 
public class MinimumCoins {

    public static int minCoins(int d[], int amount) {
        // array to store the min no. of coins required to make a change
        // for each index 0...amount
        int[] coinsReq = new int[amount + 1];
        int amt, i, j;
        
        for (i = 0; i <= amount; i++) {
            coinsReq[i] = i;

        }
        for (j = 1; j < d.length; j++) {
            for (i = 1; i <= amount; i++) {

                if (i >= d[j] && (coinsReq[i - d[j]] + 1) < coinsReq[i])
                    coinsReq[i] = coinsReq[i - d[j]] + 1;
            }
        }

        return coinsReq[amount];
    }

    public static void main(String[] args) {
        int coinValues[] = {1, 7, 10};
        int amount = 14;
        int min = minCoins(coinValues, amount);
        System.out.print("Minimum no. of coins required is " + min);
    }

}

