package Commands;

import Items.Item;
import Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class GiveObject extends Command {
    //TOHLE BY MELO BYT DONE
    protected Player player;

    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        try {
            if (player.getCurrentPosition().getName().equals("living")) {
                System.out.println("He wants flowers for his wife. That is so sweet.");
                ArrayList<Item> tempList = new ArrayList<>();

                for (int i = 0; i < player.getInventory().size(); i++) {
                    if (!player.getInventory().get(i).getName().equals("flower") | !player.getInventory().get(i).getName().equals("vase")
                            | !player.getInventory().get(i).getName().equals("string")) {
                        tempList.add(player.getInventory().get(i));
                    }
                }
                if (tempList.size() + 7 == player.getInventory().size()) {
                    player.getInventory().clear();
                    player.getInventory().addAll(tempList);
                    return "You gave him all flowers! How sweet of you!";
                }else{
                    return "You don't have enough flowers!";
                }
            }
            return "You can't do that.";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
