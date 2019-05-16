public class Knapsack {
    public static void maximumValue(int knapsackSize, int[] weight, int[] value) {
        int nItems = weight.length;

        // matrix[i][j] defines the optimal solution with first i items and total knapsackSize j
        int[][] matrix = new int[nItems + 1][knapsackSize + 1];

        for (int i = 1; i <= nItems; i++) { // outer loop iterating through weights

            for (int j = 1; j <= knapsackSize; j++) {
                // check if the weight of current item i is less than or equal to the capacity of sack,
                // take maximum of once including the current item and once not including
                if (weight[i - 1] <= j) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], value[i - 1] + matrix[i - 1][j - weight[i - 1]]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        System.out.println("Maximum value possible : " + matrix[nItems][knapsackSize]);

        //int[] selected = new int[weight.length];
        int j = knapsackSize;
        int i = nItems;

        while (i > 0 && j > 0) {
            if (matrix[i][j] == matrix[i - 1][j]) {
                i--;
            } else {
                System.out.println("Selected item no. " + i + " of Weight: " + weight[i - 1]);
                //       selected[i - 1] = 1;
                j = j - weight[i - 1];
                i--;
            }
        }
        
        
   /*     System.out.print("\nItems with weight : ");

        for (i = 1; i < nItems + 1; i++) {
            
            if (selected[i - 1] == 1) {
                System.out.print(weight[i - 1] + " ");
                         }
        }
    */
    }


    public static void main(String[] args) {

        int knapsackSize = 23;
        int[] weights = {5, 7, 3, 8, 4, 3, 7, 5}, values = {12, 10, 9, 16, 14, 7, 14, 10};
        maximumValue(knapsackSize, weights, values);
    }

}
