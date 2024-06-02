package com.simulators.football.controllers;

import com.simulators.football.controllers.MainController;
import com.simulators.football.models.Player;
import com.simulators.football.models.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MainControllerTest {

    @Test
    void testGetPlayers() {
        // Arrange
        MainController controller = new MainController();

        // Act
        Team team = controller.getPlayers();
        List<Player> players = team.getPlayers();

        // Assert
        Assertions.assertNotNull(team);
        Assertions.assertNotNull(players);
        Assertions.assertEquals(6, players.size());

        for (Player player : players) {
            Assertions.assertEquals("Ahmed", player.getPlayerName());
            Assertions.assertEquals(98, player.getPower());
        }
    }
}