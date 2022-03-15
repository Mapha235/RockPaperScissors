package com.pham.rockpaperscissors.controller;

import javax.validation.Valid;

import com.pham.rockpaperscissors.model.Game;
import com.pham.rockpaperscissors.model.PlayOptionsAdvancedDTO;
import com.pham.rockpaperscissors.model.PlayOptionsBasicDTO;
import com.pham.rockpaperscissors.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public Game playerChoiceAdvanced(@Valid @RequestBody PlayOptionsBasicDTO play) {
        Game game = gameService.createGame(play);
        return game;
    }

    @PostMapping(path = "/advanced", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseBody
    public Game playerChoiceAdvanced(@Valid @RequestBody PlayOptionsAdvancedDTO play) {
        Game game = gameService.createGame(play);
        return game;
    }

}
