package com.simulators.football.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulators.football.models.Player;
import com.simulators.football.models.Team;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class MainController {
    
    @GetMapping("/getPlayers")
    public Team getPlayers() {
        Player p1 = new Player("Ahmed", 98);
        Player p2 = new Player("Ahmed", 98);
        Player p3 = new Player("Ahmed", 98);
        Player p4 = new Player("Ahmed", 98);
        Player p5 = new Player("Ahmed", 98);
        Player p6 = new Player("Ahmed", 98);
        List<Player> players = List.of(p1, p2, p3, p4, p5, p6);
        return new Team(players);
    }
}
