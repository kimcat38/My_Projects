import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,3,6,5,8,8);
        List<Integer>  oddNums = intList.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n ).collect(Collectors.toList());
        System.out.println(oddNums);


    }
}
