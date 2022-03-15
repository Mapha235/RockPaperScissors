package com.pham.rockpaperscissors.rockpaperscissors;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pham.rockpaperscissors.constants.BasicOptions;
import com.pham.rockpaperscissors.controller.GameController;
import com.pham.rockpaperscissors.model.Game;
import com.pham.rockpaperscissors.model.PlayOptionsAdvancedDTO;
import com.pham.rockpaperscissors.model.PlayOptionsBasicDTO;
import com.pham.rockpaperscissors.service.GameService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = GameController.class)
public class GameControllerTest {

    @MockBean
    private GameService service;

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    @DisplayName("Should")
    public void shouldReturnJsonResponse() throws Exception{
        Game game = new Game();
        game.setComputerChoice("ROCK");
        game.setPlayerChoice("PAPER");
        game.setGameMode("Basic");
        game.setResult("Win");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = writer.writeValueAsString(game);


        this.mockMvc.perform(post("/basic")
							.contentType(MediaType.APPLICATION_JSON)
                            .content(requestJson)
							.accept(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk());
    }
}
