package Player;
import Items.Item;
import World.Room;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Room currentPosition;
    private int coins = 0;

    public Player() {
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins += coins;
    }

    public Room getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Room currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "player=" + inventory +
                ", currentPosition=" + currentPosition +
                ", coins=" + coins +
                '}';
    }
}
