package am.soccer.service.competition;

import am.soccer.model.Competition;
import am.soccer.service.EndpointProviderService;
import am.soccer.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionsParserService parser;
    
    @Autowired
    private HttpClientService httpClientService;
    
    @Autowired
    private EndpointProviderService endpointProviderService;

    public List<Competition> load() {

        String s = httpClientService.get(endpointProviderService.getCompetitions());
        return parser.toCompetitions(s);
    }

    public Competition load(int id) {
        String endpoint = endpointProviderService.getCompetition(id);
        String s = httpClientService.get(endpoint);
        return parser.toCompetition(s);
    }
    
}
