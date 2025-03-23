package Commands;

import Player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UseObject extends Command {
    protected Player player;

    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    public UseObject() {
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        try {
            if(player.getInventory().isEmpty()){
                return "You don't have any items in your inventory";
            }
            System.out.println("Enter the name of the object you wish to use:");
            String name = sc.next().toLowerCase();
            int index = findInInventory(name);
            if(index != -1) {
                for (int i = 0; i < player.getCurrentPosition().getTasksInRoom().size(); i++) {
                    if (player.getCurrentPosition().getTasksInRoom().get(i).getRequiredItem().equals(name)) {
                        player.getCurrentPosition().getTasksInRoom().get(i).setItDone(true);
                        String answer = player.getCurrentPosition().getTasksInRoom().get(i).getClueToPassword();
                        player.getCurrentPosition().getTasksInRoom().remove(i);
                        player.getInventory().remove(index);
                        return "There’s something written. It looks like some kind of code clue: " + answer;
                    }
                }
                return "You can't use this object";
            }
            return "You don't have any such object";
        } catch (InputMismatchException e) {
            sc.next();
            return "Invalid Input";
        } catch (IndexOutOfBoundsException e) {
            return "Invalid Input";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int findInInventory(String name) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            if(player.getInventory().get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
