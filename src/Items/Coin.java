package Items;

public class Coin extends Item{
    protected int value;

    public Coin(String name, int value) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}
