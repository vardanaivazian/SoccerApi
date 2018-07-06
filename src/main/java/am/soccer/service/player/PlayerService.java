package am.soccer.service.player;

import am.soccer.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> loadTeamPlayers(int teamId);
    
}
