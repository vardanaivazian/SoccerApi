package am.soccer.service.team;

import am.soccer.model.Area;
import am.soccer.model.Player;
import am.soccer.model.Team;
import am.soccer.service.JsonExtractor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TeamParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

    public Team toTeam(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toTeam(json);
    }

    public Team toTeam(JsonObject json) {
        return Team.builder()
                .id(parseId(json))
                .area(parseArea(json))
                .name(parseName(json))
                .shortName(parseShortName(json))
                .tla(parseTla(json))
                .address(parseAddress(json))
                .phone(parsePhone(json))
                .website(parseWebsite(json))
                .email(parseEmail(json))
                .founded(parseFounded(json))
                .venue(parseVenue(json))
                .clubColors(parseClubColors(json))
                .squad(parseSquad(json))
                .lastUpdated(parseLastUpdated(json))
                .build();
    }

    private int parseId(JsonObject json) {
        return extractor.extractInt(json, "id");
    }
    
    private Area parseArea(JsonObject json) {
        JsonObject area = extractor.extractJson(json, "area");
        return Area.builder()
                .id(parseId(area))
                .name(parseName(area))
                .build();
    }


    private String parseName(JsonObject json) {
        return extractor.extractString(json, "name");
    }

    private String parseShortName(JsonObject json) {
        return extractor.extractString(json, "shortName");
    }
    
    private String parseTla(JsonObject json) {
        return extractor.extractString(json, "tla");
    }
    
    private String parseAddress(JsonObject json) {
        return extractor.extractString(json, "address");
    }
    
    private String parsePhone(JsonObject json) {
        return extractor.extractString(json, "phone");
    }
    
    private String parseWebsite(JsonObject json) {
        return extractor.extractString(json, "website");
    }
    
    private String parseEmail(JsonObject json) {
        return extractor.extractString(json, "email");
    }
    
    private int parseFounded(JsonObject json) {
        return extractor.extractInt(json, "founded");
    }

    private String parseVenue(JsonObject json) {
        return extractor.extractString(json, "venue");
    }

    private String parseClubColors(JsonObject json) {
        return extractor.extractString(json, "clubColors");
    }

    private List<Player> parseSquad(JsonObject json) {
        List<Player> squad = new ArrayList<>();
        List<JsonObject> seasonsJson = extractor.extractList(json, "squad");
        seasonsJson.forEach(item -> squad.add(parsePlayer(item)));
        return squad;
    }
    
    private Player parsePlayer(JsonObject json) {
        return Player.builder()
                .id(parseId(json))
                .name(parseName(json))
                .nationality(parseNationality(json))
                .countryOfBirth(parseCountryOfBirth(json))
                .dateOfBirth(parseDateOfBirth(json))
                .position(parsePosition(json))
                .role(parseRole(json))
                .build();
    }


    private String parsePosition(JsonObject json) {
        return extractor.extractString(json, "position");
    }

    private LocalDateTime parseDateOfBirth(JsonObject json) {
        return extractor.extractDateTime(json, "dateOfBirth");
    }
    
    private LocalDateTime parseLastUpdated(JsonObject json) {
        return extractor.extractDateTime(json, "lastUpdated");
    }

    private String parseCountryOfBirth(JsonObject json) {
        return extractor.extractString(json, "countryOfBirth");
    }

    private String parseRole(JsonObject json) {
        return extractor.extractString(json, "role");
    }

    private String parseNationality(JsonObject json) {
        return extractor.extractString(json, "nationality");
    }
}
