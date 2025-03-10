package Commands;

import Player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeObject extends Command {
    protected Player player;

    public TakeObject() {
    }

    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        try {
            System.out.println("Items in this room: \n" + player.getCurrentPosition().getItemsInRoom());
            System.out.println("Which item do you want to take? Type its sequence number\n>> ");
            int input = sc.nextInt();
            player.getInventory().add(player.getCurrentPosition().getItemsInRoom().get(input-1));
            player.getCurrentPosition().getItemsInRoom().remove(input-1);
            return "Inventory: " + player.getInventory().toString();
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            return "Invalid Input";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
