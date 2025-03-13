package World;

import Entities.Entity;
import Items.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private boolean isLocked;
    private int passwordToNextRoom;
    private String passwordInfo;
    private int roomId;
    private String name;
    private String[] availableRooms;
    private ArrayList<Item> itemsInRoom = new ArrayList<>();
    private Entity entityInRoom = new Entity();
    private ArrayList<Task> tasksInRoom = new ArrayList<>();


    public Room(int roomId, String name, String[] availableRooms, boolean isLocked, int passwordToNextRoom, String passwordInfo) {
        this.roomId = roomId;
        this.name = name;
        this.availableRooms = availableRooms;
        this.isLocked = isLocked;
        this.passwordToNextRoom = passwordToNextRoom;
        this.passwordInfo = passwordInfo;
    }

    public Room() {
    }

    //region Set&Get
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

    public Entity getEntityInRoom() {
        return entityInRoom;
    }

    public void setEntityInRoom(Entity entityInRoom) {
        this.entityInRoom = entityInRoom;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getPasswordToNextRoom() {
        return passwordToNextRoom;
    }

    public void setPasswordToNextRoom(int passwordToNextRoom) {
        this.passwordToNextRoom = passwordToNextRoom;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion

    @Override
    public String toString() {
        return
                "Room id: " + roomId + ", name: " + name + ", available rooms: " + Arrays.toString(availableRooms) + ", items InRoom: " + itemsInRoom +
                        "tasksInRoom; " + tasksInRoom + '\n';
    }

    public ArrayList<Task> getTasksInRoom() {
        return tasksInRoom;
    }

    public void setTasksInRoom(ArrayList<Task> tasksInRoom) {
        this.tasksInRoom = tasksInRoom;
    }

    public String getPasswordInfo() {
        return passwordInfo;
    }

    public void setPasswordInfo(String passwordInfo) {
        this.passwordInfo = passwordInfo;
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
