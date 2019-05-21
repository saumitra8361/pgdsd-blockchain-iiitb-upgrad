/**
 * The BookingRequest is created whenever the booking system receives a new request
 * for a ticket. This class holds the information about the request. The demonstration
 * limits this information to
 *      1. requestNumber
 *      2. numberOfTickets
 *      3. customerName
 *
 * Finally, this class is also crucial to our implementation of a queue since it forms the
 * node for our queue and holds a reference to the next element in the queue.
 */
public class BookingRequest {

    private int requestNumber;

    private final int numberOfTickets;

    private final String customerName;

    private BookingRequest nextRequest;

    /**
     * Creates a new booking request.
     * The requestNumber and nextRequest are respectively, set and updated, by the {@link BookingRequestManager}
     *
     * @param numberOfTickets
     * @param customerName
     */
    public BookingRequest(final int numberOfTickets, final String customerName) {
        this.numberOfTickets = numberOfTickets;
        this.customerName = customerName;
        this.nextRequest = null;
    }

    /**
     * returns the requestNumber for this request.
     * @return
     */
    public int getRequestNumber() {
        return requestNumber;
    }

    /**
     * sets the requestNumber for this request.
     * @param requestNumber
     */
    public void setRequestNumber(final int requestNumber) {
        this.requestNumber = requestNumber;
    }

    /**
     * Returns the numberOfTickets requested in this request.
     * @return
     */
    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    /**
     * returns the name of the customer that created this request.
     * @return
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * returns the nextRequest in the request queue.
     * @return
     */
    public BookingRequest getNextRequest() {
        return nextRequest;
    }

    /**
     * sets the nextRequest in the request queue.
     * @param nextRequest
     */
    public void setNextRequest(final BookingRequest nextRequest) {
        this.nextRequest = nextRequest;
    }
}
