package racingcar;

public class GameManager {

    static Car [] cars;

    public void setup(String inputs){
        String [] users = inputs.split(",");
        cars = new Car[users.length];
        for (int i=0;i<users.length;i++){
            cars[i] = new Car(users[i]);
        }
    }
}
