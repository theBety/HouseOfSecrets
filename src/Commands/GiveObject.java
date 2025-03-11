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
                int[] listOfAllIndexes = new int[7];
                int count = 0;

                for (int i = 0; i < player.getInventory().size(); i++)
                    switch (player.getInventory().get(i).getName()) {
                        case "flower" -> {
                            countOfFlowers++;
                            listOfAllIndexes[count] = i;
                            count++;
                        }
                        case "string" -> {
                            stringFound = true;
                            listOfAllIndexes[count] = i;
                            count++;
                        }
                        case "vase" -> {
                            vaseFound = true;
                            listOfAllIndexes[count] = i;
                            count++;
                        }
                    }
                if (countOfFlowers == 5 && stringFound && vaseFound) {
                    for (int i = 0; i < 7; i++) {
                        player.getInventory().remove(listOfAllIndexes[i]);
                    }
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

    @Override
    public boolean exit() {
        return false;
    }
}
