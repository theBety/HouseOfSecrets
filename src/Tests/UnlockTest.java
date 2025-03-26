package Tests;

import Commands.Unlock;
import Items.LoreItems;
import Player.Player;
import World.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnlockTest {
    Player p;
    Unlock u = new Unlock();
    HashMap<Integer, Room> rooms = new HashMap<>();

    @BeforeEach
    void setUp() {
        String[] availableRooms = {"2"};
        String[] availableRooms2 = {"1", "3"};
        rooms.put(1, new Room(1, "basement", availableRooms, false, 1620, "diary"));
        rooms.put(2, new Room(2, "hall", availableRooms2, true, 0, null));
        rooms.put(3, new Room(3, "living", availableRooms2, true, 1928, null));
    }

    @Test
    void unlockHallDoor() {
        p = new Player(rooms, rooms.get(2), 0, false);
        p.getInventory().add(new LoreItems("key", 2));
        u.setCurrentPosition(p);
        String result = u.execute();
        assertEquals("YOU DID IT. Now run. Run as fast as you can. And your friends? Well, you will never see them again. " +
                "Why? because they are DEAD.", result);
    }
    @Test
    void dontHaveKey() {
        p = new Player(rooms, rooms.get(2), 0, false);
        u.setCurrentPosition(p);
        String result = u.execute();
        assertEquals("You don't have the key", result);
    }
    @Test
    void invalidInput() {
        p = new Player(rooms, rooms.get(1), 0, false);
        u.setCurrentPosition(p);
        String input = "hey\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        u.setSc(scanner);
        String result = u.execute();
        assertEquals("Invalid Input", result);
    }
    @Test
    void wrongPassword() {
        p = new Player(rooms, rooms.get(3), 0, false);
        u.setCurrentPosition(p);
        String input = "1928\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        u.setSc(scanner);
        String result = u.execute();
        assertEquals("Room is unlocked.", result);

    }
}