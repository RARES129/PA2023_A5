package org.example.algorithms;

import org.example.problem.Project;
import org.example.problem.Student;

/**
 * Pair class
 */
public class Pair {
    private Student student;
    private Project project;

    /**
     * Class constructor
     * @param student  Student object
     * @param project  Project object
     */
    public Pair(Student student, Project project) {
        this.student = student;
        this.project = project;
    }

    /**
     * Getting the student
     * @return  the Student object
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Getting the project
     * @return  the Project object
     */
    public Project getProject() {
        return project;
    }

    /**
     * Getting the class attributes in a String format
     * @return  custom format String for the Pair class
     */
    @Override
    public String toString() {
        return "Pair{" +
                "student=" + student +
                ", project=" + project +
                '}';
    }
}
