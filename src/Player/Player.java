package Player;

import Items.Item;
import World.Room;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private HashMap<String, Integer> weapons = new HashMap<>();
    private HashMap<Integer, Room> roomsInGame = new HashMap<>();
    private Room currentPosition;
    private int coins = 0;
    private boolean gameOver = false;

    public Player() {
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    //region Set&Get
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

    public void setStart() {
        setCurrentPosition(roomsInGame.get(1));
    }

    public HashMap<String, Integer> getWeapons() {
        return weapons;
    }

    public void setWeapons(HashMap<String, Integer> weapons) {
        this.weapons = weapons;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    //endregion

    @Override
    public String toString() {
        return "Inventory: " + inventory + ", coins: " + coins;
    }
}
