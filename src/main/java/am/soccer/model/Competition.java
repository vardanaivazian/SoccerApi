package am.soccer.model;

import java.time.LocalDateTime;
import java.util.List;

public class Competition {
    
    private final int id;
    private final Area area;
    private final String name;
    private final String code;
    private final String plan;
    private final Season currentSeason;
    private final int numberOfAvailableSeasons;
    private final List<Season> seasons;
    private final LocalDateTime lastUpdated;

    private Competition(CompetitionBuilder builder) {
        this.id = builder.id;
        this.area = builder.area;
        this.name = builder.name;
        this.code = builder.code;
        this.plan = builder.plan;
        this.currentSeason = builder.currentSeason;
        this.seasons = builder.seasons;
        this.numberOfAvailableSeasons = builder.numberOfAvailableSeasons;
        this.lastUpdated = builder.lastUpdated;
    }

    public int getId() {
        return id;
    }

    public Area getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPlan() {
        return plan;
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public int getNumberOfAvailableSeasons() {
        return numberOfAvailableSeasons;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public static class CompetitionBuilder {

        private int id;
        private Area area;
        private String name;
        private String code;
        private String plan;
        private Season currentSeason;
        private int numberOfAvailableSeasons;
        private List<Season> seasons;
        private LocalDateTime lastUpdated;

        public CompetitionBuilder id(int id) {
            this.id = id;
            return this;
        }
        
        public CompetitionBuilder area(Area area) {
            this.area = area;
            return this;
        }

        public CompetitionBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        public CompetitionBuilder code(String code) {
            this.code = code;
            return this;
        }
        
        public CompetitionBuilder plan(String plan) {
            this.plan = plan;
            return this;
        }
        
        public CompetitionBuilder currentSeason(Season currentSeason) {
            this.currentSeason = currentSeason;
            return this;
        }
        
        public CompetitionBuilder seasons(List<Season> seasons) {
            this.seasons = seasons;
            return this;
        }

        public CompetitionBuilder numberOfAvailableSeasons(int numberOfAvailableSeasons) {
            this.numberOfAvailableSeasons = numberOfAvailableSeasons;
            return this;
        }

        public CompetitionBuilder lastUpdated(LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Competition build() {
            return new Competition(this);
        }

    }

}
