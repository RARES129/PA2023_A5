import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person persoana = new Person();
        Company companie =new Company();
        Network Da =new Network();
        persoana.setName("Alin");
        companie.setName("Bytex");
        Da.addNode(companie);
        Da.addNode(persoana);
        System.out.println(Da);
    }
}