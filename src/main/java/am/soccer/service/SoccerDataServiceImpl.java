package am.soccer.service;

import am.soccer.model.Competition;
import am.soccer.model.Team;
import am.soccer.service.competition.CompetitionService;
import am.soccer.service.standing.StandingService;
import am.soccer.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoccerDataServiceImpl implements SoccerDataService {
    
    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private StandingService standingService;

    @Autowired
    private TeamService teamService;


    @Override
    public List<Competition> competitions() {
        return competitionService.load();
    }

    @Override
    public Competition competition(int id) {
        return competitionService.load(id);
    }

    @Override
    public String standings(int id) {
        return standingService.load(id);
    }

    @Override
    public List<Team> teams() {
        return teamService.load();
    }

    @Override
    public List<Team> competitionTeams(int id) {
        return teamService.loadCompetitionTeams(id);
    }

    @Override
    public Team team(int id) {
        return teamService.load(id);
    }
}
