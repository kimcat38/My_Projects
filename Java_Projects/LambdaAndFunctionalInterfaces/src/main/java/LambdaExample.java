import static java.lang.Math.max;

public class LambdaExample {
    public static void main(String[] args) {
        NumericOperator addition = (a, b) -> a + b;

        int sum = addition.operate(3, 6);
        System.out.println(sum);

        NumericOperator max = (a, b) -> max(a,b);
        int maxInt = max.operate(1,8);
        System.out.println(maxInt);

        StringFormatter uppercase = input -> input.toUpperCase();
        String uppercaseStr = uppercase.format("meow");
        System.out.println(uppercaseStr);

    }
}
