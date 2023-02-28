public class Location {
    private Cities oras = new Cities();
    private Airports aeroport = new Airports();
    private GasStations benzinarie = new GasStations();
    private int X;
    private int Y;

    public Location(Cities oras, Airports aeroport, GasStations benzinarie, int X, int Y) {
        this.oras = oras;
        this.aeroport = aeroport;
        this.benzinarie = benzinarie;
        this.X = X;
        this.Y = Y;
    }

    public Cities getOras() {
        return oras;
    }

    public void setOras(Cities oras) {
        this.oras = oras;
    }

    public Airports getAeroport() {
        return aeroport;
    }

    public void setAeroport(Airports aeroport) {
        this.aeroport = aeroport;
    }

    public GasStations getBenzinarie() {
        return benzinarie;
    }

    public void setBenzinarie(GasStations benzinarie) {
        this.benzinarie = benzinarie;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        this.Y = y;
    }
}
