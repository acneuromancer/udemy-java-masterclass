package section_16_lambda._05_functionalinterface.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Riding Hood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        System.out.println("Employees:");
        System.out.println("==========");
        employees.forEach(employee -> {
            System.out.print(employee.getName() + " " + employee.getAge() + "\n");
        });

//        System.out.println("\nEmployees over 30:");
//        System.out.println("=================");
//        for (Employee employee : employees) {
//            if (employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        }
//
//        employees.forEach(employee -> {
//            if (employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        });
//
//
//        System.out.println("\nEmployees 30 and younger:");
//        System.out.println("\n========================");
//        employees.forEach(employee -> {
//            if (employee.getAge() <= 30) {
//                System.out.println(employee.getName());
//            }
//        });

        printEmployeesByAge(employees, "\nEmployees over 30", employee -> employee.getAge() > 30);

        printEmployeesByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);

        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        System.out.println("\n" + greaterThan15.test(10));

        int a = 20;
        System.out.println("\n" + greaterThan15.test(a + 5));

        IntPredicate lessThan100 = i -> i < 100;
        System.out.println("\n" + greaterThan15.and(lessThan100).test(50));

        System.out.println("\n" + greaterThan15.and(lessThan100).test(15));
    }

    public static void printEmployeesByAge(List<Employee> employees,
                                           String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("=================");

        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }

}
