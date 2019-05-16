/*
*
Description
Write the code for this problem given an initialised array.

Sample Input:
No input required

Output:
0123
1123
2223
3333
*
*/


public class TwoDMatrix {
    public static void main(String args[])
    {

        int matrix[][];
        matrix = new int[4][4];

        int i,j;

        /* Updating first column */
        for (i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
        }

        /* Updating first row */
        for (j=0; j< matrix[0].length; j++) {
            matrix[0][j] = j;
        }

      	/* Write your loop here to update the above matrix such that
      	each cell is max of its neighbouring cell.
      	Store your results in the matrix itself*/
      	for(i=1;i<matrix.length;i++){
      	    for(j=1;j<matrix[0].length; j++){
      	        matrix[i][j] = max(matrix[i-1][j],matrix[i][j-1]);
            }
        }

        /* Printing 2D matrix. Don't change the code below*/
        for (i = 0; i < matrix.length; i++){
            for (j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j]);
            System.out.print('\n');
        }
    }

    private static int max(int matrix, int matrix1) {
        int max=0;
        max = (matrix > matrix1 ? matrix : matrix1);
        return max;
    }
}

