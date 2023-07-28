public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.ssn);

        Counter.increment();
        System.out.println(Counter.count);
    }
}
