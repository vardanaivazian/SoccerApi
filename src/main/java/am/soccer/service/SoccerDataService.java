package am.soccer.service;

import am.soccer.model.Competition;
import am.soccer.model.Team;

import java.util.List;

public interface SoccerDataService {
    
    List<Competition> competitions();
    
    Competition competition(int id);
    
    String standings(int id);
    
    List<Team> teams();
    
    List<Team> competitionTeams(int id);
    
    Team team(int id);
}
