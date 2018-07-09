package am.soccer.model;

import java.time.LocalDate;

public class Season {
    
    private final int id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int currentMatchDay;

    public Season(SeasonBuilder seasonBuilder) {
        this.id = seasonBuilder.id;
        this.startDate = seasonBuilder.startDate;
        this.endDate = seasonBuilder.endDate;
        this.currentMatchDay = seasonBuilder.currentMatchDay;
    }

    public int getId() {
        return id;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getCurrentMatchDay() {
        return currentMatchDay;
    }
    
    
    public static class SeasonBuilder {
        private int id;
        private LocalDate startDate;
        private LocalDate endDate;
        private int currentMatchDay;

        public SeasonBuilder Id(int id) {
            this.id = id;
            return this;
        }

        public SeasonBuilder StartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public SeasonBuilder EndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public SeasonBuilder CurrentMatchDay(int currentMatchDay) {
            this.currentMatchDay = currentMatchDay;
            return this;
        }
        
        public Season build() {
            return new Season(this);
        }
    }
}
