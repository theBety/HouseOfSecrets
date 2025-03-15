package World;

import Player.Player;

public class Task {
    private String requiredItem;
    private String tasksDescription;
    private String clueToPassword;
    private boolean isItDone = false;
    protected Player player;


    public void setCurrentPosition(Player player) {
        this.player = player;
    }


    public Task() {
    }

    public Task(String requiredItem, String tasksDescription, String clueToPassword) {
        this.requiredItem = requiredItem;
        this.tasksDescription = tasksDescription;
        this.clueToPassword = clueToPassword;
    }

    public String getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(String requiredItem) {
        this.requiredItem = requiredItem;
    }

    public String getTasksDescription() {
        return tasksDescription;
    }

    public void setTasksDescription(String tasksDescription) {
        this.tasksDescription = tasksDescription;
    }

    public boolean isItDone() {
        return isItDone;
    }

    public void setItDone(boolean itDone) {
        isItDone = itDone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "requiredItem=" + requiredItem +
                ", tasksDescription='" + tasksDescription + '\'' +
                ", isItDone=" + isItDone;
    }

    public String getClueToPassword() {
        return clueToPassword;
    }

    public void setClueToPassword(String clueToPassword) {
        this.clueToPassword = clueToPassword;
    }
}
