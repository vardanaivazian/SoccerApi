package am.soccer.service.standing;

import am.soccer.service.EndpointProviderService;
import am.soccer.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandingServiceImpl implements StandingService {
    
    @Autowired
    private RestClientService restClientService;
    
    @Autowired
    private EndpointProviderService endpointProviderService;


    @Override
    public String load(int id) {
        return restClientService.get(endpointProviderService.getStandings(id));
    }
}
