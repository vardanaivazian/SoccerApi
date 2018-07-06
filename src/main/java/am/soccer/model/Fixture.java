package am.soccer.model;

import java.time.LocalDateTime;

/**
 * Created by Vardan Aivazian
 * Date: 6/28/2018
 * Time: 12:14 PM
 */
public class Fixture {
    private final String selfLink;
    private final String competitionLink;
    private final String homeTeamLink;
    private final String awayTeamLink;

    private final LocalDateTime date;
    private final FixtureStatus status;
    private final int matchDay;
    private final String homeTeamName;
    private final String awayTeamName;
    private final int homeTeamGoals;
    private final int awayTeamGoals;
    private final String odds;

    public Fixture(FixtureBuilder builder) {
        this.selfLink = builder.selfLink;
        this.competitionLink = builder.competitionLink;
        this.homeTeamLink = builder.homeTeamLink;
        this.awayTeamLink = builder.awayTeamLink;

        this.date = builder.date;
        this.status = builder.status;
        this.matchDay = builder.matchDay;
        this.homeTeamName = builder.homeTeamName;
        this.awayTeamName = builder.awayTeamName;
        this.homeTeamGoals = builder.homeTeamGoals;
        this.awayTeamGoals = builder.awayTeamGoals;
        this.odds = builder.odds;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public String getCompetitionLink() {
        return competitionLink;
    }

    public String getHomeTeamLink() {
        return homeTeamLink;
    }

    public String getAwayTeamLink() {
        return awayTeamLink;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public FixtureStatus getStatus() {
        return status;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public String getOdds() {
        return odds;
    }

    public static class FixtureBuilder {

        private String selfLink;
        private String competitionLink;
        private String homeTeamLink;
        private String awayTeamLink;

        private LocalDateTime date;
        private FixtureStatus status;
        private int matchDay;
        private String homeTeamName;
        private String awayTeamName;
        private int homeTeamGoals;
        private int awayTeamGoals;
        private String odds;

        public FixtureBuilder setSelfLink(String selfLink) {
            this.selfLink = selfLink;
            return this;
        }

        public FixtureBuilder setCompetitionLink(String competitionLink) {
            this.competitionLink = competitionLink;
            return this;
        }

        public FixtureBuilder setHomeTeamLink(String homeTeamLink) {
            this.homeTeamLink = homeTeamLink;
            return this;
        }

        public FixtureBuilder setAwayTeamLink(String awayTeamLink) {
            this.awayTeamLink = awayTeamLink;
            return this;
        }

        public FixtureBuilder setDate(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public FixtureBuilder setStatus(FixtureStatus status) {
            this.status = status;
            return this;
        }

        public FixtureBuilder setMatchDay(int matchDay) {
            this.matchDay = matchDay;
            return this;
        }

        public FixtureBuilder setHomeTeamName(String homeTeamName) {
            this.homeTeamName = homeTeamName;
            return this;
        }

        public FixtureBuilder setAwayTeamName(String awayTeamName) {
            this.awayTeamName = awayTeamName;
            return this;
        }

        public FixtureBuilder setHomeTeamGoals(int homeTeamGoals) {
            this.homeTeamGoals = homeTeamGoals;
            return this;
        }

        public FixtureBuilder setAwayTeamGoals(int awayTeamGoals) {
            this.awayTeamGoals = awayTeamGoals;
            return this;
        }

        public FixtureBuilder setOdds(String odds) {
            this.odds = odds;
            return this;
        }

        public Fixture build() {
            return new Fixture(this);
        }

    }
}
