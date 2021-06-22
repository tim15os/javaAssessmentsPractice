package zt.ss1_10;

public class Employee {
    int id,age;
    String department;
    String name;
    double salary;

    Employee(String name2, int age2){
        this(name2,age2,0.0,0,null);
    }

    Employee(String name3, int age3, double salary3){
        this(name3,age3,salary3,0,null);
    }

    Employee(String name4, int age4, double salary4, int id4){
        this(name4,age4,salary4,id4,null);
    }

    Employee(String name5, int age5, double salary5, int id5, String department5){
        name=name5;
        age=age5;
        id=id5;
        salary=salary5;
        department=department5;
    }

    double enlargeSalary(){ return salary*2;}
}

class TestEmployee{
    public static void main(String[] args) {
        Employee employee = new Employee("John", 32, 110000, 01, "IT");
        Employee employee2 = new Employee("Mark", 43, 240000, 02, "IT");
        System.out.println(employee.enlargeSalary());
        System.out.println(employee2.enlargeSalary());
    }
}
