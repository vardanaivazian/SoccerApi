package am.soccer.service.team;

import am.soccer.model.Team;

import java.util.List;

public interface TeamService {

    /**
     * List all teams
     * 
     * @return (Team) List all teams
     */
    List<Team> load();

    /**
     * List all teams for a particular competition.
     * 
     * @param competitionId (int) is id of competition
     *                      
     * @return (List< Team >) List all teams for a particular competition                
     */
    List<Team> loadCompetitionTeams(int competitionId);

    /**
     * Team by id
     * 
     * @param teamId (int) is id of team
     * 
     * @return (List< Team > ) team by team id
     */
    Team load(int teamId);
}
