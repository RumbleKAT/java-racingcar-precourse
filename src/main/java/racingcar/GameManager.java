package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    //TODO: 일급 컬렉션 만들기 Cars 사용하기 https://velog.io/@seongwon97/%EC%9D%BC%EA%B8%89-%EC%BB%AC%EB%A0%89%EC%85%98%EC%9D%B4%EB%9E%80
    private Car [] cars;
    private int count;

    public void setup(String [] inputs, int count){
        this.cars = new Car[inputs.length];
        for (int i=0;i<inputs.length;i++){
            this.cars[i] = new Car(inputs[i]);
        }
        this.count = count;
    }

    public void init(){
        String [] inputs = getCars();
        int counts = getCount();
        setup(inputs, counts);
    }

    public String [] getCars(){
        boolean isFlg;
        String [] cars;
        do{
            isFlg = false;
            cars = Console.readLine().split(",");
            try{
                for(String car : cars){
                    if(car.length() >= 6) throw new IllegalArgumentException();
                }
            }catch (IllegalArgumentException exception){
                System.out.println("[ERROR] car name's length cannot be over 6 characters");
                isFlg = true;
            }
        }while (isFlg);
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
        List<Car> cars = getWinners();
        StringBuilder winner = new StringBuilder();
        for(int i=0;i<cars.size();i++){
            winner.append(cars.get(i).getName());
            if(i < cars.size()-1){
                winner.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + winner);
    }


    public List<Car> getWinners(){
        List<Car> list = new ArrayList<>();
        for(Car car : cars){
            if(car.getMovement() == this.count){
                list.add(car);
            }
        }
        return list;
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

    public boolean play(){
        boolean isEnd = false;
        for (Car car : this.cars) {
            if(isGameOver()) isEnd = true;
            car.setMovement(moveForward() + car.getMovement());
        }
        showScore();
        return isEnd;
    }

    public int moveForward(){
        return Randoms.pickNumberInRange(0,9) >= 4 ? 1 : 0; //
    }
    public boolean isGameOver(){
        for(Car car : cars){
            if(car.getMovement() == count) return true;
        }
        return false;
    }

}
