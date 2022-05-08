package com.co.lindadev14.streamapitutorial;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterExample {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Lina", "Mateo", "Pablo", "Juan");

        // forEach
        for (String name : names){
            if(!name.equals("Lina")){
                System.out.println(name);
            }
        }

        names.stream()
                .filter(FilterExample::isNotLina)
                .forEach(System.out::println);
    }

    private static boolean isNotLina(String name) {
        return !name.equals("Lina");
    }
}
