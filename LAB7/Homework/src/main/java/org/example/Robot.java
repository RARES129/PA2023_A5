package org.example;

import java.util.List;


/**
 * A robot is an agent that can visit a cell in the map and extract tokens from the shared memory.
 */
public class Robot implements Runnable{
    private final String name;
    private boolean isPaused;
    Exploration exploration;

    private int noOfTokens;

    public Robot(String name, Exploration exploration) {
        this.name = name;
        this.exploration = exploration;
        this.isPaused = false;
        this.noOfTokens = 0;
    }

    //getters
    public String getName() {
        return name;
    }

    public List<Token> getTokens(){
        return exploration.getMem().extractTokens();
    }

    private int pickRow(){
        return (int) (Math.random() * exploration.getMap().getSize());
    }

    private int pickColumn(){
        return (int) (Math.random() * exploration.getMap().getSize());
    }

    private int moveRow(int row){
        int newRow = row;
        double probability = Math.random();
        if(probability < 0.33){
            newRow = row + 1;
        }else if(probability < 0.66){
            newRow = row - 1;
        }
        if(newRow < 0){
            newRow = 0;
        }
        if(newRow >= exploration.getMap().getSize()){
            newRow = exploration.getMap().getSize() - 1;
        }
        return newRow;
    }

    private int moveColumn(int column){
        int newColumn = column;
        double probability = Math.random();
        if(probability < 0.33){
            newColumn = column + 1;
        }else if(probability < 0.66){
            newColumn = column - 1;
        }
        if(newColumn < 0){
            newColumn = 0;
        }
        if(newColumn >= exploration.getMap().getSize()){
            newColumn = exploration.getMap().getSize() - 1;
        }
        return newColumn;
    }


    public void run() {
        int startRow = pickRow();
        int startColumn = pickColumn();
        while (true) {
            if (isPaused) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (exploration.getMap().visit(startRow, startColumn, this)) {
                noOfTokens += exploration.getMem().getNoOfTokens();
            }
            if (exploration.getMap().isFull()) {
                break;
            }
            startRow = moveRow(startRow);
            startColumn = moveColumn(startColumn);
            // sleep for 2 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this);
    }

    public void pause() {
        isPaused = true;
        System.out.println(this.getName() + " paused");
    }

    public void resume() {
        isPaused = false;
        System.out.println(this.getName() + " resumed");
        synchronized (this) {
            notify();
        }
    }

    @Override
    public String toString() {
        return name + " placed " + noOfTokens + " tokens";
    }
}