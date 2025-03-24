package Commands;

import Player.Player;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GoTo extends Command {

    protected Player player;

    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    public GoTo() {
    }
    Scanner sc = new Scanner(System.in);

    /**
     * Checks, if doors to next room are locked, if not, checks if player can go to this room (If these rooms are next to each-other).
     * @return Did player successfully enter another room?
     */
    @Override
    public String execute() {
        try {
            System.out.println("Ids of rooms where you can go: " + Arrays.toString(player.getCurrentPosition().getAvailableRooms()));

            System.out.println("Where do you want to go?\n>> ");
            int idOfRoom = sc.nextInt();
            String[] currentAvailableRooms = player.getCurrentPosition().getAvailableRooms();
            for (String room : currentAvailableRooms) {
                if (room.equals(Integer.toString(idOfRoom))) {
                    if(player.getRoomsInGame().get(idOfRoom).isLocked()){
                        return "Locked room.";
                    }
                    player.setCurrentPosition(player.getRoomsInGame().get(idOfRoom));
                    return "You're now in: " + player.getCurrentPosition().getName() + " \nwith id: " + idOfRoom;
                }
            }
            return "You can't go in this room.";
        } catch (InputMismatchException e) {
            sc.next();
            return "Invalid Input";
        } catch (IndexOutOfBoundsException e) {
            return "Invalid Input";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
