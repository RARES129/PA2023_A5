package org.example;

/**
 * A token is a simple object that can be stored in a cell.
 */
public class Token {
    private final int number;
    public Token(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
