package org.example.problem;

/**
 * Student class that implements the interface Comparable
 */
public class Student implements Comparable<Student> {
    private String name;

    /**
     * Class constructor
     * @param name  name of the student
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Getting the name of the student
     * @return  name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if two Students are equal
     * @param o  an instance of the Object class
     * @return   true if the two students are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getName().equals(student.getName());
    }

    /**
     * Getting the class attributes in a String format
     * @return  custom format String for the Student class
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * Overriding the compareTo method from Comparable interface
     * @param other the object to be compared.
     * @return  the difference between the name
     */
    @Override
    public int compareTo(Student other) {
        if(other == null || getName() == null)
            throw new NullPointerException();
        return this.getName().compareTo(other.getName());
    }
}