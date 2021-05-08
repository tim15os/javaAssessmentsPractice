package ZT.SS5;

public class Human {
    String name;
    Car car;
    BankAccount bA;
    void info(){
        System.out.println("Name: "+name+"\n"+"Car color: "+car.color+"\n"+"Bank Account Balance: "+bA.balance);
    }

}

class HumanTest{
    public static void main(String[] args) {
        Human h = new Human();
        h.name = "David";
        h.car = new Car("White", "V6");
        h.bA = new BankAccount(101, 54000.99);
        h.info();
    }
}


class Car {
    Car(String c, String e){
        color = c;
        engine = e;
    }
    String color;
    String engine;
}

class BankAccount{
    BankAccount(int id2, double balance2){
        id = id2;
        balance = balance2;
    }
    int id;
    double balance;
}

