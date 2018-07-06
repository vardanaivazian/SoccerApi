package am.soccer.service.competition;

import am.soccer.model.Competition;

import java.util.List;

public interface CompetitionService {

    List<Competition> load();

    Competition load(int id);
    
}
