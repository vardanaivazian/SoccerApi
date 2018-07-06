package am.soccer.service.player;

import am.soccer.model.Player;
import am.soccer.service.JsonExtractor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlayerParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExtractor extractor = new JsonExtractor();

    public Player toPlayer(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toPlayer(json);
    }

    public Player toPlayer(JsonObject json) {
        return new Player.PlayerBuilder()
                .setName(parseName(json))
                .setPosition(parsePosition(json))
                .setJerseyNumber(parseJerseyNumber(json))
                .setDateOfBirth(parseDateOfBirth(json))
                .setNationality(parseNationality(json))
                .setContractUntil(parseContractUntil(json))
                .setMarketValue(parseMarketValue(json))
                .build();
    }

    private String parseName(JsonObject json) {
        return extractor.extractString(json, "name");
    }

    private String parsePosition(JsonObject json) {
        return extractor.extractString(json, "position");
    }

    private int parseJerseyNumber(JsonObject json) {
        return extractor.extractInt(json, "jerseyNumber");
    }

    private LocalDate parseDateOfBirth(JsonObject json) {
        return extractor.extractLocalDate(json, "dateOfBirth");
    }

    private String parseNationality(JsonObject json) {
        return extractor.extractString(json, "nationality");
    }

    private LocalDate parseContractUntil(JsonObject json) {
        return extractor.extractLocalDate(json, "contractUntil", LocalDate.MAX);
    }

    private BigDecimal parseMarketValue(JsonObject json) {
        return extractor.extractBigDecimal(json, "marketValue");
    }
    
}
