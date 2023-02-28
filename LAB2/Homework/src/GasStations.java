public class GasStations {
    private double price;
    private String nume;

    public GasStations(String nume,double price) {
        this.price = price;
        this.nume=nume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
