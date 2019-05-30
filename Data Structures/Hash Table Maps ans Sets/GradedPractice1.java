import java.util.*;
public class GradedPractice1{
    //Method to print distinct values
    public static void printValues(Map<Integer,String> map){
        //Write your code here
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        Set<Integer> keys = map.keySet();
        int i=0;
        for (Integer key: keys) {
            hashMap.put(map.get(key),i);
            i++;
        }
        Set<String> k = hashMap.keySet();
        for (String key: k) {
            System.out.print(key+" ");
        }
    }

    public static void main(String[] x){
        Map<Integer,String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int key;
        String value;
        for(int i = 1; i <= num; i++){
            key = sc.nextInt();
            value = sc.next();
            map.put(key,value);
        }
        printValues(map);
    }
}
