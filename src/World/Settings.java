package World;

import Commands.GiveObject;
import Commands.GoTo;
import Commands.TakeObject;
import Player.Player;

public class Settings {

    public LoadingInfo loadInfo = new LoadingInfo();
    public Player player = new Player();
    public TakeObject t1 = new TakeObject();

    public void start() {
        initialize();
        GoTo g = new GoTo();
        g.setCurrentPosition(player);
        System.out.println(g.execute());
        /*
        t1.setCurrentPosition(player);
        System.out.println(t1.execute());
        System.out.println("You're now in room " + g.execute());
        loadInfo.setRoom(Integer.parseInt(g.execute()));
        System.out.println(g.execute());
        System.out.println(g.execute());
        GameLoop gl = new GameLoop();
        gl.intro();*/
    }

    public void initialize(){
        System.out.println(loadInfo.loadMap(player.getRoomsInGame(), player.getWeapons()));
        System.out.println(player.setStart());
        player.getWeapons().put("bow", 3);
        player.getWeapons().put("axe", 4);
        player.getWeapons().put("arrow", 2);
        player.getWeapons().put("knife", 2);
        player.getWeapons().put("sword", 5);
        player.getWeapons().put("gun", 6);
    }

    public Settings() {
    }

    public LoadingInfo getLoadInfo() {
        return loadInfo;
    }
}
