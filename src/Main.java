import Commands.GoTo;
import Player.GameLoop;
import World.LoadMap;

public class Main {
    public static void main(String[] args) {
        LoadMap l = new LoadMap();
        System.out.println(l.loadMap());
        /*GoTo g = new GoTo();
        System.out.println(g.execute());
        //italics
        GameLoop gl = new GameLoop();
        gl.intro();*/
    }
}