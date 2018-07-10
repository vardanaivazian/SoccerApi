package am.soccer.model;

import java.time.LocalDateTime;
import java.util.List;

public class Team {
    
    private final int id;
    private final Area area;
    private final String name;
    private final String shortName;
    private final String tla;
    private final String address;
    private final String phone;
    private final String website;
    private final String email;
    private final int founded;
    private final String clubColors;
    private final String venue;
    private final List<Player> squad;
    private final LocalDateTime lastUpdated;

    private Team(TeamBuilder builder) {
        this.id = builder.id;
        this.area = builder.area;
        this.name = builder.name;
        this.shortName = builder.shortName;
        this.tla = builder.tla;
        this.address = builder.address;
        this.phone = builder.phone;
        this.website = builder.website;
        this.email = builder.email;
        this.founded = builder.founded;
        this.clubColors = builder.clubColors;
        this.venue = builder.venue;
        this.squad = builder.squad;
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

    public String getShortName() {
        return shortName;
    }

    public String getTla() {
        return tla;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public int getFounded() {
        return founded;
    }

    public String getClubColors() {
        return clubColors;
    }

    public String getVenue() {
        return venue;
    }

    public List<Player> getSquad() {
        return squad;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public static TeamBuilder builder() {
        return new TeamBuilder();
    }
    
    public static class TeamBuilder {

        private int id;
        private Area area;
        private String name;
        private String shortName;
        private String tla;
        private String address;
        private String phone;
        private String website;
        private String email;
        private int founded;
        private String clubColors;
        private String venue;
        private List<Player> squad;
        private LocalDateTime lastUpdated;
        
        
        public TeamBuilder id(int id) {
            this.id = id;
            return this;
        }

        public TeamBuilder area(Area area) {
            this.area = area;
            return this;
        }

        public TeamBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TeamBuilder shortName(String shortName) {
            this.shortName = shortName;
            return this;
        }
        
        public TeamBuilder tla(String tla) {
            this.tla = tla;
            return this;
        }

        public TeamBuilder address(String address) {
            this.address = address;
            return this;
        }

        public TeamBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public TeamBuilder website(String website) {
            this.website = website;
            return this;
        }

        public TeamBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TeamBuilder founded(int founded) {
            this.founded = founded;
            return this;
        }

        public TeamBuilder venue(String venue) {
            this.venue = venue;
            return this;
        }

        public TeamBuilder clubColors(String clubColors) {
            this.clubColors = clubColors;
            return this;
        }

        public TeamBuilder squad(List<Player> squad) {
            this.squad = squad;
            return this;
        }
        
        public TeamBuilder lastUpdated(LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Team build() {
            return new Team(this);
        }

    }
}
