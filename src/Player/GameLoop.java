package Player;

import Commands.*;

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

    }
}
