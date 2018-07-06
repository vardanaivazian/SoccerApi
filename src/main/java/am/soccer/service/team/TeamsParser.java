package am.soccer.service.team;

import am.soccer.model.Team;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamsParser {

    private static final String FIELD_NAME = "teams";

    private final JsonParser jsonParser = new JsonParser();
    private final TeamParser teamParser = new TeamParser();

    public List<Team> toTeams(String jsonString) {
        JsonElement element = jsonParser.parse(jsonString);
        JsonObject object = element.getAsJsonObject();
        if (object.has(FIELD_NAME))
            return toTeams(object.get(FIELD_NAME).getAsJsonArray());
        return toTeams(object);
    }

    public Team toTeam(String jsonString) {
        return teamParser.toTeam(jsonString);
    }

    private List<Team> toTeams(JsonArray array) {
        List<Team> competitions = new ArrayList<>();
        array.forEach(item -> competitions.add(toTeam(item.getAsJsonObject())));
        return competitions;
    }

    private List<Team> toTeams(JsonObject json) {
        return Collections.singletonList(toTeam(json));
    }

    private Team toTeam(JsonObject json) {
        return teamParser.toTeam(json);
    }
    
}
