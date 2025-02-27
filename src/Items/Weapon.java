package Items;

public class Weapon extends Item{
    private int rating;

    public Weapon(int rating, String name) {
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
        return "Weapon{" +
                "rating=" + rating +
                '}';
    }
}
