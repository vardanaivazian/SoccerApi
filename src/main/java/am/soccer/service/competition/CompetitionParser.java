package am.soccer.service.competition;

import am.soccer.model.Competition;
import am.soccer.service.JsonExtractor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDateTime;

public class CompetitionParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

    public Competition toCompetition(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toCompetition(json);
    }

    public Competition toCompetition(JsonObject json) {
        return new Competition.CompetitionBuilder()
                .setSelfLink(parseSelfLink(json))
                .setTeamsLink(parseTeamsLink(json))
                .setFixturesLink(parseFixturesLink(json))
                .setLeagueTableLink(parseLeagueTableLink(json))
                .setId(parseId(json))
                .setCaption(parseName(json))
                .setLeague(parseLeague(json))
                .setYear(parseYear(json))
                .setCurrentMatchDay(parseCurrentMatchday(json))
                .setNumberOfMatchDays(parseNumberOfMatchdays(json))
                .setNumberOfTeams(parseNumberOfTeams(json))
                .setNumberOfGames(parseNumberOfGames(json))
                .setLastUpdated(parseLastUpdated(json))
                .build();
    }

    private String parseSelfLink(JsonObject json) {
        return extractor.extractLink(json, "self");
    }

    private String parseTeamsLink(JsonObject json) {
        return extractor.extractLink(json, "teams");
    }

    private String parseFixturesLink(JsonObject json) {
        return extractor.extractLink(json, "fixtures");
    }

    private String parseLeagueTableLink(JsonObject json) {
        return extractor.extractLink(json, "leagueTable");
    }

    private int parseId(JsonObject json) {
        return extractor.extractInt(json, "id");
    }

    private String parseName(JsonObject json) {
        return extractor.extractString(json, "caption");
    }

    private String parseLeague(JsonObject json) {
        return extractor.extractString(json, "league");
    }

    private String parseYear(JsonObject json) {
        return extractor.extractString(json, "year");
    }

    private int parseCurrentMatchday(JsonObject json) {
        return extractor.extractInt(json, "currentMatchday");
    }

    private int parseNumberOfMatchdays(JsonObject json) {
        return extractor.extractInt(json, "numberOfMatchdays");
    }

    private int parseNumberOfTeams(JsonObject json) {
        return extractor.extractInt(json, "numberOfTeams");
    }

    private int parseNumberOfGames(JsonObject json) {
        return extractor.extractInt(json, "numberOfGames");
    }

    private LocalDateTime parseLastUpdated(JsonObject json) {
        return extractor.extractDateTime(json, "lastUpdated");
    }


}
