package World;

import Items.Item;

public class Task {
    private Item requiredItem;
    private String tasksDescription;
    private boolean isItDone = false;
    private int codeTask;


    public boolean doingTask(){
        //doing task
        //print des, then input, then check
        return true;
    }
    public Task() {
    }

    public Task(Item requiredItem, String tasksDescription, boolean isItDone) {
        this.requiredItem = requiredItem;
        this.tasksDescription = tasksDescription;
        this.isItDone = isItDone;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(Item requiredItem) {
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
                ", isItDone=" + isItDone +
                '}';
    }
}
