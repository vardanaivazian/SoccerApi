package am.soccer.service.team;

import am.soccer.model.Team;
import am.soccer.service.EndpointProviderService;
import am.soccer.service.HttpClientService;
import am.soccer.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamsParser parser = new TeamsParser();
    
    @Autowired
    private RestClientService restClientService;

    @Autowired
    private EndpointProviderService endpointProviderService;


    @Override
    public List<Team> load() {
        String endpoint = endpointProviderService.getTeams();
        String jsonString = restClientService.get(endpoint);
        return parser.toTeams(jsonString);
    }

    @Override
    public List<Team> loadCompetitionTeams(int competitionId) {
        String endpoint = endpointProviderService.getTeams(competitionId);
        String jsonString = restClientService.get(endpoint);
        return parser.toTeams(jsonString);
    }

    @Override
    public Team load(int teamId) {
        String endpoint = endpointProviderService.getTeam(teamId);
        String jsonString = restClientService.get(endpoint);
        return parser.toTeam(jsonString);
    }
}
