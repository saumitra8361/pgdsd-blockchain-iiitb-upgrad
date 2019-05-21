import java.util.Objects;

/**
 * This class implements the queue for our ticket booking system.
 * The queue is central to storing the requests that have been received as
 * well as processing of the requests.
 * This class only stores a reference to the first element in the queue and
 * each element links to the it's next element.
 */
public class BookingRequestManager {

    private BookingRequest head;

    private int requestNumber;

    private int numberOfRequests;

    public BookingRequestManager() {
        // We have customized the default constructor to setup the queue variables required.
        this.head = null;
        // the requestNumber is initialized to 1 since the first request will have a number of 1.
        this.requestNumber = 1;
        this.numberOfRequests = 0;
    }

    /**
     * Adds a new booking request into the queue.
     *
     * @param request
     */
    public void addRequest(final BookingRequest request) {
        // This method implements queue traversal.
        if (Objects.isNull(this.head)) {
            this.head = request;
        } else {
            BookingRequest last = this.head;
            while (Objects.nonNull(last.getNextRequest())) {
                last = last.getNextRequest();
            }
            last.setNextRequest(request);
        }
        request.setRequestNumber(this.requestNumber++);
        this.numberOfRequests++;
    }

    /**
     * This method returns the current element in the queue (i.e. the "head" of the queue)
     * that is available for processing.
     *
     * @return
     */
    public BookingRequest getCurrentRequest() {
        return this.head;
    }

    /**
     * This method shifts the queue "forward" by one place. It does this by remapping the
     * "head" reference to the second element in our queue.
     */
    public void shift() {
        if (Objects.isNull(this.head)) {
            throw new NullPointerException("Cannot shift an empty request queue");
        }
        this.head = this.head.getNextRequest();
        this.numberOfRequests--;
    }

    /**
     * This method returns the current element in the queue for "processing".
     * It does this by retrieving the current element (i.e. the "head") and
     * "shifting" the queue by one place.
     *
     * @return
     */
    public BookingRequest processCurrentRequest() {
        BookingRequest currentRequest = this.getCurrentRequest();
        this.shift();
        return currentRequest;
    }

    /**
     * This method returns a boolean which indicates whether the queue has any
     * pending ticket request.
     * You should always call this method before trying to "shift" the queue forward.
     * Otherwise, you risk facing a NullPointerException.
     * <p>
     * The method simply checks if the "head" of the queue references a valid ticket booking
     * request or is set to null.
     *
     * @return
     */
    public boolean hasRequest() {
        return Objects.nonNull(this.head);
    }

    /**
     * Get the number of pending ticket booking requests.
     * This is the height of the queue that we are building.
     *
     * @return
     */
    public int getPendingRequests() {
        return this.numberOfRequests;
    }

}
