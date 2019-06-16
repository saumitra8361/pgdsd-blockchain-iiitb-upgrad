import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SymmetricPairHashMap {

    public static void main(String arg[]) {
        Scanner in = new Scanner(System.in);

        //number of pairs in the array
        int n = in.nextInt();
        int arr[][] = new int[n][2];

        // store the input pairs to an array "arr"
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        // Write your code here
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        boolean flag = false;
        int first=0, second=0;
        Integer data = 0;
        for(int i=0; i<n; i++){
            first = arr[i][0];
            second = arr[i][1];
            data = hashMap.get(second);

            if(data != null && data == first){
                System.out.println(second+" "+first);
                flag = true;
            } else {
                hashMap.put(first,second);
            }
        }
        if(!flag){
            System.out.println("No Symmetric pair");
        }
    }
}

