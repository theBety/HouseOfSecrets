import Commands.GoTo;
import World.LoadMap;

public class Main {
    public static void main(String[] args) {
        LoadMap l = new LoadMap();
        System.out.println(l.loadMap());
        GoTo g = new GoTo();
        System.out.println(g.execute());
    }
}