package am.soccer.service.competition;

import am.soccer.model.Competition;

import java.util.List;

public interface CompetitionsParserService {

    public List<Competition> toCompetitions(String jsonString);

    public Competition toCompetition(String jsonString);
    
}
