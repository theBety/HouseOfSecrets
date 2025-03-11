package Player;

import Commands.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class GameLoop {
    Scanner sc = new Scanner(System.in);
    private HashMap<String, Command> commands = new HashMap<>();
    protected Player player;

    public void initialize() {
        commands.put("Go to", new GoTo());
        commands.put("Give object", new GiveObject());
        commands.put("Take object", new TakeObject());
        commands.put("Talk to", new TalkTo());
        commands.put("Unlock", new Unlock());
        commands.put("Use object", new UseObject());
    }

    public void gameLoop() {
        do {
            //main game loop.
        } while (!player.isGameOver());
    }

    public void intro() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("ReadingStory.txt"));
            String text;
            int counter = 0;
            while ((text = br.readLine()) != null) {
                counter++;
                if (counter <= 4) {
                    System.out.println(text);
                } else {
                    Thread.sleep(3000);
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
        } catch (IOException | InterruptedException e) {
            System.err.println("Error reading story file");
        }
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "GameLoop{" +
                ", commands=" + commands +
                '}';
    }
}
