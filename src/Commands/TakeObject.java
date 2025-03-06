package Commands;

import Items.Item;
import World.Room;

import java.util.Scanner;

public class TakeObject extends Command{

    protected Room currentPosition;

    public void setCurrentPosition(Room currentPosition) {
        this.currentPosition = currentPosition;
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public String execute() {
        try{
            System.out.println("Available items: " + currentPosition.getItemsInRoom());
            System.out.println("Which item do you want to take?\n>> ");
            String input = sc.next();
            for(Item item:currentPosition.getItemsInRoom()){
                if(item.equals(input)){

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
