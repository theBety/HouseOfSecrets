package Player;

import Commands.*;
import Items.LoreItems;
import Items.Weapon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLoop {
    Scanner sc = new Scanner(System.in);
    private final HashMap<String, Command> commands = new HashMap<>();
    protected Player player = new Player();

    public GameLoop() {
    }

    /**
     * initialize commands.
     */
    public void initialize() {
        commands.put("go", new GoTo());
        commands.put("give", new GiveObject());
        commands.put("take", new TakeObject());
        commands.put("talk", new TalkTo());
        commands.put("unlock", new Unlock());
        commands.put("use", new UseObject());
    }

    /**
     * Main game loop.
     */
    public void gameLoop() {
        try {
            boolean playEntities = true;
            initialize();
            intro();
            System.out.println("You're now in room: " + player.getCurrentPosition().getName() + ", with id: " + player.getCurrentPosition().getRoomId());

            player.getInventory().add(new Weapon("arrow", 2));
            player.getInventory().add(new Weapon("arrow", 2));
            player.getInventory().add(new Weapon("arrow", 2));
            player.getInventory().add(new Weapon("arrow", 2));
            player.getInventory().add(new LoreItems("flower", 3));
            player.getInventory().add(new LoreItems("flower", 3));
            player.getInventory().add(new LoreItems("flower", 3));
            player.getInventory().add(new LoreItems("flower", 3));
            player.getInventory().add(new LoreItems("flower", 3));
            player.getInventory().add(new LoreItems("vase", 3));
            player.getInventory().add(new LoreItems("string", 3));
            player.setCoins(800);

            do {
                System.out.println("Where you are: " + player.getCurrentPosition().toString());
                System.out.println("Inventory: " + player.getInventory().toString());
                if(player.getCurrentPosition().getRoomId() == 0){
                    System.out.println("nwiv");
                }
                if (playEntities) {
                    player.getCurrentPosition().getEntityInRoom().setCurrentPosition(player);
                    player.getCurrentPosition().getEntityInRoom().ability();
                    if (!player.getCurrentPosition().getTasksInRoom().isEmpty()) {
                        Thread.sleep(2500);
                        player.getCurrentPosition().getTasksInRoom().get(0).setCurrentPosition(player);
                        System.out.println("\n" + player.getCurrentPosition().getTasksInRoom().get(0).getTasksDescription());
                    }
                    playEntities = false;
                }

                System.out.println("What do you want to do?");
                System.out.println(commands.keySet());

                String answer = sc.next().toLowerCase();
                if (commands.containsKey(answer)) {
                    commands.get(answer).setCurrentPosition(player);
                    System.out.println(commands.get(answer).execute());
                    playEntities = true;
                } else {
                    sc.next();
                    System.out.println("Invalid input");
                }
            } while (!player.isGameOver());
        } catch (InputMismatchException e) {
            sc.next();
            System.out.println("Invalid Input");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Input");
        } catch (Exception e) {
            System.out.print("");
        }
    }

    /**
     * Intro of a game. Letter and instructions for player.
     */
    public void intro() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("ReadingStory.txt"));
            String text;
            int counter = 0;
            while ((text = br.readLine()) != null) {
                counter++;
                if (counter <= 3) {
                    System.out.println(text);
                    //Thread.sleep(8000);
                    continue;
                }
                if (counter <= 8) {
                    System.out.println(text);
                } else {
                    //Thread.sleep(20000);
                    System.out.println("""
                            \033[3m
                            Manzanillo 1847
                            
                            They don't stop. They're following me, every day, every hour, every minute. They're on me.
                            I can feel their eyes on me. They're burning into my skin. I need someone to help me, something that will chase them away.
                            Nicolas gave me this thing, an old cursed amulet. It should make them go away. But will it be enough? Will it stop them?
                            I have the amulet in my right pocket, it has to be in the right one, IT HAS TO. They're still here, I can feel them.
                            Nicolas told me to be careful with it. Apparently, this amulet is an old enchanted object, it has been found in hand of a dead pirate.
                            There are legends that captain of an old ship had found it in old cave and short after died of an unknown cause.
                            
                            Nick also gave me boxes full of cursed or enchanted objects. Sometimes they give me chills, but I'm not some kind of coward
                            to be scared of few watches, compasses and lighters.
                            P.S. Mountain drawn with white marker.
                            \033[0m""");
                    System.out.println(text);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading story file");
        }
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "Commands: " + commands;
    }
}
