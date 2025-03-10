package Commands;

import Player.Player;

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
        try{
            System.out.println("Type in the password.");
            int input = sc.nextInt();
            if(player.getCurrentPosition().getPassword() == input){
                player.getCurrentPosition().setLocked(false);
                return "Room is unlocked.";
            }
            return "Invalid password.";
        }catch (Exception e) {
            return "Something went wrong";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
