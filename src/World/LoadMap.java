package World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class LoadMap {
        private HashMap<Integer, Room> roomsInGame = new HashMap<>();
        private final int start = 1;
        private int currentPosition = start;

        public boolean loadMap() {
            try {
                BufferedReader br = new BufferedReader(new FileReader("map.txt"));
                String text;
                int i = 0;
                while((text = br.readLine())!= null){
                    String[] lines = text.split(":");
                    String[] locationNum = lines[2].split(" ");
                    roomsInGame.put(Integer.parseInt(lines[1]), new Room(Integer.parseInt(lines[1]), lines[0], locationNum));
                }
                System.out.println(roomsInGame);
            } catch (IOException e) {
                return false;
            }
            return true;
        }

    public LoadMap() {
    }

    public HashMap<Integer, Room> getRoomsInGame() {
        return roomsInGame;
    }

    public void setRoomsInGame(HashMap<Integer, Room> roomsInGame) {
        this.roomsInGame = roomsInGame;
    }

    public int getStart() {
        return start;
    }

    public Room getCurrentPosition() {
        return roomsInGame.get(currentPosition);
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public String toString() {
        return "LoadMap{" +
                "roomsInGame=" + roomsInGame +
                ", start=" + start +
                ", currentPosition=" + currentPosition +
                '}';
    }
}
