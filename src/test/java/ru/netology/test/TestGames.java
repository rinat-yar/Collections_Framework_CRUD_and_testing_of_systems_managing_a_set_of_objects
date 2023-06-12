package ru.netology.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.NotRegisteredException;
import ru.netology.Player;
import ru.netology.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGames {

    @Test
    public void winTest() {
        Game game = new Game();
        Player player1 = new Player(1, "User_1", 6);
        Player player2 = new Player(2, "User_2", 4);
        game.register(player1);
        game.register(player2);
        int actual = game.round("User_1", "User_2");
        int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void winTest_1() {
        Game game = new Game();
        Player player1 = new Player(1, "User_1", 4);
        Player player2 = new Player(2, "User_2", 6);
        game.register(player1);
        game.register(player2);
        int actual = game.round("User_1", "User_2");
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void drawTest() {
        Game game = new Game();
        Player player1 = new Player(1, "User_1", 4);
        Player player2 = new Player(2, "User_2", 4);
        game.register(player1);
        game.register(player2);
        int actual = game.round("User_1", "User_2");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredTest_1() {
        Game game = new Game();
        Player player1 = new Player(1, "User_1", 4);
        Player player2 = new Player(2, "User_2", 6);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,() ->
                game.round("User_3", "User_2")
        );
    }

    @Test
    public void  notRegisteredTest_2() {
        Game game = new Game();
        Player player1 = new Player(1, "User_1", 4);
        Player player2 = new Player(2, "User_2", 6);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("User_1", "User_3")
        );
    }
    @Test
    public void notRegisteredTest_3() {
        Game game = new Game();
        Player player1 = new Player(1, "User_1", 4);
        Player player2 = new Player(2, "User_2", 6);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("User_3", "User_4")
        );
    }
}