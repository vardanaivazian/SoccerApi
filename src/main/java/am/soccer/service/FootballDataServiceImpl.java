package am.soccer.service;

import am.soccer.service.competition.CompetitionService;
import am.soccer.service.fixture.FixtureService;
import am.soccer.service.player.PlayerService;
import am.soccer.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballDataServiceImpl implements FootballDataService {
    
    private static final String COMPETITIONS_URL = "http://api.football-data.org/v2/competitions/";

    @Autowired
    private CompetitionService competitionClient;
    
    @Autowired
    private TeamService teamClient;
    
    @Autowired
    private PlayerService playerClient;
    
    @Autowired
    private FixtureService fixtureClient;
    
    @Autowired
    HttpClientService httpClientService;

    @Override
    public String getCompetition() {

        return httpClientService.get(COMPETITIONS_URL);
    }

    @Override
    public String getCompetition(String id) {

        return httpClientService.get(COMPETITIONS_URL + id);
    }

    @Override
    public String getCompetitionTeams(String competitionId) {
        return httpClientService.get(COMPETITIONS_URL + competitionId + "/teams");
    }
}
