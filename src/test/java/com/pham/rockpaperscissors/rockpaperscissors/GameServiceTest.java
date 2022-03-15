package com.pham.rockpaperscissors.rockpaperscissors;

import java.util.stream.Stream;

import com.pham.rockpaperscissors.constants.AdvancedOptions;
import com.pham.rockpaperscissors.constants.BasicOptions;
import com.pham.rockpaperscissors.service.GameService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameServiceTest {

    // cartesian product of the game's options in basic mode
    private static Stream<Arguments> provideParametersBasic() {
        return Stream.of(
                Arguments.of(BasicOptions.SCISSORS, BasicOptions.SCISSORS),
                Arguments.of(BasicOptions.SCISSORS, BasicOptions.ROCK),
                Arguments.of(BasicOptions.SCISSORS, BasicOptions.PAPER),
                Arguments.of(BasicOptions.ROCK, BasicOptions.SCISSORS),
                Arguments.of(BasicOptions.ROCK, BasicOptions.ROCK),
                Arguments.of(BasicOptions.ROCK, BasicOptions.PAPER),
                Arguments.of(BasicOptions.PAPER, BasicOptions.SCISSORS),
                Arguments.of(BasicOptions.PAPER, BasicOptions.ROCK),
                Arguments.of(BasicOptions.PAPER, BasicOptions.PAPER)
                );
    }

    // cartesian product of the game's options in advanced mode
    private static Stream<Arguments> provideParametersAdvanced() {
        return Stream.of(
                Arguments.of(AdvancedOptions.SCISSORS, AdvancedOptions.SCISSORS),
                Arguments.of(AdvancedOptions.SCISSORS, AdvancedOptions.ROCK),
                Arguments.of(AdvancedOptions.SCISSORS, AdvancedOptions.WELL),
                Arguments.of(AdvancedOptions.SCISSORS, AdvancedOptions.PAPER),
                Arguments.of(AdvancedOptions.ROCK, AdvancedOptions.SCISSORS),
                Arguments.of(AdvancedOptions.ROCK, AdvancedOptions.ROCK),
                Arguments.of(AdvancedOptions.ROCK, AdvancedOptions.WELL),
                Arguments.of(AdvancedOptions.ROCK, AdvancedOptions.PAPER),
                Arguments.of(AdvancedOptions.WELL, AdvancedOptions.SCISSORS),
                Arguments.of(AdvancedOptions.WELL, AdvancedOptions.ROCK),
                Arguments.of(AdvancedOptions.WELL, AdvancedOptions.WELL),
                Arguments.of(AdvancedOptions.WELL, AdvancedOptions.PAPER),
                Arguments.of(AdvancedOptions.PAPER, AdvancedOptions.SCISSORS),
                Arguments.of(AdvancedOptions.PAPER, AdvancedOptions.ROCK),
                Arguments.of(AdvancedOptions.PAPER, AdvancedOptions.WELL),
                Arguments.of(AdvancedOptions.PAPER, AdvancedOptions.PAPER)
                );
    }

    @ParameterizedTest
    @MethodSource("provideParametersBasic")
    void checkOutcomeBasicMode(BasicOptions computerChoice, BasicOptions playerChoice) throws Exception {
        GameService gameService = new GameService();
        int numberOfChoices = BasicOptions.values().length;
        String expectedOutcome = "";

        switch (playerChoice.getValue()) {
            case 1:
                switch (computerChoice.getValue()) {
                    case 1:
                        expectedOutcome = "Draw";
                        break;
                    case 2:
                        expectedOutcome = "Lose";
                        break;
                    case 3:
                        expectedOutcome = "Win";
                        break;
                }
                break;
            case 2:
                switch (computerChoice.getValue()) {
                    case 1:
                        expectedOutcome = "Win";
                        break;
                    case 2:
                        expectedOutcome = "Draw";
                        break;
                    case 3:
                        expectedOutcome = "Lose";
                        break;
                }
                break;
            case 3:
                switch (computerChoice.getValue()) {
                    case 1:
                        expectedOutcome = "Lose";
                        break;
                    case 2:
                        expectedOutcome = "Win";
                        break;
                    case 3:
                        expectedOutcome = "Draw";
                        break;
                }
                break;
        }

        Assertions.assertTrue(gameService.checkWinner(computerChoice.getValue(), playerChoice.getValue(),
                numberOfChoices) == expectedOutcome);
    }

    @ParameterizedTest
    @MethodSource("provideParametersAdvanced")
    void checkOutcomeAdvancedMode(AdvancedOptions computerChoice, AdvancedOptions playerChoice) throws Exception {
        GameService gameService = new GameService();
        int numberOfChoices = AdvancedOptions.values().length;
        String expectedOutcome = "";

        switch (playerChoice.getValue()) {
            case 1:
                switch (computerChoice.getValue()) {
                    case 1:
                        expectedOutcome = "Draw";
                        break;
                    case 2:
                        expectedOutcome = "Lose";
                        break;
                    case 3:
                        expectedOutcome = "Lose";
                        break;
                    case 4:
                        expectedOutcome = "Win";
                        break;
                }
                break;
            case 2:
                switch (computerChoice.getValue()) {
                    case 1:
                        expectedOutcome = "Win";
                        break;
                    case 2:
                        expectedOutcome = "Draw";
                        break;
                    case 3:
                        expectedOutcome = "Lose";
                        break;
                    case 4:
                        expectedOutcome = "Lose";
                        break;
                }
                break;
            case 3:
                switch (computerChoice.getValue()) {
                    case 1:
                        expectedOutcome = "Win";
                        break;
                    case 2:
                        expectedOutcome = "Win";
                        break;
                    case 3:
                        expectedOutcome = "Draw";
                        break;
                    case 4:
                        expectedOutcome = "Lose";
                        break;
                }
                break;
            case 4:
                switch (computerChoice.getValue()) {
                    case 1:
                        expectedOutcome = "Lose";
                        break;
                    case 2:
                        expectedOutcome = "Win";
                        break;
                    case 3:
                        expectedOutcome = "Win";
                        break;
                    case 4:
                        expectedOutcome = "Draw";
                        break;
                }
                break;
        }

        Assertions.assertTrue(gameService.checkWinner(computerChoice.getValue(), playerChoice.getValue(),
                numberOfChoices) == expectedOutcome);
    }
}
