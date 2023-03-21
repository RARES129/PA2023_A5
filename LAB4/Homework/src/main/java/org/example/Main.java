package org.example;

import com.github.javafaker.Faker;
import org.example.algorithms.Algorithm;
import org.example.algorithms.GreedyAlgorithm;
import org.example.algorithms.Solution;
import org.example.problem.Problem;
import org.example.problem.Project;
import org.example.problem.Student;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = 9;
        Faker faker = new Faker();
        var students = IntStream.rangeClosed(0, n).mapToObj(i -> new Student(faker.name().firstName())).toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, n).mapToObj(i -> new Project(faker.pokemon().name())).toArray(Project[]::new);

        List<Student> listOfStudents = new LinkedList<>();
        listOfStudents.addAll(Arrays.asList(students));
        Collections.sort(listOfStudents, (Student::compareTo));

        Set<Project> setOfProjects = new TreeSet<>(Project::compareTo);
        setOfProjects.addAll(Arrays.asList(projects));

        Problem pb = new Problem(listOfStudents, setOfProjects);
        for(Student student : listOfStudents) {
            int numOfProjects = (int)(Math.random() * 1_000_000) % n + 1;
            List<Project> shuffleList = new ArrayList<>(setOfProjects);
            Collections.shuffle(shuffleList);
            Set<Project> randomSet = new TreeSet<>(shuffleList.subList(0, numOfProjects));
            pb.addPreference(student, randomSet);
        }

        Algorithm alg = new GreedyAlgorithm();
        Solution sol = alg.solve(pb);
        System.out.println(sol);
    }
}

