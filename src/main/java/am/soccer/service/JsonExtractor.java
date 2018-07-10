package am.soccer.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class JsonExtractor {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private final DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String extractString(JsonObject json, String name) {
        if (!json.has(name))
            return EMPTY;
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return EMPTY;
        return element.getAsString();
    }

    public int extractInt(JsonObject json, String name) {
        if (!json.has(name))
            return 0;
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return 0;
        return element.getAsInt();
    }
    
    public JsonObject extractJson(JsonObject json, String name) {
        if (!json.has(name))
            return null;
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return null;
        return element.getAsJsonObject();
    }
    
    public List<JsonObject> extractList(JsonObject json, String name) {
        if (!json.has(name))
            return new ArrayList<>();
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return new ArrayList<>();

        Type listType = new TypeToken<List<JsonObject>>() {}.getType();
        return new Gson().fromJson(element, listType);
    }

    public BigDecimal extractBigDecimal(JsonObject json, String name) {
        if (!json.has(name))
            return BigDecimal.ZERO;
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return BigDecimal.ZERO;
        return element.getAsBigDecimal();
    }

    public String extractLink(JsonObject json, String name) {
        JsonObject links = json.get("_links").getAsJsonObject();
        JsonObject item = links.get(name).getAsJsonObject();
        return extractString(item, "href");
    }

    public int extractResultGoals(JsonObject json, String name) {
        JsonObject result = json.get("result").getAsJsonObject();
        JsonElement element = result.get(name);
        if (element.isJsonNull())
            return 0;
        return element.getAsInt();
    }

    public LocalDateTime extractDateTime(JsonObject json, String name) {
        if (json.get(name).isJsonNull()) return LocalDateTime.MAX;
        String dateString = json.get(name).getAsString();
        return LocalDateTime.parse(dateString, dateTimeFormatter);
    }

    public LocalDate extractLocalDate(JsonObject json, String name, LocalDate defaultValue) {
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return defaultValue;
        return extractLocalDate(json, name);
    }

    public LocalDate extractLocalDate(JsonObject json, String name) {
        if (json.get(name).isJsonNull()) return LocalDate.MAX;
        String dateString = json.get(name).getAsString();
        return LocalDate.parse(dateString, localDateFormatter);
    }
    
}
