import java.util.Objects;

/**
 * Aici memoram coordonatele unei locatii, numele, orasele, benzinariile, si aeropoartele acesteia
 */
public class Location {
    private int X;
    private int Y;
    private String nume;
    private Cities oras = new Cities();
    private Airports aeroport = new Airports();
    private GasStations benzinarie = new GasStations();

    /**
     * Seteaza la 0 coordonatele locatiei, si cu un String vid numele locatiei
     */
    public Location() {
        X = 0;
        Y = 0;
        this.nume = "";
    }

    /**
     * Testeaza daca datele introduse sunt valide, iar in caz afirmativ, le memoreaza in obiectul Location, in caz negativ, va afisa ca nu se poate memora, si va inchide programul
     * @param x coordonata X a locatiei
     * @param y coordonata y a locatiei
     * @param nume numele locatiei
     * @param numeOras numele orasului
     * @param population populatia orasului
     * @param numeAeroport numele aeroportului
     * @param terminale numarul de terminale ale aeroportului
     * @param numeBenzinarie numele benzinariei
     * @param pret numarul de benzinarii
     */
    public void Set(int x, int y, String nume, String numeOras, int population, String numeAeroport, int terminale, String numeBenzinarie, int pret) {

        if (nume != "" && numeAeroport != "" && numeBenzinarie != "" && numeOras != "" && x >= 0 && y >= 0 && ((numeAeroport == "Nu exista" && terminale == 0) || (numeAeroport != "Nu exista" && terminale != 0)) && ((numeAeroport == "Nu exista" && terminale == 0) || (numeAeroport != "Nu exista" && terminale != 0))) {
            this.X = x;
            this.Y = y;
            this.nume = nume;
            oras.setPopulation(population);
            oras.setNume(numeOras);
            aeroport.setTerminale(terminale);
            aeroport.setNume(numeAeroport);
            benzinarie.setPrice(pret);
            benzinarie.setNume(numeBenzinarie);
        } else {
            System.out.println("DATELE INTRODUSE LA LOCATIE SUNT INVALIDE");
            System.exit(0);
        }
    }

    /**
     *
     * @return returneaza coordonata X a locatiei
     */
    public int getX() {
        return X;
    }

    /**
     *
     * @return returneaza coordonata Y a locatiei
     */
    public int getY() {
        return Y;
    }

    /**
     * Seteaza coordonatele XY a locatiei
     * @param x seteaza coordonata X a locatiei
     * @param y seteaza coordonata Y a locatiei
     */
    public void setXY(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    /**
     *
     * @return returneaza numele locatiei
     */
    public String getNume() {
        return nume;
    }

    /**
     *
     * @param nume seteaza numele locatiei
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     *
     * @return returneaza un obiect de tip Cities
     */
    public Cities getOras() {
        return oras;
    }

    /**
     * Adauga valori unui obiect de tip Cities
     * @param population seteaza populatia orasului
     * @param nume seteaza numele orasului
     */
    public void setOras(int population, String nume) {
        oras.setPopulation(population);
        oras.setNume(nume);
    }

    /**
     *
     * @return returneaza un obiect de tip Airports
     */
    public Airports getAeroport() {
        return aeroport;
    }

    /**
     * Adauga valori unui obiect de tip Airports
     * @param terminale seteaza numarul de terminale ale aeroportului
     * @param nume seteaza numele aeroportului
     */
    public void setAeroport(int terminale, String nume) {
        aeroport.setTerminale(terminale);
        aeroport.setNume(nume);
    }
    /**
     *
     * @return returneaza un obiect de tip GasStation
     */
    public GasStations getBenzinarie() {
        return benzinarie;
    }

    /**
     * Adauga valori unui obiect de tip Airports
     * @param pret seteaza pretul benzinei de la benzinaria respectiva
     * @param nume seteaza numele benzinariei
     */
    public void setBenzinarie(int pret, String nume) {
        benzinarie.setPrice(pret);
        benzinarie.setNume(nume);
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
        Location location = (Location) o;
        return X == location.X && Y == location.Y && Objects.equals(nume, location.nume) && Objects.equals(oras, location.oras) && Objects.equals(aeroport, location.aeroport) && Objects.equals(benzinarie, location.benzinarie);
    }
    /**
     *
     * @return returneaza un string cu toate informatiile din obiectul Location
     */
    @Override
    public String toString() {
        return "Location{" + "X=" + X + ", Y=" + Y + ", nume='" + nume + '\'' + ", oras=" + oras.toString() + ", aeroport=" + aeroport.toString() + ", benzinarie=" + benzinarie.toString() + '}';
    }
}
