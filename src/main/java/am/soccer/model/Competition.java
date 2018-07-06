package am.soccer.model;

import java.time.LocalDateTime;

public class Competition {

    private final String selfLink;
    private final String teamsLink;
    private final String fixturesLink;
    private final String leagueTableLink;

    private final int id;
    private final String name;
    private final String league;
    private final String year;
    private final int currentMatchDay;
    private final int numberOfMatchDays;
    private final int numberOfTeams;
    private final int numberOfGames;
    private final LocalDateTime lastUpdated;

    private Competition(CompetitionBuilder builder) {
        this.selfLink = builder.selfLink;
        this.teamsLink = builder.teamsLink;
        this.fixturesLink = builder.fixturesLink;
        this.leagueTableLink = builder.leagueTableLink;

        this.id = builder.id;
        this.name = builder.name;
        this.league = builder.league;
        this.year = builder.year;
        this.currentMatchDay = builder.currentMatchDay;
        this.numberOfMatchDays = builder.numberOfMatchDays;
        this.numberOfTeams = builder.numberOfTeams;
        this.numberOfGames = builder.numberOfGames;
        this.lastUpdated = builder.lastUpdated;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public String getTeamsLink() {
        return teamsLink;
    }

    public String getFixturesLink() {
        return fixturesLink;
    }

    public String getLeagueTableLink() {
        return leagueTableLink;
    }

    public int getId() {
        return id;
    }

    public String getCaption() {
        return name;
    }

    public String getLeague() {
        return league;
    }

    public String getYear() {
        return year;
    }

    public int getCurrentMatchDay() {
        return currentMatchDay;
    }

    public int getNumberOfMatchDays() {
        return numberOfMatchDays;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public static class CompetitionBuilder {

        private String selfLink;
        private String teamsLink;
        private String fixturesLink;
        private String leagueTableLink;

        private int id;
        private String name;
        private String league;
        private String year;
        private int currentMatchDay;
        private int numberOfMatchDays;
        private int numberOfTeams;
        private int numberOfGames;
        private LocalDateTime lastUpdated;

        public CompetitionBuilder setSelfLink(String selfLink) {
            this.selfLink = selfLink;
            return this;
        }

        public CompetitionBuilder setTeamsLink(String teamsLink) {
            this.teamsLink = teamsLink;
            return this;
        }

        public CompetitionBuilder setFixturesLink(String fixturesLink) {
            this.fixturesLink = fixturesLink;
            return this;
        }

        public CompetitionBuilder setLeagueTableLink(String leagueTableLink) {
            this.leagueTableLink = leagueTableLink;
            return this;
        }

        public CompetitionBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CompetitionBuilder setCaption(String name) {
            this.name = name;
            return this;
        }

        public CompetitionBuilder setLeague(String league) {
            this.league = league;
            return this;
        }

        public CompetitionBuilder setYear(String year) {
            this.year = year;
            return this;
        }

        public CompetitionBuilder setCurrentMatchDay(int currentMatchday) {
            this.currentMatchDay = currentMatchday;
            return this;
        }

        public CompetitionBuilder setNumberOfMatchDays(int numberOfMatchDays) {
            this.numberOfMatchDays = numberOfMatchDays;
            return this;
        }

        public CompetitionBuilder setNumberOfTeams(int numberOfTeams) {
            this.numberOfTeams = numberOfTeams;
            return this;
        }

        public CompetitionBuilder setNumberOfGames(int numberOfGames) {
            this.numberOfGames = numberOfGames;
            return this;
        }

        public CompetitionBuilder setLastUpdated(LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Competition build() {
            return new Competition(this);
        }

    }

}
