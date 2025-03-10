package Commands;

import Player.Player;

import java.util.Scanner;

public class GiveObject extends Command {
    protected Player player;
    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        try{
            if(player.getCurrentPosition().getName().equals("living")){
                System.out.println("He wants flowers for his wife. That is so sweet.");

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
