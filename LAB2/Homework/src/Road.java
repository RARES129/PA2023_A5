import java.util.Objects;

/**
 * Aici memoram coordonatele capetelor drumurilor, si tipul acestora
 */
public class Road {
    private Highway autostrada = new Highway();
    private Express expres = new Express();
    private Country tara = new Country();
    private String drum;

    /**
     * Este constructorul obiectului Road
     */
    public Road() {
    }

    /**
     *
     * @return ce fel de drum este (autostrada, de tara, expres)
     */
    public String getDrum() {
        return drum;
    }

    /**
     *
     * @return returneaza un obiect de tip Highway
     */
    public Highway getAutostrada() {
        return autostrada;
    }

    /**
     *
     * @return returneaza un obiect de tip Express
     */
    public Express getExpres() {
        return expres;
    }

    /**
     *
     * @return returneaza un obiect de tip Country
     */
    public Country getTara() {
        return tara;
    }

    /**
     * Valideaza coordonatele. Verifica sa nu aiba coordonatele de la un capat elage cu cel de la capatul opus.
     * @param x1 coordonata X a primului capat
     * @param y1 coordonata Y a primului capat
     * @param x2 coordonata X a capatului opus
     * @param y2 coordonata Y a capatului opus
     */
    public void validare(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            System.out.println("DATELE INTRODUSE LA DRUM SUNT INVALIDE");
            System.exit(0);
        }
    }

    /**
     * Seteaza coordonatele unui drum de tip Express, dupa validarea datelor.
     * @param x1 coordonata X a primului capat
     * @param y1 coordonata Y a primului capat
     * @param x2 coordonata X a capatului opus
     * @param y2 coordonata Y a capatului opus
     */
    public void setExpres(int x1, int y1, int x2, int y2) {
        validare(x1, y1, x2, y2);
        this.drum="Express";
        expres.setXY(x1, y1, x2, y2);
    }
    /**
     * Seteaza coordonatele unui drum de tip Highway, dupa validarea datelor.
     * @param x1 coordonata X a primului capat
     * @param y1 coordonata Y a primului capat
     * @param x2 coordonata X a capatului opus
     * @param y2 coordonata Y a capatului opus
     */
    public void setAutostrada(int x1, int y1, int x2, int y2) {
        validare(x1, y1, x2, y2);
        this.drum="Highway";
        autostrada.setXY(x1, y1, x2, y2);
    }
    /**
     * Seteaza coordonatele unui drum de tip Country, dupa validarea datelor.
     * @param x1 coordonata X a primului capat
     * @param y1 coordonata Y a primului capat
     * @param x2 coordonata X a capatului opus
     * @param y2 coordonata Y a capatului opus
     */
    public void setTara(int x1, int y1, int x2, int y2) {
        validare(x1, y1, x2, y2);
        this.drum="Country";
        tara.setXY(x1, y1, x2, y2);
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
        Road road = (Road) o;
        return Objects.equals(autostrada, road.autostrada) && Objects.equals(expres, road.expres) && Objects.equals(tara, road.tara);
    }

    /**
     *
     * @return returneaza un string cu toate informatiile din obiectul Road
     */
    @Override
    public String toString() {
        return "Road{" +
                "autostrada=" + autostrada +
                ", expres=" + expres +
                ", tara=" + tara +
                ", drum='" + drum + '\'' +
                '}';
    }
}
