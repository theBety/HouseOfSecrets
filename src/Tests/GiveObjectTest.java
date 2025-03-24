package Tests;

import Commands.GiveObject;
import Items.LoreItems;
import Player.Player;
import World.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GiveObjectTest {
    Player p;
    GiveObject g = new GiveObject();

    @BeforeEach
    void setUp() {
        HashMap<Integer, Room> rooms = new HashMap<>();
        String[] availableRooms = {"2", "9", "8", "4"};
        String[] availableRooms2 = {"1", "3"};
        rooms.put(3, new Room(3, "living", availableRooms, false, 1928, "mirror"));
        rooms.put(2, new Room(2, "hall", availableRooms2, true, 0, null));
        p = new Player(rooms, rooms.get(3), 0, false);
        g.setCurrentPosition(p);
    }

    void setUpRight() {
        p.getInventory().add(new LoreItems("flower", 3));
        p.getInventory().add(new LoreItems("flower", 3));
        p.getInventory().add(new LoreItems("flower", 3));
        p.getInventory().add(new LoreItems("flower", 3));
        p.getInventory().add(new LoreItems("flower", 3));
        p.getInventory().add(new LoreItems("vase", 3));
        p.getInventory().add(new LoreItems("string", 3));
    }
    void setUpWrong() {
        p.getInventory().add(new LoreItems("flower", 3));
        p.getInventory().add(new LoreItems("flower", 3));
        p.getInventory().add(new LoreItems("vase", 3));
        p.getInventory().add(new LoreItems("string", 3));
    }

    @Test
    void executeRightInput() {
        String input = "yes\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        g.setSc(scanner);
        setUp();
        setUpRight();
        String answer = g.execute();
        assertEquals("You gave him all flowers! How sweet of you!", answer);
    }


    @Test
    void executeWrongInput() {
        String input = "idc\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        g.setSc(scanner);
        setUp();
        setUpWrong();
        String answer = g.execute();
        assertEquals("You don't have enough flowers!", answer);
    }
}