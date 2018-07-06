package am.soccer.controller;

import am.soccer.service.SoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoccerRestApiController {
    
    @Autowired
    public SoccerService soccerService;
    
    @GetMapping("/world-cup-2018")
    public String getJson() {
        return soccerService.getSoccerJson();
    }
    
    
    
}
