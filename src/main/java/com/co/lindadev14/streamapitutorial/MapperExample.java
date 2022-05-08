package com.co.lindadev14.streamapitutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapperExample {
    public static void main(String[] args) {

        List<User> user = new ArrayList<>();

        user.add(new User("Lina", 23));
        user.add(new User("Mateo", 25));
        user.add(new User("Santiago", 28));
        user.add(new User("Camila", 22));


        user.stream()
                .map(user1 -> new User(
                        user1.getName(),
                        user1.getAge() * 2
                ))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}
