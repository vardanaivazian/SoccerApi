package am.soccer.model;

public class Area {
    
    private int id;
    private String name;

    public Area(AreaBuilder areaBuilder) {
        this.id = areaBuilder.id;
        this.name = areaBuilder.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static class AreaBuilder {
        private int id;
        private String name;
        
        public AreaBuilder Id(int id) {
            this.id = id;
            return this;
        }
        
        public AreaBuilder Name(String name) {
            this.name = name;
            return this;
        }
        
        public Area build() {
            return new Area(this);
        }
    }
}
