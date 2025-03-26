package Items;

public class Weapon extends Item{
    private final int rating;

    public Weapon(String name, int rating) {
        this.rating = rating;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Rating: " + rating;
    }
}
