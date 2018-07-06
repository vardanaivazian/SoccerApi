package am.soccer.service.player;

import am.soccer.model.Player;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayersParser {

    private static final String FIELD_NAME = "players";

    private final JsonParser jsonParser = new JsonParser();
    private final PlayerParser playerParser = new PlayerParser();

    public List<Player> toPlayers(String jsonString) {
        JsonElement element = jsonParser.parse(jsonString);
        JsonObject object = element.getAsJsonObject();
        if (object.has(FIELD_NAME))
            return toPlayers(object.get(FIELD_NAME).getAsJsonArray());
        return toPlayers(object);
    }

    public Player toPlayer(String jsonString) {
        return playerParser.toPlayer(jsonString);
    }

    private List<Player> toPlayers(JsonArray array) {
        List<Player> competitions = new ArrayList<>();
        array.forEach(item -> competitions.add(toPlayer(item.getAsJsonObject())));
        return competitions;
    }

    private List<Player> toPlayers(JsonObject json) {
        return Collections.singletonList(toPlayer(json));
    }

    private Player toPlayer(JsonObject json) {
        return playerParser.toPlayer(json);
    }
    
}
