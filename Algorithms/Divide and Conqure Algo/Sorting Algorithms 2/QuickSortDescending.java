import java.util.Random;
import java.util.Arrays;
import java.util.Random;


public class QuickSortDescending {
    //Write your code here
    public static void main(String args[]){
        int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        quickSort(array,0,array.length-1);
        printArray(array);
    }

    public static void quickSort(int array[], int first, int last){
        if (first<last){
            int p = partitionArray(array,first,last);
            quickSort(array,first,p-1);
            quickSort(array,p+1,last);
        }
    }

    public static int partitionArray(int[] ar, int start, int end) {
        int pivot = ar[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (ar[j] >= pivot) {
                int temp1 = ar[j];
                ar[j] = ar[i];
                ar[i] = temp1;
                i++;
            }
        }
        int temp2 = ar[i];
        ar[i] = ar[end];
        ar[end] = temp2;

        return i;
    }

    public static void printArray(int array[]){
        for (int element: array){
            System.out.println(element);
        }
    }
}

