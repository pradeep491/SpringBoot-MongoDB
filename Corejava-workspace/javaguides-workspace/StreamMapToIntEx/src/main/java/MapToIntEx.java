import java.util.stream.Stream;

public class MapToIntEx {
    public static void main(String[] args) {
        // Stream of strings representing numerical values
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");
        // Converting string values to integers and calculating their sum
        int sum = stringStream.mapToInt(Integer::parseInt).sum();
        System.out.println("Sum of all numbers: " + sum);
    }
}
