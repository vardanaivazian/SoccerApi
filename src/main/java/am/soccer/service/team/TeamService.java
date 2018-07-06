package am.soccer.service.team;

import am.soccer.model.Team;

import java.util.List;

public interface TeamService {

    List<Team> loadCompetitionTeams(int competitionId);

    Team load(int teamId);
    
}
