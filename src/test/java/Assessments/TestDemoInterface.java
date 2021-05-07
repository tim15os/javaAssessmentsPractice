package Assessments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class TestDemoInterface {

    public static void main(String[] args) {
        List<Car> carList = createCarList();
        Map<String, List<Car>> carMap = new HashMap<>();
        for(Car c : carList) {
            List<Car> existingCarList = carMap.get(c.color);
            if(existingCarList != null) {
                // the value exists
                existingCarList.add(c);
                carMap.put(c.color, existingCarList);
            } else {
                // the value doesn't exist
                existingCarList = new ArrayList<>();
                existingCarList.add(c);
                carMap.put(c.color, existingCarList);
            }
        }
        System.out.println(carMap);
    }


    public static List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        Car c1 = new Car("blue");
        Car c2 = new Car("yellow");
        Car c3 = new Car("green");
        Car c4 = new Car("blue");
        carList.add(c1);
        carList.add(c2);
        carList.add(c3);
        carList.add(c4);
        return carList;
    }
}

class Car {
    // fields
    String color;
    // constructor
    Car(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "This is a " + this.color + " car";
    }

}