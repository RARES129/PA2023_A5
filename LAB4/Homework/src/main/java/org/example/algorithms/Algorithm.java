package org.example.algorithms;

import org.example.problem.Problem;

/**
 * Algorithm interface
 */
public interface Algorithm {
    /**
     * Solves the given problem with an implemented algorithm
     * @param pb          problem that needs solving
     * @return            the solution of the problem as a Solution object
     * @throws Exception  the instance of the problem isn't valid
     */
    Solution solve(Problem pb) throws Exception;
}
