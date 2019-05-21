/**
 * This class performs the actions of processing BookingRequests from the
 * {@link BookingRequestManager}. It's only two rules are that all requests are processed in
 * the same order that they are received from the queue (FIFO) and a BookingRequest is granted
 * a booking only if all the requested tickets can be assigned. Otherwise the request is ignored
 * the next request is processed.
 *
 * The above process is repeated until there are no more requests in the queue.
 *
 * An object of this class is instantiated by the booking system.
 */
public class BookingAgent {

    private final int totalNumberOfTickets;

    private int currentTicket = 0;

    private final Booking[] tickets;

    private final BookingRequestManager bookingRequestManager;

    /**
     * The total number of tickets in the booking system.
     *
     * @param totalNumberOfTickets
     * @param tickets
     * @param bookingRequestManager
     */
    public BookingAgent(final int totalNumberOfTickets, final Booking[] tickets,
                        final BookingRequestManager bookingRequestManager) {
        this.totalNumberOfTickets = totalNumberOfTickets;
        this.currentTicket = 0;
        this.tickets = tickets;
        this.bookingRequestManager = bookingRequestManager;
    }

    /**
     * This method processes all the booking requests available in the queue ({@link BookingRequestManager})
     */
    public void processBookingRequests() {
        while(this.bookingRequestManager.hasRequest()) {
            BookingRequest currentRequest = this.bookingRequestManager.processCurrentRequest();
            if(currentRequest.getNumberOfTickets() <= (this.totalNumberOfTickets - this.currentTicket) ) {
                this.assignRequest(currentRequest);
                this.currentTicket = this.currentTicket + currentRequest.getNumberOfTickets();
            }
        }
    }

    private void assignRequest(final BookingRequest request) {
        final int numberOfTickets = request.getNumberOfTickets();
        final Booking booking = new Booking(request);
        for(int i = this.currentTicket; i < (this.currentTicket + numberOfTickets); i++) {
            tickets[i] = booking;
        }
    }
}
