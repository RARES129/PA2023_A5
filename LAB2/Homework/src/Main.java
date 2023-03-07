/**
 * Aici este MAIN ul unde cream noi locatii, noi drumuri, noi obiecte Problem si adaugam informatii
 */
public class Main {
    /**
     *
     * @param args nu primeste niciun argument, toate datele sunt deja setate. Main ul adauga informatii pentru 5 drumuri si pentru 5 locatii, apoi le memoreaza intr-un obiect de tip Problem, urmand sa testeze daca exista drum intre 2 locatii
     */
    public static void main(String[] args) {

        Problem problema = new Problem();
        Location[] locatie = new Location[5];
        Road[] drum = new Road[5];
        for (int index = 0; index < 5; index++)
            locatie[index] = new Location();
        for (int index = 0; index < 5; index++)
            drum[index] = new Road();

        locatie[0].Set(10, 20, "Vaslui", "Vaslui", 200, "Nu exista", 0, "OMV", 6);
        locatie[1].Set(20, 30, "Iasi", "Iasi", 500, "AeroportIasi", 5, "OMV", 10);
        locatie[2].Set(30, 40, "Bacau", "Crangasi", 100, "AeroportBacau", 3, "LukOil", 4);
        locatie[3].Set(40, 50, "Braila", "Mircesti", 50, "Nu exista", 0, "LukOil", 4);
        //locatie[4].Set(10, 20, "Vaslui", "Vaslui", 200, "Nu exista", 0, "OMV", 6);
        locatie[4].Set(10, 20, "Vaslui", "Busteni", 200, "Nu exista", 0, "OMV", 6);

        drum[0].setAutostrada(10, 20, 15, 25);
        drum[1].setTara(15, 25, 20, 30);
        drum[2].setExpres(20, 30, 25, 35);
        drum[3].setAutostrada(25, 35, 30, 40);
        //drum[4].setAutostrada(25,35,30,40);
        drum[4].setAutostrada(30, 40, 40, 55);

        problema.setLocations(locatie);
        problema.setRoads(drum);

        problema.Algoritm(locatie[1],locatie[3],drum);


        System.out.println(problema);

    }
}