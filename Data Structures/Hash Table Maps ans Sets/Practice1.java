import java.util.*;

public class Practice1 {
    public static void main(String[] args)
    {
        String[] emails = {"chandler.bing@xyz.com","ross.geller@xyz.com","rachel.greene@xyz.com","joey.tribbiani@xyz.com","monica.geller@xyz.com","phoebe.buffay@xyz.com","sheldon.copper@xyz.com","marie.george@xyz.com"};

        String NewEmail="monica.geller@xyz.com";

        boolean found = false;

        // Write your code here
        for(int i=0; i<emails.length; i++){
            if(NewEmail.equals(emails[i])){
                System.out.println(i);
                found = true;
                break;
            }
        }
        if(found == false){
            System.out.println(-1);
        }
    }
}
