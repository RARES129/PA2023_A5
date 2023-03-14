package org.example;

public class Students implements Comparable<Students>{
    private String Nume;

    public Students(String nume) {
        Nume = nume;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    @Override
    public int compareTo(Students o) {
        return this.Nume.compareTo(o.Nume);
    }

    @Override
    public String toString() {
        return "Students{" +
                "Nume='" + Nume + '\'' +
                '}';
    }
}
