import java.util.Objects;
/**
 * Aici memoram pretul si numele unei benzinarii
 */
public class GasStations {
    private double price;
    private String nume;
    /**
     * Este constructorul obiectului de tip GasStation, si initializeaza numele la sirul vid, iar pretul la 0
     */
    public GasStations() {
        this.price = 0;
        this.nume = "";
    }
    /**
     *
     * @return returneaza pretul benzinei
     */
    public double getPrice() {
        return price;
    }
    /**
     * Seteaza pretul benzinei
     * @param price pretul benzinei
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return returneaza numele benzinariei
     */
    public String getNume() {
        return nume;
    }
    /**
     * Seteaza numele benzinariei
     * @param nume numele benzinariei
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
        GasStations that = (GasStations) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(nume, that.nume);
    }
    /**
     *
     * @return returneaza un string cu toate informatiile din obiectul GasStation
     */
    @Override
    public String toString() {
        return "GasStations{" + "price=" + price + ", nume='" + nume + '\'' + '}';
    }
}
