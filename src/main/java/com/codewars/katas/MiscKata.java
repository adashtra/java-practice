package com.codewars.katas;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class MiscKata {

    //    Link to kata: https://www.codewars.com/kata/57eadb7ecd143f4c9c0000a3/train/java
    public static String abbrevName(String name) {
        String[] arr = name.split(" ");
        String initials = Arrays.stream(arr)
                .map(element -> element.substring(0, 1).toUpperCase(Locale.ROOT))
                .map(Objects::toString)
                .collect(Collectors.joining("."));
        return initials;
    }
}
