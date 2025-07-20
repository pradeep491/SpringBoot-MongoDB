import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AscAndDescbyBoth {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Jane", 60000));
        employees.add(new Employee("Jack", 40000));

        List<Employee> list = employees.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Comparator.comparingDouble(Employee::getSalary)))
                .toList();
        System.out.println("comparing by both Salary and Name...!");
        list.forEach(System.out::println);
        System.out.println("==================================");
        List<Employee> list1 = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
        list1.forEach(System.out::println);
    }
}
