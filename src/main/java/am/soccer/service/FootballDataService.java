package am.soccer.service;

public interface FootballDataService {
    String getCompetition();
    String getCompetition(String id);
    String getCompetitionTeams(String competitionId);
}
