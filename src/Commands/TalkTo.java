package Commands;

public class TalkTo extends Command{
    public TalkTo() {
    }

    @Override
    public String execute() {
        if (player.getCurrentPosition().getName().equals("living")){
            return ("Hello, I want to give my beautiful wife some flowers. Could you help me with that?" +
                    "I need some vase, string to tie up the flowers and of course flowers. Thank you.");
        }
        return "You can't talk to anyone";
    }
}
