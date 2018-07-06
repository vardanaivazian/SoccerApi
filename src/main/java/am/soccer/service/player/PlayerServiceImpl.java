package am.soccer.service.player;

import am.soccer.model.Player;
import am.soccer.service.EndpointProviderService;
import am.soccer.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayersParser parser = new PlayersParser();
    
    @Autowired
    private HttpClientService httpClient;

    @Autowired
    private EndpointProviderService endpointProvider;

    @Override
    public List<Player> loadTeamPlayers(int teamId) {
        String endpoint = endpointProvider.getPlayers(teamId);
        String jsonString = httpClient.get(endpoint);
        return parser.toPlayers(jsonString);
    }
}
