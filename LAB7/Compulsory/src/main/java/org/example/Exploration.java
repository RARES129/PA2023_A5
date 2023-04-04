package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private static final SharedMemory mem = new SharedMemory(5);
    private final ExplorationMap map = new ExplorationMap(5);
    private final List<Robot> robots = new ArrayList<>();

    public void start() {
        for (Robot robot : robots) {
            Thread r = new Thread(robot);
            r.start();
        }
    }

    public void addRobot(Robot r) {
        for (Robot r1 : robots) {
            if (r1.equals(r)) {
                return;
            }
        }
        robots.add(r);
    }

    public ExplorationMap getMap() {
        return this.map;
    }

    public boolean afiseaza() {
        for (Robot r : robots) {
            if (r.getStatus()) {
                return true;
            }
        }
        return false;
    }
}