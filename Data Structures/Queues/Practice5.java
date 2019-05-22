/* Description
You are in charge of creating a communication service that supports two different channels: Emails and PushNotifications.
Your input is a stream of events, which contains the user and the event_type. In an e-commerce site, these events can be the various states of an order before it is delivered: Order Confirmed, Order Packed, Order Dispatched, Order Shipped, etc.
However, you do not wish to disturb your users at inappropriate hours, like at night, so your system gets events such as sendMails and sendPushNotifications, at appropriate times, when you send emails and push notifications to your users.

The difference between emails and push notifications is that emails need to be sent in the same order as the events were received, while the push notifications need to be sent in the opposite order so that users can first react to events which are closer to the deadline.

Thus, your Communication Service needs to store Event objects for emails and push notifications, and then process them accordingly to send them in the desired order.

An event is designated as follows:
Event: EventName_UserId_Channel , e.g.: Event1_User1_email

Example:
Input:
Event1_User1_push Event2_User1_push Event1_User1_email Event2_User1_email sendPushNotifications sendMails
Output:
Sent push notification to User1 for event Event2
Sent push notification to User1 for event Event1
Sent email to User1 for event Event1
Sent email to User1 for event Event2
*/

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Event {
    public String userId;
    public String eventType;

    public Event(String userId, String eventType) {
        this.userId = userId;
        this.eventType = eventType;
    }

    public void sendAsEmail() {
        System.out.println("Sent email to " + userId + " for event " + eventType);
    }

    public void sendAsPushNotification() {
        System.out.println("Sent push notification to " + userId + " for event " + eventType);
    }

}

public class Practice5 {

    static Stack<Event> pushNotificationStack = new Stack<Event>();
    static Queue<Event> emailQueue = new LinkedList<Event>();

    public static void storeEvent(Event event, String channel) {
        // Write code here
        if(channel.equals("push")){
            pushNotificationStack.add(event);
        } else {
            emailQueue.add(event);
        }
    }

    public static void sendEmails() {
        // Write code here
        while(!emailQueue.isEmpty()){
            emailQueue.remove().sendAsEmail();
        }
    }

    public static void sendPushNotifications() {
        // Write code here
        while(!pushNotificationStack.empty()){
            pushNotificationStack.pop().sendAsPushNotification();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String event_stream = scanner.nextLine();
        for (String event : event_stream.split(" ")) {
            String eventType = event.split("_")[0];
            switch (eventType) {
                case "sendMails":
                    sendEmails();
                    break;
                case "sendPushNotifications":
                    sendPushNotifications();
                    break;
                default:
                    String userId = event.split("_")[1];
                    String channel = event.split("_")[2];
                    storeEvent(new Event(userId, eventType), channel);
                    break;
            }
        }
    }
}

