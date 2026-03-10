import java.util.HashMap;

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
        System.out.println(type + ":");
        System.out.println("Beds: " + bedCount);
        System.out.println("Size: " + area + " sq ft");
        System.out.println("Price: Rs " + cost);
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

class RoomInventory {
    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Standard Room", 5);
        inventory.put("Family Room", 3);
        inventory.put("Luxury Suite", 0); 
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

class SearchService {
    private RoomInventory inventory;
    private Room[] rooms;

    public SearchService(RoomInventory inventory, Room[] rooms) {
        this.inventory = inventory;
        this.rooms = rooms;
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:\n");
        for (Room room : rooms) {
            if (inventory.getAvailability(room.type) > 0) {
                room.showDetails();
                System.out.println("Rooms Available: " + inventory.getAvailability(room.type));
                System.out.println();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room[] rooms = { new StandardRoom(), new FamilyRoom(), new LuxurySuite() };

        SearchService searchService = new SearchService(inventory, rooms);

        searchService.displayAvailableRooms();
    }
}
