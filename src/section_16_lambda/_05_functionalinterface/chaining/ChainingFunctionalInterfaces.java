package section_16_lambda._05_functionalinterface.chaining;

import section_16_lambda._05_functionalinterface.predicate.Employee;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class ChainingFunctionalInterfaces {

    public static void main(String[] args) {
        Employee e1 = new Employee("John Doe", 21);
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function<Employee, String> chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(e1));


        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello World!");

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };
        String upperName = upperCase.apply(e1);
        System.out.println(concatAge.apply(upperName, e1));
    }

}