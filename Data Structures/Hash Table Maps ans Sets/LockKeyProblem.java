/* Match Locks and Keys
Description
You will be given the array of locks and keys.
Write the pseudocode to print the key and its corresponding lock in the order of the keys present in the array.
If any lock corresponding to the key is not present, then print ‘Not possible’ and return.
Note:
You should not compare any lock with any other lock; similarly, you should not compare any key with any other key.
The size of the array of locks and keys is the same.

Input: The input will be in the following format:
The first line will be ‘n’ indicating the size of the array of keys.
The next line will be ‘n’ space-separated characters indicating keys.
THe next line will be ‘n’ space-separated characters indicating locks.


Output: The output should be in the following format:
Print each key and its corresponding lock separated by space, in a new line, in the same order of keys.
If any of the lock corresponding to the key is not present, then print ‘Not possible’.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LockKeyProblem {

    public static void main(String arg[]) {
        Scanner in = new Scanner(System.in);

        // get the number of keys
        int n = in.nextInt();

        char keys[] = new char[n];
        char locks[] = new char[n];

        // store all the keys to the array "keys"
        for (int i = 0; i < n; i++) {
            keys[i] = in.next(".").charAt(0);
        }
        in.nextLine();

        //store all the locks to the array "locks"
        for (int i = 0; i < n; i++) {
            locks[i] = in.next(".").charAt(0);
        }

        //write your code here
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(int i=0; i<n; i++){
            hashMap.put(locks[i],i);
        }

        for(int i=0; i<n; i++){
            if(hashMap.containsKey(keys[i])){
                locks[i] = keys[i];
            }
            else {
                System.out.println("Not possible");
                System.exit(0);
            }
        }

        for(int i=0; i<n; i++){
            System.out.println(keys[i]+" "+locks[i]);
        }
    }
}

