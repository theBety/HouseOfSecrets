package World;

import Entities.Entity;
import Items.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private int roomId;
    private String name;
    private String[] availableRooms;
    private ArrayList<Item> itemsInRoom = new ArrayList<>();
    private ArrayList<Entity> EntitiesInRoom = new ArrayList<>();

    public Room(int roomId, String name, String[] availableRooms) {
        this.roomId = roomId;
        this.name = name;
        this.availableRooms = availableRooms;
    }
    public Room(){}

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
        return EntitiesInRoom;
    }

    public void setEntitiesInRoom(ArrayList<Entity> entitiesInRoom) {
        EntitiesInRoom = entitiesInRoom;
    }

    @Override
    public String toString() {
        return
                "roomId: " + roomId +
                ", name: " + name +
                ", availableRooms: " + Arrays.toString(availableRooms) +
                ", itemsInRoom: " + itemsInRoom +
                ", EntitiesInRoom: " + EntitiesInRoom +
                '\n';
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
