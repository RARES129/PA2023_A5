import java.util.Objects;

/**
 * Aici memoram populatia si numele unui oras
 */
public class Cities {
    private int population;
    private String nume;

    /**
     * Este constructorul obiectului de tip Cities, si initializeaza numele la sirul vid, iar populatia la 0
     */
    public Cities() {
        this.population = 0;
        this.nume = "";
    }

    /**
     *
     * @return returneaza populatia orasului
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Seteaza populatia orasului
     * @param population numarul de oameni din oras
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     *
     * @return returneaza numele orasului
     */
    public String getNume() {
        return nume;
    }

    /**
     * Seteaza numele orasului
     * @param nume numele orasului
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
        Cities cities = (Cities) o;
        return population == cities.population && Objects.equals(nume, cities.nume);
    }
    /**
     *
     * @return returneaza un string cu toate informatiile din obiectul Cities
     */
    @Override
    public String toString() {
        return "Cities{" + "population=" + population + ", nume='" + nume + '\'' + '}';
    }
}
