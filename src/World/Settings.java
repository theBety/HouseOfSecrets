package World;

import Player.GameLoop;

public class Settings{

    LoadingInfo loadInfo = new LoadingInfo();
    GameLoop gameLoop = new GameLoop();


    public void start() {
        initialize();
        gameLoop.gameLoop();
        /*
        takeObject.setCurrentPosition(player);
        System.out.println(takeObject.execute());
        System.out.println("You're now in room " + g.execute());
        loadInfo.setRoom(Integer.parseInt(g.execute()));
        System.out.println(g.execute());
        System.out.println(g.execute());
        GameLoop gl = new GameLoop();
        gl.intro();*/
    }

    public void initialize(){
        loadInfo.loadMap(gameLoop.getPlayer().getRoomsInGame(), gameLoop.getPlayer().getWeapons());
        gameLoop.getPlayer().setStart();
        gameLoop.getPlayer().getWeapons().put("bow", 3);
        gameLoop.getPlayer().getWeapons().put("axe", 4);
        gameLoop.getPlayer().getWeapons().put("arrow", 2);
        gameLoop.getPlayer().getWeapons().put("knife", 2);
        gameLoop.getPlayer().getWeapons().put("sword", 5);
        gameLoop.getPlayer().getWeapons().put("gun", 6);
    }

    public Settings() {
    }

    public LoadingInfo getLoadInfo() {
        return loadInfo;
    }
}
