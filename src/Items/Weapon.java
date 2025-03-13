package Items;

public class Weapon extends Item{
    private int rating;

    public Weapon(String name, int rating) {
        this.rating = rating;
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Rating: " + rating;
    }
}
