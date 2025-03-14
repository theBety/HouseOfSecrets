package Entities;

import Items.Weapon;
import Player.Player;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Entity {
    Random rd = new Random();
    protected Player player;
    private String name;
    private String loreText;

    Scanner sc = new Scanner(System.in);

    public Entity(String name) {
        this.name = name;
    }
    public Entity(){}

    public void ability() {
        try {
            switch (name) {
                case "Goblin":
                    loreText = "Oh. There's a goblin. You need to give him some item. Choose carefully, losing lore item could mean game over because you" +
                            "can't clear some task. So which item are you giving him? Type in on which line of your inventory the item is.";
                    int input = sc.nextInt();
                    player.getInventory().remove(input);
                    player.getCurrentPosition().setEntityInRoom(null);
                case "Witch":
                    witchAndMedusa();
                case "Medusa":
                    witchAndMedusa();
                case "Hydras":
                    int countOfArrows = 0;
                    loreText = "There's Hydras. They have 5 heads.. I need five arrows or else I'm dead.";
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        if (player.getInventory().get(i).getName().equals("arrow")) {
                            countOfArrows++;
                        }
                    }
                    if (countOfArrows == 5) {
                        System.out.println("She's dead.");
                    } else {
                        System.out.println("I'm dead.");
                        player.setGameOver(true);
                    }
                    player.getCurrentPosition().setEntityInRoom(null);
                case "Fairy":
                    loreText = "Oh look there's a fairy. She can give you something useful!";
                    player.getInventory().add(new Weapon("arrow", 2));
                case "Elf":
                    loreText = "Oh look there's an elf. She can give you something useful!";
                    player.getInventory().add(new Weapon("arrow", 2));
                case "Phoenix":
                    loreText = "He will upgrade your weapon! Hurry!";
                    sellWeapon();
                case "Knight":
                    loreText = "Someone's following me. I should talk to them.";
                default:
                    throw new IllegalStateException("Unexpected value: " + name);
            }
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.err.println("Wrong input");
        } catch (Exception e) {
            System.err.println("Somethings wrong");
        }

    }

    public void witchAndMedusa() {
        int randomRank = rd.nextInt(5) + 1;
        loreText = "OMG that's a Witch. She has weapon of rank " + randomRank + ". Do you have weapon better then her?\n"
                + "If so, Type in its name. if not, type in 'no'.";
        String nameOfWeapon = sc.next().toLowerCase();
        if (nameOfWeapon.equals("no")) {
            System.out.println("Bad for you. She is slowly killing you. You are DEAD. GAME OVER.");
            player.setGameOver(true);
        } else {
            System.out.println("Okay, now type in its ranking");
            int rankingOfPlayersWeapon = sc.nextInt();
            if (player.getWeapons().get(nameOfWeapon).equals(rankingOfPlayersWeapon)) {
                System.out.println("You did it!");
                player.getCurrentPosition().setEntityInRoom(null);
            } else {
                System.out.println("Bad for you. She is slowly killing you. You are DEAD. GAME OVER.");
                player.setGameOver(true);
            }
        }
    }

    public void sellWeapon() {
        try {
            int budget = player.getCoins();
            System.out.println("Which weapon do you want to buy?\n" + player.getWeapons().keySet());
            String name = sc.next().toLowerCase();
            if (player.getWeapons().containsKey(name)) {
                System.out.println("550 please");
                if (budget >= 550) {
                    player.setCoins(-550);
                    player.getInventory().add(new Weapon(name, player.getWeapons().get(name)));
                }
            }
            player.getWeapons().get(name);
        } catch (Exception e) {
            System.out.println("Somethings wrong");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoreText() {
        return loreText;
    }

    public void setLoreText(String loreText) {
        this.loreText = loreText;
    }

    @Override
    public String toString() {
        return
                "name: " + name +
                        ", loreText: '" + loreText + "'\n";
    }
}
