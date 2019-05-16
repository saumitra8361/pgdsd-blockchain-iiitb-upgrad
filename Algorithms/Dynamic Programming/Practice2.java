/*
* Write the code such that given the destination in terms of the x and y coordinates, your code prints the minimum cost to reach the destination.
* */
import java.util.Scanner;

public class Practice2 {

    private static int minCost(int cost[][], int m, int n)
    {
        int minCost[][]=new int[m+1][n+1];
        int temp=0, minimum=0;
        /* Initialise the first column of the minimum cost (table) array */
        for (int j = 0; j <= n; j++) {
            temp = temp + cost[0][j];
            minCost[0][j] = temp;
        }

        temp=0;
        /* Initialise the first row of the table array */
        for (int i = 0; i <= m; i++) {
            temp = temp + cost[i][0];
            minCost[i][0] = temp;
        }

        /* Construct the rest of the table array from the recursion relation */
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // check if the cost to reach destination is least among all possible ways
                minimum = ((minCost[i-1][j] + cost[i][j]) > (minCost[i][j-1] + cost[i][j]) ? (minCost[i][j-1] + cost[i][j]) : (minCost[i-1][j] + cost[i][j]));
                System.out.println("(minCost[i-1][j] + cost[i][j]): "+(minCost[i-1][j] + cost[i][j]));
                System.out.println("(minCost[i][j-1] + cost[i][j]): "+(minCost[i][j-1] + cost[i][j]));
                System.out.println("minimum: "+minimum);
                minCost[i][j] = ((minCost[i-1][j-1] + cost[i][j]) > minimum ? minimum : (minCost[i-1][j-1] + cost[i][j]));
                System.out.println("(minCost[i-1][j-1] + cost[i][j]): "+(minCost[i-1][j-1] + cost[i][j]));
                System.out.println("i:"+i+" j:"+j+" min cost:"+minCost[i][j]);
            }
        }

        //print minCost 2D array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(minCost[i][j] + " ");
            }
            System.out.println("");
        }

        return minCost[m][n];
    }

    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        Scanner scan = new Scanner(System.in);
        int xCoordinate = scan.nextInt();
        int yCoordinate = scan.nextInt();
        System.out.println(minCost(cost,xCoordinate,yCoordinate));
    }
}