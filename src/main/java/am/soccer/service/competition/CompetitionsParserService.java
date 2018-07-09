package am.soccer.service.competition;

import am.soccer.model.Competition;

import java.util.List;

public interface CompetitionsParserService {

    List<Competition> toCompetitions(String jsonString);

    Competition toCompetition(String jsonString);
    
}
