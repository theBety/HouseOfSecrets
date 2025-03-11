package Commands;

import Player.Player;

public abstract class Command {
    protected Player player;

    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    public abstract String execute();
}
