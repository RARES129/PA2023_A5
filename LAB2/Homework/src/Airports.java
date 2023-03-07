import java.util.Objects;
/**
 * Aici memoram terminalele si numele unui aeroport
 */
public class Airports {
    private int terminale;
    private String nume;
    /**
     * Este constructorul obiectului de tip Airports, si initializeaza numele la sirul vid, iar terminalele la 0
     */
    public Airports() {
        this.terminale = 0;
        this.nume = "";
    }

    /**
     *
     * @return returneaza numerul de terminale ale aeroportului
     */
    public int getTerminale() {
        return terminale;
    }

    /**
     * Seteaza numerul de terminale ale aeroportului
     * @param terminale numerul de terminale ale aeroportului
     */
    public void setTerminale(int terminale) {
        this.terminale = terminale;
    }

    /**
     *
     * @return returneaza numele aeroportului
     */
    public String getNume() {
        return nume;
    }
    /**
     * Seteaza numele aeroportului
     * @param nume numele aeroportului
     */
    public void setNume(String nume) {
        this.nume = nume;
    }
    /**
     * Face comparatia intre doua obiecte pentru a vedea daca sunt identice sau nu
     * @param o Obiectul cu care comparam
     * @return true in cazul in care sunt identice, false in cazul in care nu sunt identice
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airports airports = (Airports) o;
        return terminale == airports.terminale && Objects.equals(nume, airports.nume);
    }
    /**
     *
     * @return returneaza un string cu toate informatiile din obiectul Airports
     */
    @Override
    public String toString() {
        return "Airports{" + "terminale=" + terminale + ", nume='" + nume + '\'' + '}';
    }
}
