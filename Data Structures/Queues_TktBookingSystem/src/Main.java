import java.util.Objects;

/**
 * Main class which will demonstrate a ticket booking system that uses a queue to process ticket
 * requests using the {@link BookingSystem} and {@link BookingRequestManager} classes
 */
public class Main {

    /**
     * starting point for our ticket booking system demonstration.
     *
     * @param args
     */
    public static void main(String args[]) {
        // intialises the booking system for a total of 10 tickets.
        final BookingSystem bookingSystem = new BookingSystem(10);

        // Try to make a booking for 20 tickets. This entire booking request will be rejected since
        // the total number of available tickets is 10.
        bookingSystem.requestTickets(20, "Luke");
        // Add ticket requests.
        bookingSystem.requestTickets(2, "Foo");
        bookingSystem.requestTickets(2, "Bar");
        bookingSystem.requestTickets(3, "John Doe");
        bookingSystem.requestTickets(2, "Jane Doe");
        // This request will be rejected, since it cannot be fully granted.
        // Only 1 ticket is available at this point, and this request is for 2 tickets.
        bookingSystem.requestTickets(2, "Upgrad");

        // Print the total number of requests to process.
        System.out.println("Total number of requests to process: " + bookingSystem.getPendingRequests());

        // intitiate ticket request processing.
        Booking[] tickets = bookingSystem.processBookingRequests();

        // print the ticket allotment chart.
        Main.printTicketAllotment(tickets);

        // print the number of remaining requests.
        System.out.println("Remaining requests: " + bookingSystem.getPendingRequests());

        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");

        // add a last minute request to the system.
        bookingSystem.requestTickets(1, "Linus");

        // Print the total number of requests to process.
        System.out.println("Total number of requests to process: " + bookingSystem.getPendingRequests());

        // initiate ticket request processing.
        tickets = bookingSystem.processBookingRequests();

        // print the ticket allotment chart.
        Main.printTicketAllotment(tickets);

        // print the number of remaining requests.
        System.out.println("Remaining requests: " + bookingSystem.getPendingRequests());

    }

    /**
     * Helper function to pretty print the tickets in a chart.
     *
     * @param tickets
     */
    private static void printTicketAllotment(final Booking[] tickets) {
        System.out.format("| Ticket Number | Request Number | %-32s |%n", "Customer Name");
        System.out.println("| ------------- | -------------- | -------------------------------- |");
        for (int i = 0; i < tickets.length; i++) {
            String ticketNumber = Integer.toString((i + 1));
            String requestNumber = "";
            String customerName = "";
            if (Objects.nonNull(tickets[i])) {
                requestNumber = Integer.toString(tickets[i].getRequestNumber());
                customerName = tickets[i].getCustomerName();
            }
            System.out.format("| %-13s | %-14s | %-32s |%n", ticketNumber, requestNumber, customerName);
        }
    }
}
