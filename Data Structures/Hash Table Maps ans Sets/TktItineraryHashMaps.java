import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TktItineraryHashMaps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get the no of tickets from input
        int n = in.nextInt();

        // map to store all the tickets
        Map<String, String> tickets = new HashMap<String, String>();

        // Store the source and destination of the tickets to the map "tickets"
        for (int i = 0; i < n; i++) {
            tickets.put(in.next(), in.next());
            in.nextLine();
        }

        // write your code here
        Map<String, String> reverseMap = new HashMap<String, String>();
        String startCity = null;

        Set<String> keys = tickets.keySet();

        //formation of reverse hash map
        for (String city: keys) {
            reverseMap.put(tickets.get(city),city);
        }

        //finding the starting city in itinerary
        for (String str: keys) {
            if(reverseMap.get(str) == null){
                startCity = str;
            }
        }

        //printing the itinerary
        String temp = startCity;
        String result = "";
        while(temp != null){
            //System.out.print(temp+" ");
            result += temp+" ";
            temp = tickets.get(temp);
        }
        System.out.println(result);
    }
}
