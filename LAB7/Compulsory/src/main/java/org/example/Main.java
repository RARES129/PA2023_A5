package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Exploration explore = new Exploration();
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }

}