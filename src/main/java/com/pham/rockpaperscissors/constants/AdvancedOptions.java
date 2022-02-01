package com.pham.rockpaperscissors.constants;

public enum AdvancedOptions {
    SCISSORS(1),
    ROCK(2),
    WELL(3),
    PAPER(4);

    private final int value;
    
    private AdvancedOptions(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
