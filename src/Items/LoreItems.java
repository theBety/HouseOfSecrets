package Items;

public class LoreItems extends Item{
    private final int inWhichRoomIsUsed;

    public LoreItems(String name, int inWhichRoomIsUsed) {
        this.name = name;
        this.inWhichRoomIsUsed = inWhichRoomIsUsed;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }

    public int getInWhichRoomIsUsed() {
        return inWhichRoomIsUsed;
    }
}
