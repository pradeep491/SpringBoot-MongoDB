import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeByNameAsc {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Jane", 60000));
        employees.add(new Employee("Jack", 40000));

        List<Employee> list = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();

        System.out.println("Sorted by name ascending...!");
        list.forEach(System.out::println);

        List<Employee> list1= employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .toList();

        System.out.println("Sorted by name descending...!");
        list1.forEach(System.out::println);
    }
}
