package org.example.bonus;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class Playlists {

    private String[] name;
    private Timestamp time[];
    private List<Set<RecordsFromCSV>> listOfPlaylists;
    private int counterOfPlaylists;

    private IndependentSets unrelatedPlaylists;
    public void setName(String[] name) {
        this.name = name;
    }
    public void generateUnrelatedPlaylists(){
        Graph g=this.createPlaylists();
        g.refreshNodes();
        g.refreshEdges();
        g.toString();
       unrelatedPlaylists=new IndependentSets(g);

        unrelatedPlaylists.start();


    }
    public int getCounterOfPlaylists() {
        return counterOfPlaylists;
    }

    public List<Set<RecordsFromCSV>> getListOfPlaylists() {
        return listOfPlaylists;
    }

    public String[] getName() {
        return name;
    }

    public void setCounterOfPlaylistsGraph(int counterOfPlaylists) {
        this.counterOfPlaylists = counterOfPlaylists;
    }

    public void setListOfPlaylists(List<Set<RecordsFromCSV>> listOfPlaylists) {
        this.listOfPlaylists = listOfPlaylists;
    }

    public Timestamp[] getTime() {
        return time;
    }

    public void setTime(Timestamp[] time) {
        this.time = time;
    }

    public Graph createPlaylists(){

        Graph g=new Graph();

        List<RecordsFromCSV> listOfRecords=ImportTool.getListOfRecords();
        Node prim,second;Edge e;
        for(RecordsFromCSV recordPrim : listOfRecords){
            prim=new Node(recordPrim);
            for (RecordsFromCSV recordSecond: listOfRecords) {

                    second = new Node(recordSecond);
                    if (prim.getContains().getArtist().equals(second.getContains().getArtist())) {
                        e = new Edge(prim, second);
                        if(g.containsNode(prim) && g.containsNode(second)){
                            if(!g.containsEdge(e)){
                                g.addEdge(e);
                            }

                        }
                        if(!g.containsNode(prim) ) {

                            g.addNode(prim);
                            if(!g.containsEdge(e)){
                                g.addEdge(e);
                            }
                        }
                        if(!g.containsNode(second)) {

                            g.addNode(second);
                            if(!g.containsEdge(e)){
                                g.addEdge(e);
                            }
                        }

                    }
                    if (prim.getContains().getGenre().equals(second.getContains().getGenre())) {
                        e = new Edge(prim, second);
                        if(g.containsNode(prim) && g.containsNode(second)){
                            if(!g.containsEdge(e)){
                                g.addEdge(e);
                            }

                        }
                        if(!g.containsNode(prim) ) {

                            g.addNode(prim);
                            if(!g.containsEdge(e)){
                                g.addEdge(e);
                            }
                        }
                        if(!g.containsNode(second)) {

                            g.addNode(second);
                            if(!g.containsEdge(e)){
                                g.addEdge(e);
                            }
                        }
                    }
                    if (prim.getContains().getYear().equals(second.getContains().getYear())) {
                        e = new Edge(prim, second);
                        if(g.containsNode(prim) && g.containsNode(second)){
                            if(!g.containsEdge(e)){
                                g.addEdge(e);
                            }

                        }

                        if(!g.containsNode(prim) ) {

                            g.addNode(prim);
                            if(!g.containsEdge(e)){
                                g.addEdge(e);
                            }
                        }
                        if(!g.containsNode(second)) {

                            g.addNode(second);
                            if(!g.containsEdge(e)){
                                g.addEdge(e);
                            }
                        }
                    }


            }
        }


    return g;
    }
}
