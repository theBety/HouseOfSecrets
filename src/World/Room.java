package World;

import Entities.Entity;
import Items.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private boolean isLocked;
    private int password;
    private int roomId;
    private String name;
    private String[] availableRooms;
    private ArrayList<Item> itemsInRoom = new ArrayList<>();
    private ArrayList<Entity> entitiesInRoom = new ArrayList<>();
    private ArrayList<Task> tasksInRoom = new ArrayList<>();


    public Room(int roomId, String name, String[] availableRooms, boolean isLocked, int password) {
        this.roomId = roomId;
        this.name = name;
        this.availableRooms = availableRooms;
        this.isLocked = isLocked;
        this.password = password;
    }

    public Room() {
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public String[] getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(String[] availableRooms) {
        this.availableRooms = availableRooms;
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public void setItemsInRoom(ArrayList<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }

    public ArrayList<Entity> getEntitiesInRoom() {
        return entitiesInRoom;
    }

    public void setEntitiesInRoom(ArrayList<Entity> entitiesInRoom) {
        this.entitiesInRoom = entitiesInRoom;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "roomId: " + roomId +
                ", name: " + name +
                ", availableRooms: " + Arrays.toString(availableRooms) +
                ", itemsInRoom: " + itemsInRoom +
                ", entitiesInRoom: " + entitiesInRoom +
                "tasksInRoom=" + tasksInRoom +
                        '\n';
    }

    public ArrayList<Task> getTasksInRoom() {
        return tasksInRoom;
    }

    public void setTasksInRoom(ArrayList<Task> tasksInRoom) {
        this.tasksInRoom = tasksInRoom;
    }

    /*
        basement 1
        main hall 2
        living room 3
        kitchen 4
        dining room 5
        bathroom#1 6
        bathroom#2 7
        art gallery 8
        bedroom#1 9
        bedroom#2 0
         */
}
