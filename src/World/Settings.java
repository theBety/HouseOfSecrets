package World;

import Player.GameLoop;

public class Settings{

    LoadingInfo loadInfo = new LoadingInfo();
    GameLoop gameLoop = new GameLoop();

    /**
     * This method starts this game.
     */
    public void start() {
        initialize();
        gameLoop.gameLoop();
    }

    /**
     * adds weapons to hashmap which is used later.
     */
    public void initialize(){
        loadInfo.loadMap(gameLoop.getPlayer().getRoomsInGame());
        System.out.println(loadInfo.printIntroImage());
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
}
