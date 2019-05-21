/**
 * The BookingSystem is responsible for setting up all the different components of the
 * ticket booking system demonstration.
 * <p>
 * The most important of these systems is the {@link BookingRequestManager} and the
 * {@link BookingAgent}. The objects of these classes are analogous to a "queue" and a
 * "worker". The BookingSystem could be thought of as analogous to a user process which
 * offloads "work" to the "worker" via the "queue".
 * <p>
 * The BookingSystem object also
 * holds the total number of tickets available in our system as well as the ticket allocation array.
 */
public class BookingSystem {

    private final int totalNumberOfTickets;

    private final Booking[] tickets;

    private final BookingRequestManager bookingRequestManager;

    private final BookingAgent agent;

    /**
     * The BookingSystem must be initialized with a total number of available tickets.
     *
     * @param totalNumberOfTickets
     */
    public BookingSystem(final int totalNumberOfTickets) {
        this.totalNumberOfTickets = totalNumberOfTickets;
        this.tickets = new Booking[totalNumberOfTickets];
        this.bookingRequestManager = new BookingRequestManager();
        this.agent = new BookingAgent(this.totalNumberOfTickets, this.tickets, this.bookingRequestManager);
    }

    /**
     * Create a request for a ticket in the system.
     *
     * @param numberOfTickets
     * @param customerName
     */
    public void requestTickets(final int numberOfTickets, final String customerName) {
        final BookingRequest request = new BookingRequest(numberOfTickets, customerName);
        this.bookingRequestManager.addRequest(request);
    }

    /**
     * Process all pending ticket booking requests.
     *
     * @return
     */
    public Booking[] processBookingRequests() {
        this.agent.processBookingRequests();
        return this.tickets;
    }

    /**
     * Get the number of pending ticket booking requests.
     * This is the height of the queue that we are building.
     *
     * @return
     */
    public int getPendingRequests() {
        return this.bookingRequestManager.getPendingRequests();
    }
}
