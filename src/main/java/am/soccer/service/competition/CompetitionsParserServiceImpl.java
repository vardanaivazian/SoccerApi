package am.soccer.service.competition;

import am.soccer.model.Competition;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CompetitionsParserServiceImpl implements CompetitionsParserService {
    private final JsonParser jsonParser = new JsonParser();
    private final CompetitionParser competitionParser = new CompetitionParser();

    @Override
    public List<Competition> toCompetitions(String jsonString) {
        JsonElement element = jsonParser.parse(jsonString);
        if (element.isJsonArray())
            return toCompetitions(element.getAsJsonArray());
        return toCompetitions(element.getAsJsonObject());
    }

    @Override
    public Competition toCompetition(String jsonString) {
        return competitionParser.toCompetition(jsonString);
    }

    private List<Competition> toCompetitions(JsonArray array) {
        List<Competition> competitions = new ArrayList<>();
        array.forEach(item -> competitions.add(toCompetition(item.getAsJsonObject())));
        return competitions;
    }

    private List<Competition> toCompetitions(JsonObject json) {
        return Collections.singletonList(toCompetition(json));
    }

    private Competition toCompetition(JsonObject json) {
        return competitionParser.toCompetition(json);
    }

}
