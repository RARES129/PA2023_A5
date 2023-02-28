public class Airports {
    private int terminale;
    private String nume;

    public Airports(String nume,int terminale) {
        this.terminale = terminale;
        this.nume=nume;
    }

    public int getTerminale() {
        return terminale;
    }

    public void setTerminale(int terminale) {
        this.terminale = terminale;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
