package Commands;

import Player.Player;

public abstract class Command {
    protected Player player;
    /**
     * sets current room players in (With what room program works);
     */
    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    public abstract String execute();
}
