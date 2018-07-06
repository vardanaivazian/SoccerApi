package am.soccer.service.team;

import am.soccer.model.Team;
import am.soccer.service.JsonExtractor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.math.BigDecimal;

public class TeamParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();
    private final TeamUrlConverter teamUrlConverter = new TeamUrlConverter();

    public Team toTeam(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toTeam(json);
    }

    public Team toTeam(JsonObject json) {
        return new Team.TeamBuilder()
                .setSelfLink(parseSelfUrl(json))
                .setFixturesLink(parseFixturesUrl(json))
                .setPlayersLink(parsePlayersUrl(json))
                .setName(parseName(json))
                .setShortName(parseShortName(json))
                .setCode(parseCode(json))
                .setCrestUrl(parseCrestUrl(json))
                .setId(parseId(json))
                .setSquadMarketValue(parseSquadMarketValue(json))
                .build();
    }

    private int parseId(JsonObject json) {
        String selfUrl = parseSelfUrl(json);
        return teamUrlConverter.toId(selfUrl);
    }

    private String parseName(JsonObject json) {
        return extractor.extractString(json, "name");
    }

    private String parseShortName(JsonObject json) {
        return extractor.extractString(json, "shortName");
    }

    private String parseCode(JsonObject json) {
        return extractor.extractString(json, "code");
    }

    private String parseCrestUrl(JsonObject json) {
        return extractor.extractString(json, "crestUrl");
    }

    private BigDecimal parseSquadMarketValue(JsonObject json) {
        return extractor.extractBigDecimal(json, "squadMarketValue");
    }

    private String parseSelfUrl(JsonObject json) {
        return extractor.extractLink(json, "self");
    }

    private String parseFixturesUrl(JsonObject json) {
        return extractor.extractLink(json, "fixtures");
    }

    private String parsePlayersUrl(JsonObject json) {
        return extractor.extractLink(json, "players");
    }
    
}
