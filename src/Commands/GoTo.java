package Commands;

import Player.Player;
import World.Room;
import World.Settings;

import java.util.Scanner;

public class GoTo extends Command {

    protected Player player;

    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        try {
            //Room currentRoom = currentPosition;
            System.out.println("Where do you want to go?\n>> ");
            int idOfRoom = sc.nextInt();
            String[] currentAvailableRooms = currentPosition.getAvailableRooms();
            for (String room : currentAvailableRooms) {
                if (room.equals(Integer.toString(idOfRoom))) {
                    return String.valueOf(idOfRoom);
                }
            }
            return "You can't go in this room.";
        } catch (Exception e) {
            return "Something went wrong";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }

    public GoTo() {
    }
}
