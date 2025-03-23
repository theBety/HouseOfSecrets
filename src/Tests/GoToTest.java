package Tests;

import Commands.GoTo;
import World.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Player.Player;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GoToTest {
    Player p;
    GoTo goTo = new GoTo();

@BeforeEach
    void setUp(){
    HashMap<Integer, Room> rooms = new HashMap<>();
    String[] availableRooms = {"2"};
    String[] availableRooms2 = {"1", "3"};
    rooms.put(1, new Room(1, "basement", availableRooms, false, 1620, "diary"));
    rooms.put(2, new Room(2, "hall", availableRooms2, true, 0, null));
    p = new Player(rooms, rooms.get(1), 0, false);
    goTo.setCurrentPosition(p);
    }

    @Test
    void executeRightInput() {
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        goTo.setSc(scanner);
        String result = goTo.execute();
        assertEquals("Locked room.", result);
    }
    @Test
    void executeWrongInput() {
        String input = "abc\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        goTo.setSc(scanner);
        String result = goTo.execute();
        assertEquals("Invalid Input", result);
    }
}