package am.soccer.model;

import java.math.BigDecimal;

public class Team {
    private final String selfLink;
    private final String fixturesLink;
    private final String playersLink;

    private final int id;
    private final String name;
    private final String shortName;
    private final String code;
    private final String crestUrl;
    private final BigDecimal squadMarketValue;

    private Team(TeamBuilder builder) {
        this.selfLink = builder.selfLink;
        this.fixturesLink = builder.fixturesLink;
        this.playersLink = builder.playersLink;

        this.id = builder.id;
        this.name = builder.name;
        this.shortName = builder.shortName;
        this.code = builder.code;
        this.crestUrl = builder.crestUrl;
        this.squadMarketValue = builder.squadMarketValue;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public String getFixturesLink() {
        return fixturesLink;
    }

    public String getPlayersLink() {
        return playersLink;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getCode() {
        return code;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public BigDecimal getSquadMarketValue() {
        return squadMarketValue;
    }

    public static class TeamBuilder {

        private String selfLink;
        private String fixturesLink;
        private String playersLink;

        private int id;
        private String name;
        private String shortName;
        private String code;
        private String crestUrl;
        private BigDecimal squadMarketValue;

        public TeamBuilder setSelfLink(String selfLink) {
            this.selfLink = selfLink;
            return this;
        }

        public TeamBuilder setFixturesLink(String fixturesLink) {
            this.fixturesLink = fixturesLink;
            return this;
        }

        public TeamBuilder setPlayersLink(String playersLink) {
            this.playersLink = playersLink;
            return this;
        }

        public TeamBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public TeamBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public TeamBuilder setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public TeamBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public TeamBuilder setCrestUrl(String crestUrl) {
            this.crestUrl = crestUrl;
            return this;
        }

        public TeamBuilder setSquadMarketValue(BigDecimal squadMarketValue) {
            this.squadMarketValue = squadMarketValue;
            return this;
        }

        public Team build() {
            return new Team(this);
        }

    }
}
