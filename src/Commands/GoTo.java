package Commands;

import World.LoadMap;
import World.Room;

import java.util.Scanner;

public class GoTo implements Command{
    Scanner sc = new Scanner(System.in);
    private final LoadMap map = new LoadMap();
    //in this step hashmap empties itself.
    @Override
    public String execute() {
        try {
            map.loadMap();
            Room currentRoom = map.getCurrentPosition();
            System.out.println("Where do you want to go?\n>> ");
            int idOfRoom = sc.nextInt();
            String[] currentAvailableRooms = currentRoom.getAvailableRooms();
            for (String currentAvailableRoom : currentAvailableRooms) {
                if (currentAvailableRoom.equals(Integer.toString(idOfRoom))) {
                    currentRoom = map.getRoomsInGame().get(idOfRoom);
                    map.setCurrentPosition(idOfRoom);
                    return "You're now in room " + currentRoom;
                }
            }
            return "You can't go in this room.";
        }catch (Exception e){
            return "Something went wrong";
        }
    }

    @Override
    public Boolean exit() {
        return false;
    }

    public GoTo() {
    }
}
