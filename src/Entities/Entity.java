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
    private String loreText2;

    Scanner sc = new Scanner(System.in);

    public void setCurrentPosition(Player player) {
        this.player = player;
    }

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
                    break;
                case "Witch", "Medusa":
                    witchAndMedusa();
                    break;
                case "Hydras":
                    int countOfArrows = 0;
                    loreText = "There's Hydras. They have 4 heads.. I need four arrows or else I'm dead.";
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        if (player.getInventory().get(i).getName().equals("arrow")) {
                            countOfArrows++;
                        }
                    }
                    if (countOfArrows == 4) {
                        loreText2 = "She's dead.";
                    } else {
                        loreText2 = "I'm dead.";
                        player.setGameOver(true);
                    }
                    player.getCurrentPosition().setEntityInRoom(null);
                    break;
                case "Fairy":
                    loreText = "Oh look there's a fairy. She can give you something useful!";
                    player.getInventory().add(new Weapon("arrow", 2));
                    loreText2 = "She gave you an arrow!";
                    break;
                case "Elf":
                    loreText = "Oh look there's an elf. He can give you something useful!";
                    player.getInventory().add(new Weapon("arrow", 2));
                    loreText2 = "He gave you an arrow!";
                    break;
                case "Phoenix":
                    loreText = "He will upgrade your weapon! Hurry!";
                    sellWeapon();
                    break;
                case "Knight":
                    loreText = "Someone's following me. I should talk to them.";
                    break;
            }
            if ((loreText == null)) {
                System.out.println();
            }else{
                System.out.println(loreText);
                Thread.sleep(2500);
                System.out.println(loreText2);
                loreText2 = "";
                loreText = "";
                player.getCurrentPosition().getEntityInRoom().setName(null);
            }

        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.err.println("Wrong input");
        }catch (NullPointerException e) {
            System.err.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    @Override
    public String toString() {
        return
                "name: " + name +
                        ", loreText: '" + loreText + "'\n";
    }
}
