package com.co.lindadev14.streamapitutorial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private Integer age;

}
