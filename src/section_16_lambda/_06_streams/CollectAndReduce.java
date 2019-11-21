package section_16_lambda._06_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectAndReduce {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

//        for (Department department : departments) {
//            System.out.println("Department " + department.getName() + ":");
//            for (Employee employee : department.getEmployees()) {
//                System.out.println(employee);
//            }
//            System.out.println();
//        }

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36", "B12", "B6", "G53", "G49", "G60", "g64", "G50", "I26", "I17", "I29", "O71"
        );

        System.out.println("\nCollected bingo numbers:");
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

//        for (String s : sortedGNumbers)  {
//            System.out.print(s + " ");
//        }

        sortedGNumbers.forEach(s -> System.out.print(" " + s));
        System.out.println();

        System.out.println("Collected bingo numbers with the collect function with more arguments:");
        sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                // First: a supplier, second: an accumulator, third: a combiner
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        sortedGNumbers.forEach(s -> System.out.print(" " + s));
        System.out.println();

        System.out.print("Reducing the list to the youngest employee: ");
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        // Stream operations are lazily evaluated, nothing happens until there's a terminal operation
        Stream.of("ABC", "AC", "BAA", "CCC")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                }) // It doesn't write the strings unless a terminal operation is added.
                .count();
    }

}