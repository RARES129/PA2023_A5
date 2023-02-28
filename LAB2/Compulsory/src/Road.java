public class Road {
    private String nume;
    private RoadType type;

    public Road(String nume,RoadType type)
    {
        this.nume=nume;
        this.type = type;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Road{" +
                "nume='" + nume + '\'' +
                ", type=" + type +
                '}';
    }
}
