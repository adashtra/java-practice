package com.codewars.katas;

import java.util.*;
import java.util.stream.Collectors;

public class Kata {
    public static String driver(final String[] data) {

        List<String> surname = Collections.singletonList(data[2]);

        List<String> birthDate = Collections.singletonList(data[3]);

        List<String> gender = Collections.singletonList(data[4]);

        Map<String, String> months = new HashMap<String, String>();
        months.put("01", "Jan");
        months.put("09", "Sep");
        months.put("12", "Dec");


        // LAST NAME (not finished)
        String firstFiveCharsOfSurname = surname.stream()
                .filter(name -> name.length() >= 5)
                .map(name -> name.toUpperCase(Locale.ROOT))
                .map(Object::toString)
                .collect(Collectors.joining());

        // DECADE DIGIT (done)
        String decadeDigit = birthDate.stream()
                .map(element -> element.substring(9, 10))
                .map(Objects::toString)
                .collect(Collectors.joining());

        // MONTH OF BIRTH (words) in a list
//        List<String> birthMonth = birthDate.stream()
//                .map(element -> element.substring(3, 6))
//                .collect(Collectors.toList());

        String birthMonth = birthDate.stream()
                .map(element -> element.substring(3, 6))
                .map(Objects::toString)
                .collect(Collectors.joining());

        // MONTH OF BIRTH (digits). need to add 50 if female
        String birthMonthNumber = months.entrySet()
                .stream()
                .filter(element -> element.getValue().equals(birthMonth))
                .map(Map.Entry::getKey)
                .map(Objects::toString)
                .collect(Collectors.joining());

        System.out.println(birthMonthNumber);


        //        Original stream
//        return Arrays.stream(data)
//                .skip(2)
//                .findFirst()
//                .map(element -> element.substring(0, 5))
//                .stream()
//                .map(i -> i.toUpperCase(Locale.ROOT))
//                .collect(Collectors.joining());
        return firstFiveCharsOfSurname + decadeDigit + birthMonthNumber;
    }
}

// "John",    "James",  "Smith", "01-Jan-2000",       "M"
// "SMITH001010JJ9AA"