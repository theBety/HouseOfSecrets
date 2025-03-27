package World;

import Entities.Entity;
import Items.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private boolean isLocked;
    private final int passwordToNextRoom;
    private final String passwordInfo;
    private final int roomId;
    private final String name;
    private final String[] availableRooms;
    private final ArrayList<Item> itemsInRoom = new ArrayList<>();
    private Entity entityInRoom = new Entity();
    private final ArrayList<Task> tasksInRoom = new ArrayList<>();


    public Room(int roomId, String name, String[] availableRooms, boolean isLocked, int passwordToNextRoom, String passwordInfo) {
        this.roomId = roomId;
        this.name = name;
        this.availableRooms = availableRooms;
        this.isLocked = isLocked;
        this.passwordToNextRoom = passwordToNextRoom;
        this.passwordInfo = passwordInfo;
    }


    //region Set&Get
    public int getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public String[] getAvailableRooms() {
        return availableRooms;
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
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

    public String getPasswordInfo() {
        return passwordInfo;
    }

    //endregion


    @Override
    public String toString() {
        return
                "Room Id: " + roomId +
                ", Name: " + name +
                ", Available rooms: " + Arrays.toString(availableRooms) +
                ", Items in room: " + itemsInRoom;
    }

    public ArrayList<Task> getTasksInRoom() {
        return tasksInRoom;
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
