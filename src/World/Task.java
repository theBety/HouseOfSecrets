package World;

import Player.Player;

public class Task {
    private final String requiredItem;
    private final String tasksDescription;
    private final String clueToPassword;
    private boolean isItDone = false;
    protected Player player;


    public void setCurrentPosition(Player player) {
        this.player = player;
    }

    public Task(String requiredItem, String tasksDescription, String clueToPassword) {
        this.requiredItem = requiredItem;
        this.tasksDescription = tasksDescription;
        this.clueToPassword = clueToPassword;
    }

    public String getRequiredItem() {
        return requiredItem;
    }

    public String getTasksDescription() {
        return tasksDescription;
    }

    public void setItDone(boolean itDone) {
        isItDone = itDone;
    }

    public String getClueToPassword() {
        return clueToPassword;
    }

    public boolean isItDone() {
        return isItDone;
    }
}
