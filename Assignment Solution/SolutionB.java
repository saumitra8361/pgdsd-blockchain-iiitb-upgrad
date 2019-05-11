import java.util.Scanner;

public class SolutionB {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int key = scanner.nextInt();
        int[] array = new int[size+1];
        int i=1;

        while(i<size+1 && scanner.hasNext()) {
            array[i] = scanner.nextInt();
            i++;
        }

        SolutionB object = new SolutionB();
        object.Search(array, key, size);
    }

    public void Search(int[] inputArr, int key, int size) {

        int start = 1;
        int end = size;
        boolean success = false;
        int index = 0;
        try {
            while (start <= end) {
                int mid = start + ((end - start) / 2);
                if (key == inputArr[mid]) {
                    success = true;
                    index = mid;
                    break;
                }
                if (key < inputArr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("The index you have entered is invalid");
        }

        if(success == true)
            System.out.println(index);
        else
            System.out.println("NOT_FOUND");
    }
}

