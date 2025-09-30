package java;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();
    public void showInventory() {
        // Print inventory
    }
    public void addItem(Item item) { items.add(item); }
    // Methods for removing, using, equipping items, etc.
}