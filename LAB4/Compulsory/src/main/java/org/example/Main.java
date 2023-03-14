package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Students> listOfStudents = new LinkedList<>();
        Students s0 = new Students("Marian");
        Students s1 = new Students("Mircea");
        Students s2 = new Students("Gratiela");
        Students s3 = new Students("Carmina");

        Set<Projects> listOfProjects = new TreeSet<>();
        Projects p0 = new Projects("TreiInLinie");
        Projects p1 = new Projects("Segmente");
        Projects p2 = new Projects("QuizGame");
        Projects p3 = new Projects("OfflineMessanger");


        listOfStudents.add(s0);
        listOfStudents.add(s1);
        listOfStudents.add(s2);
        listOfStudents.add(s3);

        listOfProjects.add(p0);
        listOfProjects.add(p1);
        listOfProjects.add(p2);
        listOfProjects.add(p3);

        List<Students> newSortedList = listOfStudents.stream()
                .sorted(Comparator.comparing(Students::getNume))
                .collect(Collectors.toList());

        /*Collections.sort(listOfStudents,
                Comparator.comparing(Students::getNume));*/

        System.out.println(newSortedList);
        System.out.println(listOfProjects);

    }
}