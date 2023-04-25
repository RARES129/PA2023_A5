package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * A cell is a simple object from a matrix that can contain a list of tokens.
 */
public class Cell {
    private final List<Token> tokens;
    public Cell() {
        this.tokens = new ArrayList<>();
    }
    public List<Token> getTokens() {
        return tokens;
    }

}
