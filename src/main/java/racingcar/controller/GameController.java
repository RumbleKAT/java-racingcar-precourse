package racingcar.controller;

import racingcar.service.GameService;

public class GameController {

    private final GameService gameService;

    public GameController(){
        gameService = new GameService();
    }

    public void playGame(){
        gameService.init();

        while (!gameService.play()){
            gameService.showScore();
        }

        gameService.gameEnd();
    }
}
