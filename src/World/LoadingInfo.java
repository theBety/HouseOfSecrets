package World;

import Entities.Entity;
import Items.Coin;
import Items.LoreItems;
import Items.Weapon;
import Player.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoadingInfo {
    private HashMap<Integer, Room> roomsInGame = new HashMap<>();

    public LoadingInfo() {
    }

    public boolean loadMap() {
        try {
            currentRoom = roomsInGame.get(1);
            BufferedReader br = new BufferedReader(new FileReader("map.txt"));
            String text;
            while ((text = br.readLine()) != null) {
                String[] lines = text.split(":");
                String[] locationNum = lines[2].split(" ");
                roomsInGame.put(Integer.parseInt(lines[1]), new Room(Integer.parseInt(lines[1]), lines[0], locationNum));
            }
            br.close();
            loadItems();
            loadEntities();
            System.out.println(roomsInGame);
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public void loadItems(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("itemsInRoom.txt"));
            String text;
            int counter = -1;
            while ((text = br.readLine()) != null) {
                counter++;
                String[] line = text.split(",");
                String[] weapon = line[0].split(";");
                roomsInGame.get(counter).getItemsInRoom().add(new Weapon(weapon[0], Integer.parseInt(weapon[1])));
                roomsInGame.get(counter).getItemsInRoom().add(new Coin("coin",Integer.parseInt(line[line.length-1])));
                for (int i = 1; i < line.length-2; i++) {
                    String[] item = line[i].split(";");
                    roomsInGame.get(counter).getItemsInRoom().add(new LoreItems(item[0], Integer.parseInt(item[1])));
                }
            }
        }catch(IOException i){
            System.err.println("Error loading Items");
        }
    }

    public void loadEntities(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("EntitiesInRooms.txt"));
            String text;
            int counter = -1;
            while ((text = br.readLine()) != null) {
                counter++;
                String[] line = text.split(";");
                roomsInGame.get(counter).getEntitiesInRoom().add(new Entity(line[0], line[1]));
            }
        }catch(IOException i){
            System.err.println("Error loading Items");
        }
    }

    public void LoadTasks(){

    }

    public HashMap<Integer, Room> getRoomsInGame() {
        return roomsInGame;
    }


    public void setRoomsInGame(HashMap<Integer, Room> roomsInGame) {
        this.roomsInGame = roomsInGame;
    }


    @Override
    public String toString() {
        return
                "roomsInGame=" + roomsInGame;
    }
}
