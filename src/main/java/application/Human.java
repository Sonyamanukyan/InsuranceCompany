package application;

import org.springframework.beans.factory.annotation.Autowired;

public class Human {

    private int age;
    private Car car;

    public Human(Car car) {
        this.car = car;
    }

    public void move() {
        car.startEngine();
    }

    public static void main(String[] args) {
        System.out.println("age = " + new Human(new Car()).age);
        new Human(new Car()).move();
    }
}
