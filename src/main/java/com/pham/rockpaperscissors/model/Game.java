package com.pham.rockpaperscissors.model;


public class Game {  

    private String gameMode;
    private String computerChoice;
    private String playerChoice;
    private String result;

    public Game(){
        this.gameMode = "Basic";
        this.computerChoice = null;
        this.playerChoice = null;
        this.result = "";
    }

    public Game(String gameMode, String playerChoice) {
        this.gameMode = gameMode;
        this.playerChoice = playerChoice;
        this.result = "";
    }

    public String getComputerChoice() {
        return this.computerChoice;
    }

    public void setComputerChoice(String computerChoice) {
        this.computerChoice = computerChoice;
    }

    public String getPlayerChoice() {
        return this.playerChoice;
    }

    public void setPlayerChoice(String playerChoice) {
        this.playerChoice = playerChoice;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getGameMode() {
        return this.gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }
}
