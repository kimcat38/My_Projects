public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "John";
        person.age = 21;
        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);

        Car car = new Car();
        car.model = "Audi";
        car.owner = person;
        System.out.println("Model: " + car.model);

        int number = 6;
        System.out.println("Before: " + number);
        modifyNumber(number);
        System.out.println("After: " + number);

        System.out.println("Before: " + person.name + ", " + person.age);
        modifyPerson(person);
        System.out.println("After: " +  person.name + ", " + person.age);

    }

    public static void modifyNumber(int num){
        num = num * 2;
    }

    public static void modifyPerson(Person p){
        p.name = "Jane";
        p.age = 25;
    }
}

class Person  {
    String name;
    int age;
}

class Car {
    String model;
    Person owner;
}