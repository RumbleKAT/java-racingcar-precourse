package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }
    public int getCarsSize(){
        return this.cars.size();
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
        StringBuilder winner = new StringBuilder();
        for(int i=0;i<cars.size();i++){
            winner.append(cars.get(i).getName());
            if(i < cars.size()-1){
                winner.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + winner);
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
