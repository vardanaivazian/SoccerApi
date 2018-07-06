package am.soccer.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player {

    private final String name;
    private final String position;
    private final int jerseyNumber;
    private final LocalDate dateOfBirth;
    private final String nationality;
    private final LocalDate contractUntil;
    private final BigDecimal marketValue;

    private Player(PlayerBuilder builder) {
        this.name = builder.name;
        this.position = builder.position;
        this.jerseyNumber = builder.jerseyNumber;
        this.dateOfBirth = builder.dateOfBirth;
        this.nationality = builder.nationality;
        this.contractUntil = builder.contractUntil;
        this.marketValue = builder.marketValue;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getContractUntil() {
        return contractUntil;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public static class PlayerBuilder {

        private String name;
        private String position;
        private int jerseyNumber;
        private LocalDate dateOfBirth;
        private String nationality;
        private LocalDate contractUntil;
        private BigDecimal marketValue;

        public PlayerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public PlayerBuilder setJerseyNumber(int jerseyNumber) {
            this.jerseyNumber = jerseyNumber;
            return this;
        }

        public PlayerBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PlayerBuilder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public PlayerBuilder setContractUntil(LocalDate contractUntil) {
            this.contractUntil = contractUntil;
            return this;
        }

        public PlayerBuilder setMarketValue(BigDecimal marketValue) {
            this.marketValue = marketValue;
            return this;
        }

        public Player build() {
            return new Player(this);
        }

    }
    
}
