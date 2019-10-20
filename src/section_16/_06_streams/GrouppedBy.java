package section_16._06_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrouppedBy {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Little Red Riding Hood", 22);
        Employee prince = new Employee("Prince Charming", 30);
        Employee king = new Employee("Old King", 40);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);
        accounting.addEmployee(red);
        accounting.addEmployee(prince);
        accounting.addEmployee(king);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        System.out.println("Collect the employees grouped by age:");
        Map<Integer, List<Employee>> groupedByAge = departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        for (Integer age : groupedByAge.keySet()) {
            System.out.println(age + ":");
            System.out.print("\t");
            for (Employee employee : groupedByAge.get(age)) {
                System.out.print(employee + ", ");
            }
            System.out.println();
        }
    }

}
