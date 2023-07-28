import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void  main (String[] args) {
        Box<Integer> intergerBox = new Box<>();
        intergerBox.setContent(43);

        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
    }
}
