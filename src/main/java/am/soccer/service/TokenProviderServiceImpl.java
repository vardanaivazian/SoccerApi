package am.soccer.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Service
public class TokenProviderServiceImpl implements TokenProviderService {

    private static final String TOKEN_VARIABLE_NAME = "YOUR_TOKEN";

    @Override
    public String getToken() {
        /*Map<String, String> environmentVariables = System.getenv();
        if (!environmentVariables.containsKey(TOKEN_VARIABLE_NAME))
            return EMPTY;

        return environmentVariables.get(TOKEN_VARIABLE_NAME);*/
        return TOKEN_VARIABLE_NAME;
    }

    @Override
    public boolean hasToken() {
        String token = getToken();
        return StringUtils.isNotEmpty(token);
    }

}
