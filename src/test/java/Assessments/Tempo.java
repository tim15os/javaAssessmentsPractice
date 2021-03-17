package Assessments;

import java.util.*;

class Car {

    public  String color;
    public Car(String color){
        this.color = color;
    }


    @Override
    public String toString() {
        return
                "color='" + color + '\'';
    }

    public static void main(String[] args) {
        Car blueCar = new Car("blue");
        Car greenCar1 = new Car("green");
        Car yellowCar = new Car("yellow");
        Car greenCar = new Car("green");
        List<Car> carList = new ArrayList<Car>();

        carList.add(blueCar);
        carList.add(greenCar1);
        carList.add(greenCar);
        carList.add(yellowCar);
        System.out.println(carsByColor(carList));
    }

    public static Map<String, List<Car>> carsByColor(List<Car> carList){
        Map<String, List<Car>> map = new HashMap<>();
        for(Car c : carList){
            if(!map.containsKey(c.color))
                map.put(c.color, new ArrayList<>());
            map.get(c.color).add(c);
        }
        return map;
    }




}


