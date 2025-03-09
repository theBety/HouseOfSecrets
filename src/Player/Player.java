package Player;
import Items.Item;
import World.Room;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private HashMap<Integer, Room> roomsInGame = new HashMap<>();
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

    public HashMap<Integer, Room> getRoomsInGame() {
        return roomsInGame;
    }

    public void setRoomsInGame(HashMap<Integer, Room> roomsInGame) {
        this.roomsInGame = roomsInGame;
    }

    public Room setStart(){
        currentPosition = roomsInGame.get(1);
        return currentPosition;
    }

    @Override
    public String toString() {
        return "Player{" +
                "inventory=" + inventory +
                ", roomsInGame=" + roomsInGame +
                ", currentPosition=" + currentPosition +
                ", coins=" + coins +
                '}';
    }
}
