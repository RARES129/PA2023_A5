import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
package com.example.Compulsory;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @GetMapping
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "John", 100));
        players.add(new Player(2, "Alice", 200));
        players.add(new Player(3, "Bob", 150));
        return players;
    }
}

