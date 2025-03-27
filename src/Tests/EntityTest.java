package Tests;

import Entities.Entity;
import Items.Item;
import Items.LoreItems;
import Items.Weapon;
import Player.Player;
import World.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    Entity entity = new Entity("Hydras");
    LoreItems l = new LoreItems("arrow", 8);
    Player p;

    @BeforeEach
    void setUp() {
        HashMap<Integer, Room> rooms = new HashMap<>();
        String[] availableRooms = {"0"};
        rooms.put(8, new Room(8, "gallery", availableRooms, false, 1997, "feather"));
        rooms.get(8).setEntityInRoom(new Entity("Hydras"));
        p = new Player(rooms, rooms.get(8), 0, false);
        entity.setCurrentPosition(p);
    }


    @Test
    void deadHydras() {
        ArrayList<Item> arrows = new ArrayList<>();
        arrows.add(l);
        arrows.add(l);
        arrows.add(l);
        arrows.add(l);
        arrows.add(l);
        p.add(arrows);
        entity.ability();
        assertEquals("Okay, I hope I'm okay", entity.getLoreText());
    }
    @Test
    void deadPlayer() {
        entity.ability();
        assertEquals("I'm dead.", entity.getLoreText2());
    }
}