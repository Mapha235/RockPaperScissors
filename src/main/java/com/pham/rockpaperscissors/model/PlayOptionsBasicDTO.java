package com.pham.rockpaperscissors.model;

import com.pham.rockpaperscissors.constants.BasicOptions;

public class PlayOptionsBasicDTO{
    private BasicOptions playerChoice;

    public BasicOptions getPlayerChoice() {
        return this.playerChoice;
    }

    public void setPlayerChoice(BasicOptions playerChoice) {
        this.playerChoice = playerChoice;
    }
}
