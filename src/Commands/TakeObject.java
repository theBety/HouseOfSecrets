package Commands;

import Items.Item;
import Player.Player;
import World.Room;

import java.util.Scanner;

public class TakeObject extends Command{
    protected Player player;
    public TakeObject() {
    }
    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        try{
            System.out.println("Items in this room: " + player.getCurrentPosition().getItemsInRoom());
            System.out.println("Which item do you want to take?\n>> ");
            String input = sc.next();
            for(Item item: player.getCurrentPosition().getItemsInRoom()){
                if(item.equals(input)){
                    player.getInventory().add(item);
                    player.getCurrentPosition().getItemsInRoom().remove(item);
                    return "Your inventory: " + player.getInventory();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
