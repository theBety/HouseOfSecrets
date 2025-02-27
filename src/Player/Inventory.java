package Player;
import Items.Item;
import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> inventory = new ArrayList<>();

    public Inventory() {
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
