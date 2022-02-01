package com.pham.rockpaperscissors.model;

import javax.validation.Valid;

import com.pham.rockpaperscissors.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping(path = "/basic", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public Game playerChoiceAdvanced(@Valid @RequestBody PlayOptionsBasicDTO play) {

        Game game = gameService.createGame(play);
        return game;
    }

    @PostMapping(path = "/advanced", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public Game playerChoiceAdvanced(@Valid @RequestBody PlayOptionsAdvancedDTO play) {
        Game game = gameService.createGame(play);
        return game;
    }

}
