package World;

import Items.Item;

public class Task {
    private String requiredItem;
    private String tasksDescription;
    private String clueToPassword;
    private boolean isItDone = false;

    public boolean doingTask(){
        //doing task
        //print description, then input, then check
        return true;
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
