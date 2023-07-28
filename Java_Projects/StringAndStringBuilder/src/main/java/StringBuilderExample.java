public class StringBuilderExample {
    public static void main (String[] args) {
        StringBuilder strbuild1 = new StringBuilder("Meow");
        StringBuilder strbuild2 = new StringBuilder("Woof");

        System.out.println(strbuild1.toString().equals(strbuild2.toString()));

        strbuild1.append(strbuild2);
        System.out.println(strbuild1);

        strbuild1.reverse();
        System.out.println(strbuild1);

    }
}
