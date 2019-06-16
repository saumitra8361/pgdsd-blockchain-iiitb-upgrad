import java.util.HashSet;
import java.util.Scanner;

public class PairWithTheGivenSum
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);

        // number of the elements
        int n = in.nextInt();

        int array[] = new int[n];

        //storing the input integers to an array
        for(int i =0;i<n;i++){
            array[i] = in.nextInt();
        }

        // getting the target sum from input
        int targetSum = in.nextInt();

        //write your code here
        HashSet<Integer> hashSet = new HashSet<>();
        int diff = 0;
        boolean result = false;

        for(int j=0; j<n; j++){
            diff = targetSum - array[j];
            if(hashSet.contains(diff))
                result = true;
            else
                hashSet.add(array[j]);
        }

        System.out.println(result);
    }
}

