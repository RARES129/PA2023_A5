package org.example.problem;

import java.util.*;

/**
 * Problem class that models the input for an algorithm
 */
public class Problem {
    private List<Student> listOfStudent;
    private Set<Project> setOfProjects;
    private Map<Student, Set<Project>> preferences;

    /**
     * Class constructor
     * @param listOfStudent  list of students
     * @param setOfProjects  list of projects
     */
    public Problem(List<Student> listOfStudent, Set<Project> setOfProjects) {
        this.listOfStudent = listOfStudent;
        this.setOfProjects = setOfProjects;
        this.preferences = new HashMap<>();
    }

    /**
     * Getting the list of students
     * @return  list of students
     */
    public List<Student> getListOfStudent() {
        return listOfStudent;
    }

    /**
     * Getting the set of projects
     * @return  set of projects
     */
    public Set<Project> getSetOfProjects() {
        return setOfProjects;
    }

    /**
     * Getting the map that specifies the preferences of a student regarding a list of projects
     * @return  preferences map
     */
    public Map<Student, Set<Project>> getPreferences() {
        return preferences;
    }

    /**
     * Check if student exists in the list of students
     * @param studentToCheck  student that has to be checked
     * @return                true if the student exists in the list, false otherwise
     */
    private boolean checkStudent(Student studentToCheck) {
        for(Student student : listOfStudent) {
            if(student.equals(studentToCheck))
                return true;
        }
        return false;
    }

    /**
     * Adding the preference of a student with a project
     * @param student      student object
     * @param projects     set of admissible projects
     * @throws Exception   student doesn't exist
     */
    public void addPreference(Student student, Set<Project> projects) throws Exception {
        if(checkStudent(student))
            preferences.put(student, projects);
        else
            throw new Exception("The student " + student.getName() + " doesn't exist in the list!");
    }

    /**
     * Getting the number of project the student likes
     * @param student  student object
     * @return         number of preferences
     */
    public int getNumberOfPreferences(Student student) {
        return preferences.get(student).size();
    }

    /**
     * Computing the average number of preferences
     * @return  average number of preferences
     */
    private int averageNumberOfPreferences() {
        int sum = 0;
        for(Student student : listOfStudent)
            sum += getNumberOfPreferences(student);
        return sum / listOfStudent.size();
    }

    /**
     * Shows all the students whose number of preferences is lower than the average number of preferences
     */
    public void showStudentsBellowAverage() {
        listOfStudent.stream()
                .filter(s -> getNumberOfPreferences(s) < averageNumberOfPreferences())
                .forEach(System.out::println);
    }
}
