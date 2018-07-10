package am.soccer.model;

import java.time.LocalDateTime;

public class Player {

    private final int id;
    private final String name;
    private final String position;
    private final LocalDateTime dateOfBirth;
    private final String countryOfBirth;
    private final String nationality;
    private final String role;

    private Player(PlayerBuilder builder) {

        this.id = builder.id;
        this.name = builder.name;
        this.position = builder.position;
        this.dateOfBirth = builder.dateOfBirth;
        this.nationality = builder.nationality;
        this.countryOfBirth = builder.countryOfBirth;
        this.role = builder.role;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public String getRole() {
        return role;
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public static class PlayerBuilder {

        private int id;
        private String name;
        private String position;
        private LocalDateTime dateOfBirth;
        private String countryOfBirth;
        private String nationality;
        private String role;

        public PlayerBuilder id(int id) {
            this.id = id;
            return this;
        }


        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder position(String position) {
            this.position = position;
            return this;
        }

        public PlayerBuilder dateOfBirth(LocalDateTime dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PlayerBuilder countryOfBirth(String countryOfBirth) {
            this.countryOfBirth = countryOfBirth;
            return this;
        }

        public PlayerBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public PlayerBuilder role(String role) {
            this.role = role;
            return this;
        }


        public Player build() {
            return new Player(this);
        }

    }

}
