package com.codewars.katas;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Kata {
    public static String driver(final String[] data) {
        return Arrays.stream(data)
                .skip(2)
                .findFirst()
                .map(element -> element.substring(0, 5))
                .stream()
                .map(i -> i.toUpperCase(Locale.ROOT))
                .collect(Collectors.joining());
    }
}

// "John",    "James",  "Smith", "01-Jan-2000",       "M"
// "SMITH001010JJ9AA"