package com.pham.rockpaperscissors.constants;

public enum BasicOptions {
    SCISSORS(1),
    ROCK(2),
    PAPER(3);

    private final int value;
    
    private BasicOptions(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
