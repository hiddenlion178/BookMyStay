abstract class Room {

    protected String type;
    protected int bedCount;
    protected int area;
    protected double cost;

    public Room(String type, int bedCount, int area, double cost) {
        this.type = type;
        this.bedCount = bedCount;
        this.area = area;
        this.cost = cost;
    }

    public void showDetails() {
        System.out.println("\nRoom Type : " + type);
        System.out.println("Beds      : " + bedCount);
        System.out.println("Area      : " + area + " sq ft");
        System.out.println("Cost      : Rs." + cost + " per night");
    }

    public void showAvailability(int available) {
        System.out.println("Available Rooms : " + available);
    }
}

class StandardRoom extends Room {

    public StandardRoom() {
        super("Standard Room", 1, 210, 1300.0);
    }
}

class FamilyRoom extends Room {

    public FamilyRoom() {
        super("Family Room", 2, 360, 2400.0);
    }
}

class LuxurySuite extends Room {

    public LuxurySuite() {
        super("Luxury Suite", 3, 700, 4800.0);
    }
}

public class HotelBooking {

    public static void main(String[] args) {

        int standardAvailable = 5;
        int familyAvailable = 3;
        int luxuryAvailable = 2;

        Room r1 = new StandardRoom();
        Room r2 = new FamilyRoom();
        Room r3 = new LuxurySuite();

        System.out.println(" Hotel Room Details ");

        displayRoomInfo(r1, standardAvailable);
        displayRoomInfo(r2, familyAvailable);
        displayRoomInfo(r3, luxuryAvailable);
    }

    public static void displayRoomInfo(Room room, int available) {
        room.showDetails();
        room.showAvailability(available);
    }
}
