import java.util.LinkedList;
import java.util.Queue;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Guest: " + guestName + ", Requested Room: " + roomType);
    }
}

class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
    }

    public Reservation processNextRequest() {
        return requestQueue.poll(); // returns null if empty
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }

    public void displayQueue() {
        System.out.println("Current Booking Requests in Queue:");
        if (requestQueue.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            for (Reservation r : requestQueue) {
                r.displayReservation();
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Alice", "Standard Room"));
        queue.addRequest(new Reservation("Bob", "Family Room"));
        queue.addRequest(new Reservation("Charlie", "Luxury Suite"));
        queue.addRequest(new Reservation("David", "Standard Room"));

        queue.displayQueue();

        System.out.println("Processing requests in FIFO order:\n");
        while (queue.hasPendingRequests()) {
            Reservation r = queue.processNextRequest();
            System.out.println("Processing Reservation:");
            r.displayReservation();
            System.out.println();
        }

        queue.displayQueue(); // should show empty queue
    }
}
