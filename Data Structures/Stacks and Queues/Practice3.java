/*
* Given a sequence S1, check if it exists in another sequence S2.
* Assume that all the elements are distinct in both the sequences.
* Sequence S1 exists in sequence S2 if all the elements of S1 appear in S2 and their relative ordering is the same,
* which means that there may be elements in the middle of two elements in S2, which are adjacent in S1.
*/

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Practice3 {

    public static Boolean contains(Stack<Integer> sequence1, Stack<Integer> sequence2) {
        // This block will be filled by the student
        Iterator value = sequence1.iterator();
        int size = sequence1.size();
        int[] positionArray1 = new int[size];
        int[] positionArray2 = new int[size];
        int count = 0, element = 0;

        while (value.hasNext()) {
            element = (int) value.next();
            if(sequence2.search(element) == -1){
                return false;
            }
            positionArray2[count] = sequence2.search(element);
            count++;
        }

        for(int i=0; i<size-1; i++){
            if(positionArray2[i]<positionArray2[i+1]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        Stack<Integer> sequence1 = new Stack<Integer>();
        Stack<Integer> sequence2 = new Stack<Integer>();
        int boxIndex = 0;
        for (String elem1 : line1.split(" ")) {
            sequence1.add(Integer.parseInt(elem1));
        }
        for (String elem2 : line2.split(" ")) {
            sequence2.add(Integer.parseInt(elem2));
        }
        Boolean isSubsequence = contains(sequence1, sequence2);
        System.out.println(isSubsequence);
    }
}
