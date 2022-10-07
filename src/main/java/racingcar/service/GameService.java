package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private Cars cars;
    private int count;

    public void setup(String [] inputs, int count){
        List<Car> carList = new ArrayList<>();
        for (String input : inputs) {
            Car car = new Car(input);
            carList.add(car);
        }
        cars = new Cars(carList);
        this.count = count;
    }

    public void init(){
        String [] inputs = getCars();
        int counts = getCount();
        setup(inputs, counts);
    }

    public String [] getCars(){
        while(true){
            try{
                return inputCars();
            }catch (IllegalArgumentException exception){
                System.out.println("[ERROR] car name's length cannot be over 6 characters");
            }
        }
    }

    public String [] inputCars(){
        String [] cars = Console.readLine().split(",");
        for(String car : cars){
            if(car.length() >= 6) throw new IllegalArgumentException();
        }
        return cars;
    }

    public int getCount(){
        while(true){
            try {
                return getInputCounts();
            }catch (IllegalArgumentException exception){
                System.out.println("[ERROR] counts must be positive number");
            }
        }
    }

    public int getInputCounts(){
        int counts = Integer.parseInt(Console.readLine());
        if (counts <= 0) throw new IllegalArgumentException();
        return counts;
    }

    public void gameEnd(){
        showWinners(count);
    }

    public boolean play(){
        boolean isEnd = false;
        List<Car> nextCars = this.cars.getCars();
        for (Car car : nextCars) {
            if(car.getMovement() == count){
                isEnd = true;
                continue;
            }
            car.setMovement(moveForward() + car.getMovement());
        }
        this.cars = new Cars(nextCars);
        showScore();
        return isEnd;
    }

    public int moveForward(){
        return Randoms.pickNumberInRange(0,9) >= 4 ? 1 : 0; //
    }

    public void showScore(){
        for(Car car : cars.getCars()){
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

    public List<Car> getWinners(int count){
        List<Car> list = new ArrayList<>();
        for(Car car : cars.getCars()){
            if(car.getMovement() == count) list.add(car);
        }
        return list;
    }

    public void showWinners(int count){
        List<Car> winners = getWinners(count);
        StringBuilder result = new StringBuilder();
        for(int i=0;i<winners.size();i++){
            result.append(winners.get(i).getName());
            if(i < cars.getCarsSize()-1){
                result.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + result);
    }

}
