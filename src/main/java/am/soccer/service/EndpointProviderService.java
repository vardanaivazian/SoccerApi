package am.soccer.service;

public interface EndpointProviderService {
    String getBase();

    String getCompetitions();

    String getCompetition(int competitionId);
    
    String getStandings(int competitionId);

    String getTeams(int competitionId);

    String getTeam(int teamId);

    String getPlayers(int teamId);

    String getFixtures();

    String getFixture(int fixtureId);
}
