package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();
        gameManager.init();

        while (!gameManager.play()){
            System.out.println();
        }

        gameManager.gameEnd();
    }
}
