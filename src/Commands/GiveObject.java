package Commands;

import Player.Player;

import java.util.Scanner;

public class GiveObject extends Command {
    protected Player player;

    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    Scanner sc = new Scanner(System.in);

    /**
     * NPC wants flowers, string and vase. Method checks if player has everything they need in order to finish this task.
     * if so, the task is completed.
     * @return if player successfully completed the task.
     */
    @Override
    public String execute() {
        try {
            if (player.getCurrentPosition().getName().equals("living")) {
                System.out.println("He wants flowers for his wife. That is so sweet.");

                System.out.println("Do you want to give him flowers?");
                String option = sc.next().toLowerCase();
                if (option.equals("yes")) {
                    System.out.println("That's so sweet of you.");
                } else {
                    System.out.println("Yes, you do.");
                }
                int countOfFlowers = 0;
                boolean stringFound = false;
                boolean vaseFound = false;

                for (int i = 0; i < player.getInventory().size(); i++) {
                    switch (player.getInventory().get(i).getName()) {
                        case "flower" -> countOfFlowers++;
                        case "string" -> stringFound = true;
                        case "vase" -> vaseFound = true;
                    }
                }
                if (countOfFlowers == 5 && stringFound && vaseFound) {
                    player.getInventory().removeIf(i -> i.getName().equals("flower"));
                    player.getInventory().removeIf(i -> i.getName().equals("string"));
                    player.getInventory().removeIf(i -> i.getName().equals("vase"));
                    return "You gave him all flowers! How sweet of you!";
                } else {
                    return "You don't have enough flowers!";
                }
            }
            return "You can't do that.";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
