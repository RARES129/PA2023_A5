public class Cities {
    private long population;
    private String nume;

    public Cities(String nume,long population) {
        this.population = population;
        this.nume=nume;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
