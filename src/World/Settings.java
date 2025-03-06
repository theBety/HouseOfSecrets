package World;

import Commands.GoTo;
import Player.Player;

public class Settings {

    public LoadingInfo loadInfo = new LoadingInfo();
    public Player player = new Player();

    public void start() {
        System.out.println(loadInfo.loadMap());
        GoTo g = new GoTo();
        g.setCurrentPosition(player);
        System.out.println("You're now in room " + g.execute());
        loadInfo.setRoom(Integer.parseInt(g.execute()));
        //System.out.println(g.execute());
        //System.out.println(g.execute());
        /*GameLoop gl = new GameLoop();
        gl.intro();*/
    }

    public void inicializa(){
        //presunout hashmapu do playera
        //tady vse nastavim. spustim metody z loadmap aby se naplnila hasmapa
        //vse bude dobrt :)
    }

    public Settings() {
    }

    public LoadingInfo getLoadInfo() {
        return loadInfo;
    }
}
