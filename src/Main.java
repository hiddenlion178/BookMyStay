import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Standard Room", 5);
        inventory.put("Family Room", 3);
        inventory.put("Luxury Suite", 2);
    }

    public int getAvailability(String roomType) {
        if (inventory.containsKey(roomType)) {
            return inventory.get(roomType);
        }
        return 0;
    }

    public void updateAvailability(String roomType, int newCount) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newCount);
        }
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (String room : inventory.keySet()) {
            System.out.println(room + " : " + inventory.get(room));
        }
    }
}

public class Main {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();

        System.out.println();

        System.out.println("Standard Room Available: " +
                inventory.getAvailability("Standard Room"));

        inventory.updateAvailability("Standard Room", 4);

        System.out.println("\nAfter Update:");
        inventory.displayInventory();
    }
}
