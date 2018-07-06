package am.soccer.service.team;

import am.soccer.model.Team;
import am.soccer.service.EndpointProviderService;
import am.soccer.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamsParser parser = new TeamsParser();
    
    @Autowired
    private HttpClientService httpClient;
    
    @Autowired
    private EndpointProviderService endpointProvider;
    
    
    @Override
    public List<Team> loadCompetitionTeams(int competitionId) {
        String endpoint = endpointProvider.getTeams(competitionId);
        String jsonString = httpClient.get(endpoint);
        return parser.toTeams(jsonString);
    }

    @Override
    public Team load(int teamId) {
        String endpoint = endpointProvider.getTeam(teamId);
        String jsonString = httpClient.get(endpoint);
        return parser.toTeam(jsonString);
    }
}
