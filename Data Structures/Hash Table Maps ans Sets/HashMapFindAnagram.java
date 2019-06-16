import java.util.*;
public class HashMapFindAnagram {
    //Method to check if two strings are anagram of each other or not
    public static boolean check(String str1, String str2){
        int count=0;
        char[] ch1 = str1.toLowerCase().toCharArray();
        char[] ch2 = str2.toLowerCase().toCharArray();
        //Write your code here
        arrange(ch1);
        arrange(ch2);
        for(int i=0; i<ch1.length; i++){
            if(ch1[i] == ch2[i]){
                count++;
            }
        }
        if(count == ch1.length){
            return true;
        }
        return false;
    }

    //Method to sort the character array
    public static void arrange(char[] ch){
        //Write your code here
        Arrays.sort(ch);
    }

    public static void main(String[] x){
        Map<String,String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String key;
        String value;
        int count=0;
        for(int i = 1; i <= num; i++){
            key = sc.next();
            value = sc.next();
            map.put(key,value);
        }
        //Write your code here
        Set<String> keys = map.keySet();
        for (String k: keys) {
            if(check(k,map.get(k)))
                System.out.println(k+" : "+map.get(k));
            else
                count++;
        }
        if(count == map.size()){
            System.out.println("false");
        }
    }
}

