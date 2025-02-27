package Items;

public class LoreItems extends Item{
    private int inWhichRoomIsUsed;

    public LoreItems(int inWhichRoomIsUsed, String name) {
        this.inWhichRoomIsUsed = inWhichRoomIsUsed;
        this.name = name;
    }

    public int getInWhichRoomIsUsed() {
        return inWhichRoomIsUsed;
    }

    public void setInWhichRoomIsUsed(int inWhichRoomIsUsed) {
        this.inWhichRoomIsUsed = inWhichRoomIsUsed;
    }

    @Override
    public String toString() {
        return "LoreItems{" +
                "inWhichRoomIsUsed=" + inWhichRoomIsUsed +
                '}';
    }
}
