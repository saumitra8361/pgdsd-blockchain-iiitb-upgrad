/**
 * An object of this class is created whenever the booking agent grants a booking request.
 * It holds information about a customer booking.
 */
public class Booking {

    private final BookingRequest request;

    private final int numberOfTickets;

    private final String customerName;

    /**
     * The constructor for the Booking only takes an object of {@link BookingRequest}
     * as a parameter and retrieves the information for the booking from the request object.
     * @param request
     */
    public Booking(final BookingRequest request) {
        this.request = request;
        this.numberOfTickets = request.getNumberOfTickets();
        this.customerName = request.getCustomerName();
    }

    /**
     * Returns the request number for which this booking was created.
     * @return
     */
    public int getRequestNumber() {
        return this.request.getRequestNumber();
    }

    /**
     * Returns the number of tickets that were granted.
     * This is always the same as the number of tickets requested, since the
     * booking agent only grants those booking requests which can be fully assigned tickets.
     * @return
     */
    public int getNumberOfTickets() {
        return this.numberOfTickets;
    }

    /**
     * Returns the customer name for this booking.
     * @return
     */
    public String getCustomerName() {
        return this.customerName;
    }

}
