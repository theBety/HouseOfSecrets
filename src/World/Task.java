package World;

import Items.Item;

public class Task {
    private Item requiredItem;
    private String tasksDescription;
    private boolean isItDone = false;
    private int passwordFromTask;

    public boolean doingTask(){
        //doing task
        //print des, then input, then check
        return true;
    }
    public Task() {
    }

    public Task(Item requiredItem, String tasksDescription, boolean isItDone, int passwordFromTask) {
        this.requiredItem = requiredItem;
        this.tasksDescription = tasksDescription;
        this.isItDone = isItDone;
        this.passwordFromTask = passwordFromTask;
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
                "passwordFromTask=" + passwordFromTask +
                '}';
    }

    public int getPasswordFromTask() {
        return passwordFromTask;
    }

    public void setPasswordFromTask(int passwordFromTask) {
        this.passwordFromTask = passwordFromTask;
    }
}
