package com.pham.rockpaperscissors.model;

import com.pham.rockpaperscissors.constants.AdvancedOptions;

public class PlayOptionsAdvancedDTO {
    private AdvancedOptions playerChoice;

    public AdvancedOptions getPlayerChoice() {
        return this.playerChoice;
    }

    public void setPlayerChoice(AdvancedOptions playerChoice) {
        this.playerChoice = playerChoice;
    }
}