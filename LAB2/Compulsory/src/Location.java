import java.util.Arrays;

public class Location {
    private String name;
    private Road[] drumuri = new Road[2];
    private int NrDrumuri;

    public Location()
    {
        this.name="";
        this.NrDrumuri=0;
    }

    public void setLocation(String name,int NrDrumuri,Road[] drumuri)
    {
        this.name=name;
        this.NrDrumuri=NrDrumuri;
        for(int index=0;index<NrDrumuri;index++)
        {
            this.drumuri[index]=drumuri[index];
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Road[] getDrumuri() {
        return drumuri;
    }

    public void setDrumuri(Road[] drumuri) {
        this.drumuri = drumuri;
    }

    public int getNrDrumuri() {
        return NrDrumuri;
    }

    public void setNrDrumuri(int nrDrumuri) {
        NrDrumuri = nrDrumuri;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", drumuri=" + Arrays.toString(drumuri) +
                ", NrDrumuri=" + NrDrumuri +
                '}';
    }
}
