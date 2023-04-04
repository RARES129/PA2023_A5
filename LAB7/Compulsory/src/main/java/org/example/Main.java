package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Exploration explore = new Exploration();
        explore.addRobot(new Robot("Ratchet"));
        explore.addRobot(new Robot("Bumblebee"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }

}