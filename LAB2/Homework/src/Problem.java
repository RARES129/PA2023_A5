import javax.sound.sampled.FloatControl;
import java.util.Arrays;

/**
 * Aceasta clasa primeste obiecte de tip Location si Road, si testeaza daca exsiata drum intre 2 locatii
 */
public class Problem {

    private Location[] locations;
    private Road[] roads;

    private int[][] Adiacenta = new int[5][5];
    private int[] Plecari = new int[5];
    private int[] Sosiri = new int[5];
    private int[] Vizitat = new int[5];

    /**
     * Este constructorul obiectului Problem
     */
    public Problem() {
    }

    /**
     *
     * @return returneaza obiectul de tip Road
     */
    public Road[] getRoads() {
        return roads;
    }

    /**
     *
     * @return returneaza obiectul de tip Location
     */
    public Location[] getLocations() {
        return locations;
    }

    /**
     *
     * @param locations Adauga in obiectul de tip Problem, un array de obiecte de tip Location, dar nu inainte sa teste daca exista doua locatii identice. In cazul in care exita doua locatii identice, se va afisa in consola ca nu pot exista, si va incheia programul.
     */
    public void setLocations(Location[] locations) {

        for (int index = 0; index < locations.length; index++)
            for (int index2 = 0; index2 < locations.length; index2++)
                if (index != index2 && locations[index].equals(locations[index2])) {
                    System.out.println("NU SE POATE INTODUCE ACEEASI LOCATIE DE DOUA ORI !!!");
                    System.exit(0);
                }
        this.locations = locations;

    }

    /**
     *
     * @param roads Adauga in obiectul de tip Problem, un array de obiecte de tip Road dar nu inainte sa teste daca exista doua drumuri identice. In cazul in care exita doua drumuri identice, se va afisa in consola ca nu pot exista, si va incheia programul.
     */

    public void setRoads(Road[] roads) {
        for (int index = 0; index < roads.length; index++)
            for (int index2 = 0; index2 < roads.length; index2++)
                if (index != index2 && roads[index].equals(roads[index2])) {
                    System.out.println("NU SE POATE INTODUCE ACELASI DRUM DE DOUA ORI !!!");
                    System.exit(0);
                }
        this.roads = roads;
    }

    /**
     * Creaza o matrice de adiacenta pentru a putea contoriza ce drumuri se intersecteaza. Creaza doua array uri care memoreaza ce drumuri pot fi parcurse pentru a pleca din prima locatie, si un alt array pentru a memora ce drumuri pot fi parcurse pentru a ajunge in a doua locatie. La sfarsit testeaza fiecare posibilitate si afiseaza in daca exista drum sau nu.
     * @param locatie1 este locatia de la care vrem sa plecam si sa gasim un drum pana la urmatoarea locatie
     * @param locatie2 este locatia la care vrem sa ajungem de la locatie1 cu ajutorul drumurilor
     * @param roads sunt drumurile cu ajutorul carora testam daca exista un drum intre locatie1 si locatie2.
     */
    public void Algoritm(Location locatie1, Location locatie2, Road roads[]) {
        int StartX = locatie1.getX();
        int StartY = locatie1.getY();
        int EndX = locatie2.getX();
        int EndY = locatie2.getY();
        boolean ExistaDrum = false;

        Highway H1;
        Express E1;
        Country C1;
        Highway H2;
        Express E2;
        Country C2;

        int X1 = 0, X2 = 0, Y1 = 0, Y2 = 0;
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        for (int index = 0; index < roads.length; index++) {
            for (int index2 = 0; index2 < roads.length; index2++)
                Adiacenta[index][index2] = 0;
            Plecari[index] = 0;
            Sosiri[index] = 0;
            Vizitat[index] = 0;
        }

        for (int index = 0; index < roads.length; index++)
            for (int index2 = 0; index2 < roads.length; index2++)
                if (index != index2) {
                    if (roads[index].getDrum() == "Express") {
                        E1 = roads[index].getExpres();
                        X1 = E1.getX1();
                        Y1 = E1.getY1();
                        X2 = E1.getX2();
                        Y2 = E1.getY2();
                    } else if (roads[index].getDrum() == "Highway") {
                        H1 = roads[index].getAutostrada();
                        X1 = H1.getX1();
                        Y1 = H1.getY1();
                        X2 = H1.getX2();
                        Y2 = H1.getY2();
                    } else if (roads[index].getDrum() == "Country") {
                        C1 = roads[index].getTara();
                        X1 = C1.getX1();
                        Y1 = C1.getY1();
                        X2 = C1.getX2();
                        Y2 = C1.getY2();
                    }
                    if (roads[index2].getDrum() == "Express") {
                        E2 = roads[index2].getExpres();
                        x1 = E2.getX1();
                        y1 = E2.getY1();
                        x2 = E2.getX2();
                        y2 = E2.getY2();
                    } else if (roads[index2].getDrum() == "Highway") {
                        H2 = roads[index2].getAutostrada();
                        x1 = H2.getX1();
                        y1 = H2.getY1();
                        x2 = H2.getX2();
                        y2 = H2.getY2();
                    } else if (roads[index2].getDrum() == "Country") {
                        C2 = roads[index2].getTara();
                        x1 = C2.getX1();
                        y1 = C2.getY1();
                        x2 = C2.getX2();
                        y2 = C2.getY2();
                    }

                    if (X1 == x1 && Y1 == y1 || X1 == x2 && Y1 == y2 || X2 == x1 && Y2 == y1 || X2 == x2 && Y2 == y2) {
                        if (StartX == X1 && StartY == Y1 || StartX == X2 && StartY == Y2) Plecari[index] = 1;
                        if (StartX == x1 && StartY == y1 || StartX == x2 && StartY == y2) Plecari[index2] = 1;
                        if (EndX == X1 && EndY == Y1 || EndX == X2 && EndY == Y2) Sosiri[index] = 1;
                        if (EndX == x1 && EndY == y1 || EndX == x2 && EndY == y2) Sosiri[index2] = 1;

                        Adiacenta[index][index2] = 1;
                        Adiacenta[index2][index] = 1;
                    }

                }
        for (int index = 0; index < roads.length; index++)
            if (Plecari[index] == 1)
                for (int index2 = 0; index2 < roads.length; index2++)
                    if (Sosiri[index2] == 1) {
                        if (Verificare(index, index2, roads))
                            ExistaDrum = true;
                        for (int i = 0; i < roads.length; i++)
                            Vizitat[i] = 0;
                    }
        if (ExistaDrum == true)
            System.out.println("EXISTA DRUM INTRE LOCATII");
        else
            System.out.println("NU EXISTA DRUM INTRE LOCATII");
    }

    /**
     *
     * @param x dupa ce am memorat in vectorul Plecari indexul drumurilor care au unul dintre capete in locatia de placare, testam pe rand fiecare drum pe care il poate folosi pentru a pleca din locatie1, iar x reprezinta un index al vectorului Plecari
     * @param y dupa ce am memorat in vectorul Sosiri indexul drumurilor care au unul dintre capete in locatia de sosire, testam pe rand fiecare drum pe care il poate folosi pentru a ajunge in locatie2, iar y reprezinta un index al vectorului Sosiri
     * @param roads sunt drumurile cu ajutorul carora testam daca exista un drum intre locatie1 si locatie2.
     * @return
     */
    public boolean Verificare(int x, int y, Road[] roads) {

        Vizitat[x] = 1;
        if (Sosiri[x] == 1) {
            return true;
        }
        for (int neighbor = 0; neighbor < roads.length; neighbor++)
            if (Adiacenta[x][neighbor] == 1 && Vizitat[neighbor] == 0)
                if (Verificare(neighbor, y, roads)) {
                    return true;
                }
        return false;
    }

    /**
     *
     * @return returneaza un string cu toate informatiile din obiectul Problem
     */
    @Override
    public String toString() {
        return "Problem{" + "locations=" + Arrays.toString(locations) + ", roads=" + Arrays.toString(roads) + '}';
    }
}
