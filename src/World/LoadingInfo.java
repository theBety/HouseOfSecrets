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
    protected Player player;

    public LoadingInfo() {
    }

    /**
     * loads map - rooms and all of their info.
     * @param roomsInGame hashmap where the rooms are stored.
     */
    public void loadMap(HashMap<Integer, Room> roomsInGame) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("map.txt"));
            String text;
            while ((text = br.readLine()) != null) {
                String[] lines = text.split(";");
                String[] locationNum = lines[2].split(" ");
                roomsInGame.put(Integer.parseInt(lines[1]), new Room(Integer.parseInt(lines[1]), lines[0], locationNum,
                        Boolean.parseBoolean(lines[3]), Integer.parseInt(lines[4]), lines[5]));
            }
            br.close();
            loadItems(roomsInGame);
            loadEntities(roomsInGame);
            loadTasks(roomsInGame);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Loads all items in different rooms.
     * @param roomsInGame hashmap where the rooms are stored.
     */
    public void loadItems(HashMap<Integer, Room> roomsInGame) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("itemsInRoom.txt"));
            String text;
            int counter = -1;
            while ((text = br.readLine()) != null) {
                counter++;
                String[] line = text.split(",");
                String[] weapon = line[0].split(";");
                roomsInGame.get(counter).getItemsInRoom().add(new Weapon(weapon[0], Integer.parseInt(weapon[1])));
                roomsInGame.get(counter).getItemsInRoom().add(new Coin("coin", Integer.parseInt(line[line.length - 1])));
                for (int i = 1; i < line.length - 1; i++) {
                    String[] item = line[i].split(";");
                    roomsInGame.get(counter).getItemsInRoom().add(new LoreItems(item[0], Integer.parseInt(item[1])));
                }
            }
        } catch (IOException i) {
            System.err.println("Error loading Items");
        }
    }

    /**
     * Loads all Entities in different rooms.
     * @param roomsInGame hashmap where the rooms are stored.
     */
    public void loadEntities(HashMap<Integer, Room> roomsInGame) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("EntitiesInRooms.txt"));
            String text;
            int counter = -1;
            while ((text = br.readLine()) != null) {
                counter++;
                roomsInGame.get(counter).setEntityInRoom(new Entity(text));
            }
        } catch (IOException i) {
            System.err.println("Error loading Items");
        }
    }

    /**
     * Loads all Tasks in different rooms.
     * @param roomsInGame hashmap where the rooms are stored.
     */
    public void loadTasks(HashMap<Integer, Room> roomsInGame) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("tasksInRooms.txt"));
            String text;
            int counter = -1;
            while ((text = br.readLine()) != null) {
                counter++;
                if (counter == 5 | counter == 6 | counter == 7 | counter == 1| counter == 9) continue;

                String[] line = text.split(";");
                if (counter == 0 | counter == 3 | counter == 4 | counter == 8) {
                    String[] getClue = line[0].split("%");
                    String[] theRest = getClue[0].split(":");
                    roomsInGame.get(counter).getTasksInRoom().add(new Task(theRest[0], theRest[1], getClue[1]));
                    continue;
                }
                if (line.length == 1) {
                    String[] element = line[0].split(":");
                    roomsInGame.get(counter).getTasksInRoom().add(new Task(element[0], element[1], null));
                }
            }
        } catch (IOException i) {
            System.err.println("Error loading Items");
        }
    }
}
