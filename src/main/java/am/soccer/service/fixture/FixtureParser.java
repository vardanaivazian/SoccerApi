package am.soccer.service.fixture;

import am.soccer.model.Fixture;
import am.soccer.model.FixtureStatus;
import am.soccer.service.JsonExtractor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDateTime;

public class FixtureParser {

    private static final String FIELD_NAME = "fixture";

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

    public Fixture toFixture(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        if (json.has(FIELD_NAME))
            return toFixture(json.get(FIELD_NAME).getAsJsonObject());
        return toFixture(json);
    }

    public Fixture toFixture(JsonObject json) {
        return new Fixture.FixtureBuilder()
                .setSelfLink(parseSelfLink(json))
                .setCompetitionLink(parseCompetitionLink(json))
                .setHomeTeamLink(parseHomeTeamLink(json))
                .setAwayTeamLink(parseAwayTeamLink(json))
                .setDate(parseDate(json))
                .setStatus(parseFixtureStatus(json))
                .setMatchDay(parseMatchDay(json))
                .setHomeTeamName(parseHomeTeamName(json))
                .setAwayTeamName(parseAwayTeamName(json))
                .setHomeTeamGoals(parseHomeTeamGoals(json))
                .setAwayTeamGoals(parseAwayTeamGoals(json))
                .setOdds(parseOdds(json))
                .build();
    }

    private String parseSelfLink(JsonObject json) {
        return extractor.extractLink(json, "self");
    }

    private String parseCompetitionLink(JsonObject json) {
        return extractor.extractLink(json, "competition");
    }

    private String parseHomeTeamLink(JsonObject json) {
        return extractor.extractLink(json, "homeTeam");
    }

    private String parseAwayTeamLink(JsonObject json) {
        return extractor.extractLink(json, "awayTeam");
    }

    private LocalDateTime parseDate(JsonObject json) {
        return extractor.extractDateTime(json, "date");
    }

    private FixtureStatus parseFixtureStatus(JsonObject json) {
        return extractor.extractFixtureStatus(json, "status");
    }

    private int parseMatchDay(JsonObject json) {
        return extractor.extractInt(json, "matchday");
    }

    private String parseHomeTeamName(JsonObject json) {
        return extractor.extractString(json, "homeTeamName");
    }

    private String parseAwayTeamName(JsonObject json) {
        return extractor.extractString(json, "awayTeamName");
    }

    private int parseHomeTeamGoals(JsonObject json) {
        return extractor.extractResultGoals(json, "goalsHomeTeam");
    }

    private int parseAwayTeamGoals(JsonObject json) {
        return extractor.extractResultGoals(json, "goalsAwayTeam");
    }

    private String parseOdds(JsonObject json) {
        return extractor.extractString(json, "odds");
    }
    
}
