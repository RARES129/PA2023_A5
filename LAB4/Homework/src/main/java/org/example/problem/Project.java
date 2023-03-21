package org.example.problem;

/**
 * Project class that implements the interface Comparable
 */
public class Project implements Comparable<Project> {
    private String name;

    /**
     * Class constructor
     * @param name  name of the project
     */
    public Project(String name) {
        this.name = name;
    }

    /**
     * Getting the name of the project
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if two Projects are equal
     * @param o  an instance of the Object class
     * @return   true if the two projects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return getName().equals(project.getName());
    }

    /**
     * Getting the class attributes in a String format
     * @return  custom format String for the Project class
     */
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * Overriding the compareTo method from Comparable interface
     * @param other the object to be compared.
     * @return      the difference between the names
     */
    @Override
    public int compareTo(Project other) {
        if(other == null || getName() == null)
            throw new NullPointerException();
        return this.getName().compareTo(other.getName());
    }
}