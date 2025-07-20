import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;

public class EvenAndOddNumberEx {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

        Map<Boolean, List<Integer>> map = listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));

        Set<Map.Entry<Boolean, List<Integer>>> set = map.entrySet();
        for (Map.Entry<Boolean, List<Integer>> entry : set) {
            System.out.println("========================");
            if (entry.getKey()) {
                System.out.println("Even Numbers...!");
            } else {
                System.out.println("Odd Numbers...!");
            }
            System.out.println("========================");
            List<Integer> list = entry.getValue();
            //entry.getValue().stream().forEach(System.out::println);
            list.stream().forEach(System.out::println);
        }
    }
}
