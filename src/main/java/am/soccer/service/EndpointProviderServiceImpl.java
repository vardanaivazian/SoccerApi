package am.soccer.service;

import org.springframework.stereotype.Service;

@Service
public class EndpointProviderServiceImpl implements EndpointProviderService{

    private static final String BASE_URL = "http://api.football-data.org/v2/";

    @Override
    public String getBase() {
        return BASE_URL;
    }

    @Override
    public String getCompetitions() {
        return BASE_URL + "competitions/";
    }

    @Override
    public String getCompetition(int competitionId) {
        return getCompetitions() + competitionId + "/";
    }
    
    @Override
    public String getStandings(int competitionId) {
        return getCompetitions() + competitionId + "/standings";
    }

    @Override
    public String getTeams() {
        return BASE_URL + "teams/";
    }

    @Override
    public String getTeams(int competitionId) {
        return getCompetition(competitionId) + "teams/";
    }

    @Override
    public String getTeam(int teamId) {
        return getTeams() + teamId + "/";
    }

    @Override
    public String getPlayers(int teamId) {
        return getTeam(teamId) + "players/";
    }

    @Override
    public String getFixtures() {
        return BASE_URL + "fixtures/";
    }

    @Override
    public String getFixture(int fixtureId) {
        return getFixtures() + fixtureId + "/";
    }

}
