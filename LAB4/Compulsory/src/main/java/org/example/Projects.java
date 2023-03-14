package org.example;

public class Projects implements Comparable<Projects>{
    private String Nume;

    public Projects(String nume) {
        Nume = nume;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    @Override
    public int compareTo(Projects o) {
        return this.Nume.compareTo(o.Nume);
    }

    @Override
    public String toString() {
        return "Projects{" +
                "Nume='" + Nume + '\'' +
                '}';
    }
}
