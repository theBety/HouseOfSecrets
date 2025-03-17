package Commands;

import Player.Player;

public class TalkTo extends Command{
    public TalkTo() {
    }

    public void setCurrentPosition(Player player) {
        super.setCurrentPosition(player);
    }

    @Override
    public String execute() {
        try{
            if (player.getCurrentPosition().getName().equals("living")){
                return ("Hello, I want to give my beautiful wife some flowers. Could you help me with that?" +
                        "I need some vase, flowers and string to tie them up. Thank you.");
            }
            return "You can't talk to anyone";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
