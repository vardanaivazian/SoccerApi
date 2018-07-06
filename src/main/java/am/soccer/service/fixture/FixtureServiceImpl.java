package am.soccer.service.fixture;

import am.soccer.model.Fixture;
import am.soccer.service.EndpointProviderService;
import am.soccer.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixtureServiceImpl implements FixtureService {

    private final FixturesParser parser = new FixturesParser();
    
    @Autowired
    private HttpClientService httpClient;
    
    @Autowired
    private EndpointProviderService endpointProvider;

    @Override
    public List<Fixture> load() {
        String jsonString = httpClient.get(endpointProvider.getFixtures());
        return parser.toFixtures(jsonString);
    }

    @Override
    public Fixture load(int fixtureId) {
        String endpoint = endpointProvider.getFixture(fixtureId);
        String jsonString = httpClient.get(endpoint);
        return parser.toFixture(jsonString);
    }


}
