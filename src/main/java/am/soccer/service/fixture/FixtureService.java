package am.soccer.service.fixture;

import am.soccer.model.Fixture;

import java.util.List;

public interface FixtureService {

    List<Fixture> load();

    Fixture load(int fixtureId);
    
}
