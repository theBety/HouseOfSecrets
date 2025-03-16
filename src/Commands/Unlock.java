package Commands;

import Player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Unlock extends Command {
    protected Player player;

    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    public Unlock() {
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        try {
            if (player.getCurrentPosition().getRoomId() == 2) {
                System.out.println("Do you have the key? Yes or no");
                String yesNo = sc.next().toLowerCase();
                if (yesNo.equals("yes")) {
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        if (player.getInventory().get(i).getName().equals("key")) {
                            player.getCurrentPosition().setLocked(false);
                            player.setGameOver(true);
                            return "YOU DID IT. Now run. Run as fast as you can. And your friends? Well, you will never see them again. Why? because they are DEAD.";
                        }
                    }
                }
                return "Do you don't";
            }
            System.out.println("Clue: " + player.getCurrentPosition().getPasswordInfo());
            System.out.println("Type in the password.");
            int input = sc.nextInt();
            if (player.getCurrentPosition().getPasswordToNextRoom() == input) {
                String[] avaRooms = player.getCurrentPosition().getAvailableRooms();
                for (int i = 0; i < player.getCurrentPosition().getAvailableRooms().length; i++) {
                    player.getRoomsInGame().get(Integer.parseInt(avaRooms[i])).setLocked(false);
                }
                return "Room is unlocked.";
            }
            return "Invalid password.";
        } catch (InputMismatchException e) {
            sc.next();
            return "Invalid Input";
        } catch (IndexOutOfBoundsException e) {
            return "Invalid Input";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
