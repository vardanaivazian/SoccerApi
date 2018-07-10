package am.soccer.controller;

import am.soccer.model.Competition;
import am.soccer.model.Team;
import am.soccer.service.SoccerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SoccerDataRestApiController {

    @Autowired
    public SoccerDataService soccerDataService;
    

    @GetMapping("/competitions")
    public List<Competition> competitions() {
        return soccerDataService.competitions();
    }
    
    @GetMapping("/competitions/{id}")
    public Competition competition(@PathVariable String id) {
        return soccerDataService.competition(Integer.parseInt(id));
    }
    
    @GetMapping("/competitions/{id}/standings")
    public String standings(@PathVariable String id) {
        return soccerDataService.standings(Integer.parseInt(id));
    }
    
    @GetMapping("/teams")
    public List<Team> teams() {
        return soccerDataService.teams();
    }
    
    @GetMapping("/competitions/{id}/teams")
    public List<Team> competitionTeams(@PathVariable String id) {
        return soccerDataService.competitionTeams(Integer.parseInt(id));
    }
    
    @GetMapping("/teams/{id}")
    public Team team(@PathVariable String id) {
        return soccerDataService.team(Integer.parseInt(id));
    }
}
