package am.soccer.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TokenProviderServiceImpl implements TokenProviderService {

    private static final String TOKEN = "YOUR_TOKEN";

    @Override
    public String getToken() {
        return TOKEN;
    }

    @Override
    public boolean hasToken() {
        String token = getToken();
        return StringUtils.isNotEmpty(token);
    }
}
