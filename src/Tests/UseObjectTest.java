package Tests;

import Commands.UseObject;
import Items.LoreItems;
import Player.Player;
import World.Room;
import World.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UseObjectTest {
    Player p;
    UseObject u = new UseObject();
    HashMap<Integer, Room> rooms = new HashMap<>();

    @BeforeEach
    void setUp() {
        String[] availableRooms = {"2"};
        String[] availableRooms2 = {"1", "3"};
        rooms.put(1, new Room(1, "basement", availableRooms, false, 1620, "diary"));
        rooms.put(2, new Room(2, "hall", availableRooms2, true, 0, null));
        rooms.put(3, new Room(3, "hall", availableRooms2, true, 0, null));
        rooms.get(3).getTasksInRoom().add(new Task("string", "Description", "clue"));
        p = new Player(rooms, rooms.get(3), 0, false);
        u.setCurrentPosition(p);
    }

    @Test
    void rightInput() {
        p.getInventory().add(new LoreItems("string", 3));
        String input = "String\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        u.setSc(scanner);
        String result = u.execute();
        assertEquals("There’s something written. It looks like some kind of code clue: clue", result);
    }

    @Test
    void emptyInventory() {
        String result = u.execute();
        assertEquals("You don't have any items in your inventory", result);
    }
    @Test
    void cantUseObject() {
        p.getInventory().add(new LoreItems("item", 5));
        String input = "Item\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        u.setSc(scanner);
        String result = u.execute();
        assertEquals("You can't use this object", result);
    }
    @Test
    void itemDoesntExist() {
        p.getInventory().add(new LoreItems("testItem", 5));
        String input = "randomItem\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        u.setSc(scanner);
        String result = u.execute();
        assertEquals("You don't have any such object", result);
    }
}