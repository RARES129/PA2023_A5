import java.util.Objects;
/**
 * aici memoram coordonatele de la ambele capete ale drumului de tip Country
 */
public class Country {
    private int X1, X2;
    private int Y1, Y2;
    /**
     * Constructorul ce initializeaza coordonatele ambelor capete ale drumului cu 0
     */
    public Country() {
        X1 = 0;
        Y1 = 0;
        X2 = 0;
        Y2 = 0;
    }
    /**
     *
     * @return returneaza coordonata X al primului capat al drumului
     */
    public int getX1() {
        return X1;
    }
    /**
     *
     * @return returneaza coordonata Y al primului capat al drumului
     */
    public int getY1() {
        return Y1;
    }
    /**
     *
     * @return returneaza coordonata X al capatului opus al drumului
     */
    public int getX2() {
        return X2;
    }
    /**
     *
     * @return returneaza coordonata Y al capatului opus al drumului
     */
    public int getY2() {
        return Y2;
    }
    /**
     * Seteaza coordonatele drumului.
     * @param x1 coordonata X a primului capat
     * @param y1 coordonata Y a primului capat
     * @param x2 coordonata X a capatului opus
     * @param y2 coordonata Y a capatului opus
     */
    public void setXY(int x1, int y1, int x2, int y2) {
        X1 = x1;
        Y1 = y1;
        X2 = x2;
        Y2 = y2;

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
        Country country = (Country) o;
        return X1 == country.X1 && X2 == country.X2 && Y1 == country.Y1 && Y2 == country.Y2;
    }
    /**
     *
     * @return returneaza un string cu toate informatiile din obiectul Country
     */
    @Override
    public String toString() {
        return "Country{" + "X1=" + X1 + ", X2=" + X2 + ", Y1=" + Y1 + ", Y2=" + Y2 + '}';
    }
}
