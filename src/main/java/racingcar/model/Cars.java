package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars(){
        return this.cars;
    }
    public List<Car> getWinners(int count){
        List<Car> list = new ArrayList<>();
        for(Car car : cars){
            if(car.getMovement() == count) list.add(car);
        }
        return list;
    }

    public int getCarsSize(){
        return this.cars.size();
    }
}
