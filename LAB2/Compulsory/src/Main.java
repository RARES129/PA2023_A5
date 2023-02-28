public class Main {
    public static void main(String[] args) {
    RoadType type;
    Road[] drumuri=new Road[2];
    drumuri[0]=new Road("Independentei",RoadType.EXPRESS);
    drumuri[1]=new Road("Uitarii",RoadType.HIGHWAY);
    Location LC= new Location();
    LC.setLocation("Iasi",2,drumuri);
    System.out.println(LC.toString());
    }
}