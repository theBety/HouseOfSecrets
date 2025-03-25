package Tests;

import Commands.TalkTo;
import Player.Player;
import World.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TalkToTest {
    Player p;
    TalkTo t = new TalkTo();
    HashMap<Integer, Room> rooms = new HashMap<>();

    @BeforeEach
    void setUp() {
        String[] availableRooms = {"2"};
        String[] availableRooms2 = {"2", "9", "8", "4"};
        rooms.put(1, new Room(1, "basement", availableRooms, false, 1620, "diary"));
        rooms.put(3, new Room(3, "living", availableRooms2, false, 1928, null));
    }

    @Test
    void canTalk() {
        p = new Player(rooms, rooms.get(3), 0, false);
        t.setCurrentPosition(p);
        String result = t.execute();
        assertEquals("Hello, I want to give my beautiful wife some flowers. Could you help me with that?" +
                "I need some vase, flowers and string to tie them up. Thank you.", result);
    }

    @Test
    void cantTalk() {
        p = new Player(rooms, rooms.get(1), 0, false);
        t.setCurrentPosition(p);
        String result = t.execute();
        assertEquals("You can't talk to anyone", result);
    }
}