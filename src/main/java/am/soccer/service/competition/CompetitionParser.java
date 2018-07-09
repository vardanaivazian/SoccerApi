package am.soccer.service.competition;

import am.soccer.model.Area;
import am.soccer.model.Competition;
import am.soccer.model.Season;
import am.soccer.service.JsonExtractor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompetitionParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

    public Competition toCompetition(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toCompetition(json);
    }

    public Competition toCompetition(JsonObject json) {
        System.out.println("json object: " + json.toString());
        return new Competition.CompetitionBuilder()
                .Id(parseId(json))
                .Area(parseArea(json))
                .Name(parseName(json))
                .Plan(parsePlan(json))
                .Code(parseCode(json))
                .CurrentSeason(parseSeason(extractor.extractJson(json, "currentSeason")))
                .NumberOfAvailableSeasons(parseNumberOfAvailableSeasons(json))
                .Seasons(parseSeasons(json))
                .LastUpdated(parseLastUpdated(json))
                .build();
    }

    private int parseId(JsonObject json) {
        return extractor.extractInt(json, "id");
    }

    private Area parseArea(JsonObject json) {
        JsonObject area = extractor.extractJson(json, "area");
        return new Area.AreaBuilder()
                .Id(parseId(area))
                .Name(parseName(area))
                .build();
    }

    private Season parseSeason(JsonObject json) {
        return new Season.SeasonBuilder()
                .Id(parseId(json))
                .CurrentMatchDay(parseCurrentMatchDay(json))
                .StartDate(parseStartDate(json))
                .EndDate(parseEndDate(json))
                .build();
    }

    private List<Season> parseSeasons(JsonObject json) {
        List<Season> seasons = new ArrayList<>();
        List<JsonObject> seasonsJson = extractor.extractList(json, "seasons");
        seasonsJson.forEach(item -> seasons.add(parseSeason(item)));
        return seasons;
    }


    private int parseNumberOfAvailableSeasons(JsonObject json) {
        return extractor.extractInt(json, "numberOfAvailableSeasons");
    }
    
    private String parseName(JsonObject json) {
        return extractor.extractString(json, "name");
    }

    private String parsePlan(JsonObject json) {
        return extractor.extractString(json, "plan");
    }

    private String parseCode(JsonObject json) {
        return extractor.extractString(json, "code");
    }
    
    private LocalDate parseStartDate(JsonObject json) {
        return extractor.extractLocalDate(json, "startDate");
    }

    private LocalDate parseEndDate(JsonObject json) {
        return extractor.extractLocalDate(json, "endDate");
    }


    private int parseCurrentMatchDay(JsonObject json) {
        return extractor.extractInt(json, "currentMatchDay");
    }

    private LocalDateTime parseLastUpdated(JsonObject json) {
        return extractor.extractDateTime(json, "lastUpdated");
    }


}
