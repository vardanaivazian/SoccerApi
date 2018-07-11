package am.soccer.controller;

import am.soccer.service.forldcup.SoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoccerRestApiController {
    
    @Autowired
    public SoccerService soccerService;
    
    @GetMapping("/world-cup/{year}")
    public String getJson(@PathVariable int year) {
        return soccerService.getSoccerJson(year);
    }
}
