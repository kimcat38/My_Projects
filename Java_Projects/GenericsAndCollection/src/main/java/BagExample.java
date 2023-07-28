public class BagExample {
    public static void main(String[] args) {
        Bag<String> stringBag = new Bag<>();
        stringBag.addItem("Apple");
        stringBag.addItem("Banana");
        stringBag.removeItem("Apple");

        Bag<Integer> integerBag = new Bag<>();
        integerBag.addItem(32);
        integerBag.addItem(23);
        integerBag.removeItem(32);

    }
}
