package Player;

import Commands.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class GameLoop {
    private boolean gameOver = false;
    private Scanner sc = new Scanner(System.in);
    private HashMap<String, Command> commands = new HashMap<>();

    public void initialize(){
        commands.put("Go to", new GoTo());
        commands.put("Give object", new GiveObject());
        commands.put("Take object", new TakeObject());
        commands.put("Talk to", new TalkTo());
        commands.put("Unlock", new Unlock());
        commands.put("Use object", new UseObject());
    }

    public void gameLoop(){
        do{
            //main game loop.
        }while(!gameOver);
    }

    public void intro(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("ReadingStory.txt"));
            String text;
            int counter = 0;
            while((text = br.readLine()) != null){
                counter++;
                if(counter<=4){
                    System.out.println(text);
                }else{
                    //take object - diary
                    //use object - diary
                        System. out. println("\033[3m\nManzanillo 1847\n" +
                                "\n" +
                                "They don't stop. They're following me, every day, every hour, every minute. They're on me.\n" +
                                "I can feel their eyes on me. They're burning into my skin. I need someone to help me, something that will chase them away.\n" +
                                "Nicolas gave me this thing, an old cursed amulet. It should make them go away. But will it be enough? Will it stop them?\n" +
                                "I have the amulet in my right pocket, it has to be in the right one, IT HAS TO. They're still here, I can feel them.\n" +
                                "Nicolas told me to be careful with it. Apparently, this amulet is an old enchanted object, it has been found in hand of a dead pirate.\n" +
                                "There are legends that captain of an old ship had found it in old cave and short after died of an unknown cause.\n" +
                                "\n" +
                                "Nick also gave me boxes full of cursed or enchanted objects. Sometimes they give me chills, but I'm not some kind of coward\n" +
                                "to be scared of few watches, compasses and lighters.\n\033[0m");
                    System.out.println(text);
                }
            }
        }catch(IOException e){
            System.err.println("Error reading story file");
        }
    }
}
