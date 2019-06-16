import java.util.*;

public class ContiguousIntegersArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        if(n==0){
            System.out.println("false");
            System.exit(0);
        }

        //array to store the input elements
        int[] array = new int[n];

        //storing the elements to the array
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        // Write your code here
        HashSet<Integer> hashSet = new HashSet<>();
        int count=0;
        for(int j=0; j<n; j++){
            hashSet.add(array[j]);
        }
        int value = array[0];
        while(hashSet.contains(value)){
            count++;
            value--;
        }
        value = array[0]+1;
        while(hashSet.contains(value)){
            count++;
            value++;
        }
        if(count==hashSet.size())
            System.out.println("true");
        else
            System.out.println("false");
    }
}

