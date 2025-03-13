package Player;

import Items.Item;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();
    private int coins = 0;

    public Inventory() {
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

    @Override
    public String toString() {
        return "Inventory: " + inventory + ", coins: " + coins;
    }
}
