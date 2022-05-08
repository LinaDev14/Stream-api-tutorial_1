package com.co.lindadev14.streamapitutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiTutorialApplication {

    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(
                new Employee("Lina", "Guerrero", 680.0, List.of("Hello", "Kitty", "Sunday", "Bye"))
        );
        employees.add(
                new Employee("Mateo", "Vlad", 1000.0, List.of("Hello_1", "Kitty_2", "Sunday_3", "Bye_4"))
        );
        employees.add(
                new Employee("Santiago", "De la pava", 980.0, List.of("Project_1", "Project_2"))
        );
        employees.add(
                new Employee("Camila", "Montes", 580.0, List.of("Sunday", "Bye"))
        );
    }

    public static void main(String[] args) {

        //SpringApplication.run(StreamApiTutorialApplication.class, args);

        // foreach
        employees.forEach(System.out::println);

        // map
        // collect
        employees.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // filter
        employees.stream()
                .filter(employee -> employee.getSalary() > 500.0)
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // findFirst
        List<Employee> firstEmployee =
                Collections.singletonList(employees
                        .stream()
                        .filter(employee -> employee.getSalary() > 800.0)
                        .map(employee -> new Employee(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary() * 1.10,
                                employee.getProjects()
                        ))
                        .findFirst()
                        .orElse(null));
        System.out.println(firstEmployee);

        // flapMap
        String projects =
        employees.stream()
                .map(Employee::getProjects)
                .flatMap(Collection::stream)
                .collect(Collectors.joining(" , "));
        System.out.println("projects = " + projects);

        // Short Circuit operations
        employees.stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // Finite Data
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // sorting
        employees.stream()
                .sorted((o1, o2) -> o1.getFirstName()
                        .compareToIgnoreCase(o2.getFirstName()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // min or max value
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        // reduce
        Double
        totalSalary =
        employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("totalSalary = " + totalSalary);
    }

}
