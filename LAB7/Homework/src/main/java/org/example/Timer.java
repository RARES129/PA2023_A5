package org.example;

public class Timer implements Runnable{
    private Long startTime;
    private Long endTime;
    private final Exploration exploration;

    public Timer(Exploration exploration) {
        this.exploration = exploration;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        while(true){
            Long currentTime = System.currentTimeMillis();
            if(currentTime - startTime > 10000) {
                System.out.println("Execution time exceeded 10 seconds");
                System.exit(0);
            }
            if(exploration.getMap().isFull()) {
                this.endTime = System.currentTimeMillis();
                System.out.println("Execution time: " + (endTime - startTime) + "ms");
                System.exit(0);
            }
        }
    }
}
