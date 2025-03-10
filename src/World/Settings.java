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
        System.out.println(loadInfo.loadMap(player.getRoomsInGame(), player.getWeapons()));
        System.out.println(player.setStart());
        //GoTo g = new GoTo();
        t1.setCurrentPosition(player);
        System.out.println(t1.execute());
        /*g.setCurrentPosition(player);
        System.out.println(g.execute());
        System.out.println("You're now in room " + g.execute());
        loadInfo.setRoom(Integer.parseInt(g.execute()));
        System.out.println(g.execute());
        System.out.println(g.execute());
        GameLoop gl = new GameLoop();
        gl.intro();*/
    }

    public void initialize(){

        //tady vse nastavim. spustim metody z loadmap aby se naplnila hasmapa
        //vse bude dobrt :)
    }

    public Settings() {
    }

    public LoadingInfo getLoadInfo() {
        return loadInfo;
    }
}
