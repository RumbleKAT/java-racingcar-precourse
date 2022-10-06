package racingcar;

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

    public void showWinners(int count){
        List<Car> winners = getWinners(count);
        StringBuilder result = new StringBuilder();
        for(int i=0;i<winners.size();i++){
            result.append(winners.get(i).getName());
            if(i < cars.size()-1){
                result.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + result);
    }

    public void showScore(){
        for(Car car : cars){
            System.out.println(car.getName() + " : " + getScore(car.getMovement()));
        }
    }

    public String getScore(int score){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<score;i++){
            sb.append("-");
        }
        return sb.toString();
    }
}
