package racingcar;

public class GameManager {

    private Car [] cars;

    public void setup(String inputs){
        String [] users = inputs.split(",");
        this.cars = new Car[users.length];
        for (int i=0;i<users.length;i++){
            this.cars[i] = new Car(users[i]);
        }
    }

    public void setCarMovement(int index, int movement){
        cars[index].setMovement(cars[index].getMovement()+movement);
    }
}
