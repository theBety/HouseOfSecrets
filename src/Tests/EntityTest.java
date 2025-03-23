package Tests;

import Entities.Entity;
import Items.Item;
import Items.LoreItems;
import Player.Player;
import World.Room;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    Entity entity = new Entity("Hydras");
    LoreItems l = new LoreItems("arrow", 8);
    Player p;

    @org.junit.jupiter.api.Test
    void ability() {
        ArrayList<Item> arrows = new ArrayList<>();
        arrows.add(l);
        arrows.add(l);
        arrows.add(l);
        arrows.add(l);
        arrows.add(l);
        HashMap<Integer, Room> rooms = new HashMap<>();
        String[] availableRooms = {"0"};
        rooms.put(8, new Room(8, "gallery", availableRooms, false, 1997, "feather"));
        rooms.get(8).setEntityInRoom(new Entity("Hydras"));
        p = new Player(rooms, rooms.get(8), 0, false);
        p.add(arrows);
        entity.setCurrentPosition(p);
        entity.ability();
        assertEquals("She's dead.", entity.getLoreText2());
    }

    @org.junit.jupiter.api.Test
    void testAbility() {
    }
}