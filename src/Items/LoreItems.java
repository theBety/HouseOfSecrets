package Items;

public class LoreItems extends Item{
    private int inWhichRoomIsUsed;

    public LoreItems(String name, int inWhichRoomIsUsed) {
        this.name = name;
        this.inWhichRoomIsUsed = inWhichRoomIsUsed;
    }

    public int getInWhichRoomIsUsed() {
        return inWhichRoomIsUsed;
    }

    public void setInWhichRoomIsUsed(int inWhichRoomIsUsed) {
        this.inWhichRoomIsUsed = inWhichRoomIsUsed;
    }

    @Override
    public String toString() {
        return "Name: " + name + " inWhichRoom: " + inWhichRoomIsUsed + "\n";
    }
}
