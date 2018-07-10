package am.soccer.service.player;

import am.soccer.model.Player;
import am.soccer.service.JsonExtractor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDateTime;

public class PlayerParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

    public Player toPlayer(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toPlayer(json);
    }

    public Player toPlayer(JsonObject json) {
        return Player.builder()
                .id(parseId(json))
                .name(parseName(json))
                .position(parsePosition(json))
                .dateOfBirth(parseDateOfBirth(json))
                .countryOfBirth(parseCountryOfBirth(json))
                .role(parseRole(json))
                .nationality(parseNationality(json))
                .build();
    }

    private int parseId(JsonObject json) {
        return extractor.extractInt(json, "id");
    }

    private String parseName(JsonObject json) {
        return extractor.extractString(json, "name");
    }

    private String parsePosition(JsonObject json) {
        return extractor.extractString(json, "position");
    }

    private LocalDateTime parseDateOfBirth(JsonObject json) {
        return extractor.extractDateTime(json, "dateOfBirth");
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
