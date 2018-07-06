package am.soccer.controller;

import am.soccer.service.FootballDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootballDataRestApiController {

    @Autowired
    public FootballDataService footballDataService;

    @GetMapping("/competitions")
    public String competitions() {
        return footballDataService.getCompetition();
    }
    
    @GetMapping("/competitions/{id}")
    public String competitions(@PathVariable String id) {
        return footballDataService.getCompetition(id);
    }
    
}
