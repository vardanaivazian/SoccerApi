package am.soccer.controller;

import am.soccer.model.Competition;
import am.soccer.model.Team;
import am.soccer.service.FootballDataService;
import am.soccer.service.competition.CompetitionService;
import am.soccer.service.standing.StandingService;
import am.soccer.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FootballDataRestApiController {

    @Autowired
    public FootballDataService footballDataService;
    
    @Autowired
    private CompetitionService competitionService;
    
    @Autowired
    private StandingService standingService;
    
    @Autowired
    private TeamService teamService;

    @GetMapping("/competitions")
    public List<Competition> competitions() {
        return competitionService.load();
    }
    
    @GetMapping("/competitions/{id}")
    public Competition competition(@PathVariable String id) {
        return competitionService.load(Integer.parseInt(id));
    }
    
    @GetMapping("/competitions/{id}/standings")
    public String standings(@PathVariable String id) {
        return standingService.load(Integer.parseInt(id));
    }
    
    @GetMapping("/teams")
    public List<Team> teams() {
        return teamService.load();
    }
    
    @GetMapping("/competitions/{id}/teams")
    public List<Team> competitionTeams(@PathVariable String id) {
        return teamService.loadCompetitionTeams(Integer.parseInt(id));
    }
    
    @GetMapping("/teams/{id}")
    public Team team(@PathVariable String id) {
        return teamService.load(Integer.parseInt(id));
    }
}
