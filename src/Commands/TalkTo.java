package Commands;

import Player.Player;

public class TalkTo extends Command{
    public TalkTo() {
    }

    public void setCurrentPosition(Player player) {
        this.player = player;
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
