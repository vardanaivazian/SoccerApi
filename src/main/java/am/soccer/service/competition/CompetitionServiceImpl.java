package am.soccer.service.competition;

import am.soccer.model.Competition;
import am.soccer.service.EndpointProviderService;
import am.soccer.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionsParserService parser;
    
    @Autowired
    private EndpointProviderService endpointProviderService;
    
    @Autowired
    private RestClientService restClientService;

    
    
    @Override
    public List<Competition> load() {

        String s = restClientService.get(endpointProviderService.getCompetitions());
        return parser.toCompetitions(s);
    }

    @Override
    public Competition load(int id) {
        String endpoint = endpointProviderService.getCompetition(id);
        String s = restClientService.get(endpoint);
        return parser.toCompetition(s);
    }
}
