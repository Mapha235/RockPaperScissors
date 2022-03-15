package com.pham.rockpaperscissors.service;

import java.util.Random;

import com.pham.rockpaperscissors.constants.AdvancedOptions;
import com.pham.rockpaperscissors.constants.BasicOptions;
import com.pham.rockpaperscissors.model.Game;
import com.pham.rockpaperscissors.model.PlayOptionsAdvancedDTO;
import com.pham.rockpaperscissors.model.PlayOptionsBasicDTO;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    public Game createGame(PlayOptionsBasicDTO play){
        Game game = new Game("Basic", play.getPlayerChoice().toString());

        BasicOptions[] values = BasicOptions.values();
        Random random = new Random();
        BasicOptions computerChoice = values[random.nextInt(values.length)];

        game.setComputerChoice(computerChoice.toString());
        game.setResult(checkWinner(computerChoice.getValue(), play.getPlayerChoice().getValue(), values.length));
        return game;
    }

    public Game createGame(PlayOptionsAdvancedDTO play){
        Game game = new Game("Advanced", play.getPlayerChoice().toString());

        AdvancedOptions[] values = AdvancedOptions.values();
        Random random = new Random();

        AdvancedOptions computerChoice = values[random.nextInt(values.length)];

        game.setComputerChoice(computerChoice.toString());

        game.setResult(checkWinner(computerChoice.getValue(), play.getPlayerChoice().getValue(), values.length));
        return game;
    }

    public String checkWinner(int computerChoice, int playerChoice, int nrOfChoices) {
        if (computerChoice == 1 && playerChoice == nrOfChoices) {
            return "Lose";
        } else if (playerChoice == 1 && computerChoice == nrOfChoices) {
            return "Win";
        } else if (computerChoice < playerChoice) {
            return "Win";
        } else if (computerChoice == playerChoice) {
            return "Draw";
        } else {
            return "Lose";
        }
    }
}
