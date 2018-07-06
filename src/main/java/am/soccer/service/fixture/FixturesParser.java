package am.soccer.service.fixture;

import am.soccer.model.Fixture;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixturesParser {

    private static final String FIELD_NAME = "fixtures";

    private final JsonParser jsonParser = new JsonParser();
    private final FixtureParser fixtureParser = new FixtureParser();

    public List<Fixture> toFixtures(String jsonString) {
        JsonElement element = jsonParser.parse(jsonString);
        JsonObject object = element.getAsJsonObject();
        if (object.has(FIELD_NAME))
            return toFixtures(object.get(FIELD_NAME).getAsJsonArray());
        return toFixtures(object);
    }

    public Fixture toFixture(String jsonString) {
        return fixtureParser.toFixture(jsonString);
    }

    private List<Fixture> toFixtures(JsonArray array) {
        List<Fixture> fixtures = new ArrayList<>();
        array.forEach(item -> fixtures.add(toFixture(item.getAsJsonObject())));
        return fixtures;
    }

    private List<Fixture> toFixtures(JsonObject json) {
        return Collections.singletonList(toFixture(json));
    }

    private Fixture toFixture(JsonObject json) {
        return fixtureParser.toFixture(json);
    }


}
