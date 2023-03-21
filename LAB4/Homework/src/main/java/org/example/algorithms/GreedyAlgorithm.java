package org.example.algorithms;

import org.example.problem.Problem;
import org.example.problem.Project;
import org.example.problem.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Greedy algorithm that solves the maximum cardinality matching problem and implements Algorithm
 */
public class GreedyAlgorithm implements Algorithm {
    private List<Student> students;
    private List<Pair> allocation;

    /**
     * Solves the maximum cardinality problem using a greedy algorithm
     * @param pb  problem that needs solving
     * @return    the solution of the problem as a Solution object
     */
    @Override
    public Solution solve(Problem pb){
        students = pb.getListOfStudent();
        Collections.sort(students, (Comparator.comparingInt(pb::getNumberOfPreferences)));
        allocation = new ArrayList<>();
        for(Student student : students) {
            boolean added = false;
            for(Project project : pb.getPreferences().get(student)) {
                if(checkIfProjectWasAllocated(project)) {
                    Pair pair = new Pair(student, project);
                    allocation.add(pair);
                    added = true;
                    break;
                }
            }
            if(!added) {
                Pair pair = new Pair(student, null);
                allocation.add(pair);
            }
        }

        return new Solution(allocation);
    }

    /**
     * Checking if the project wasn't already allocated
     * @param project  Project object
     * @return         true if the project wasn't already allocated, false otherwise
     */
    private boolean checkIfProjectWasAllocated(Project project) {
        for(Pair pair : allocation) {
            if(pair.getProject() != null) {
                if(pair.getProject().equals(project))
                    return false;
            }
        }
        return true;
    }
}
