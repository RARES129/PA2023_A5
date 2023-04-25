package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A shared memory is a list of tokens that can be extracted by robots.
 */
public class SharedMemory {
    private final List<Token> tokens;
    private final int noOfTokens;
    public SharedMemory(int n) {
        this.noOfTokens = n;
        tokens = new ArrayList<Token>(noOfTokens);
        for (int i = 0; i < noOfTokens*noOfTokens*noOfTokens; ++i) {
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> extractTokens() {
        List<Token> extracted= new ArrayList<>();
        for(int i=0;i<noOfTokens;++i){
            if(tokens.isEmpty())
                break;
            extracted.add(tokens.remove(0));
        }
        return extracted;
    }

    public int getNoOfTokens() {
        return noOfTokens;
    }
}
