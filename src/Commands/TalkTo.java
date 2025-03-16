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
                    "I need some vase, flowers and string to tie them up. Thank you.");
        }
        return "You can't talk to anyone";
    }
}
