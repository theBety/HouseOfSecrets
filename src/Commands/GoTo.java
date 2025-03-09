package Commands;

import Player.Player;

import java.util.InputMismatchException;
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
            System.out.println("Where do you want to go?\n>> ");
            int idOfRoom = sc.nextInt();
            String[] currentAvailableRooms = player.getCurrentPosition().getAvailableRooms();
            for (String room : currentAvailableRooms) {
                if (room.equals(Integer.toString(idOfRoom))) {
                    player.setCurrentPosition(player.getRoomsInGame().get(idOfRoom));
                    return "You're now in: " + player.getCurrentPosition().getName() + " \nwith id: " + idOfRoom;
                }
            }
            return "You can't go in this room.";
        } catch (InputMismatchException i) {
            return "Invalid input.";
        }catch (Exception e) {
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
