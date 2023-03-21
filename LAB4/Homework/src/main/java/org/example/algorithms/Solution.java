package org.example.algorithms;

import org.example.algorithms.Pair;

import java.util.List;

/**
 * Solution class that represent the solution of a problem
 */
public class Solution {
    private List<Pair> matching;

    /**
     * Class constructor
     * @param matching  list that represent the matching between students and projects
     */
    public Solution(List<Pair> matching) {
        this.matching = matching;
    }

    /**
     * Getting the class attributes in a String format
     * @return  custom format String for the Solution class
     */
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for(Pair pair : matching)
            msg.append(pair).append("\n");
        return msg.toString();
    }
}
