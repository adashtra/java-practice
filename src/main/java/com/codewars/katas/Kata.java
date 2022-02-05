package com.codewars.katas;

import java.util.*;
import java.util.stream.Collectors;

public class Kata {
    public static String driver(final String[] data) {

        List<String> firstName = Collections.singletonList(data[0]);

        StringBuilder middleName = new StringBuilder(data[1]);

        List<String> surname = Collections.singletonList(data[2]);

        List<String> birthDate = Collections.singletonList(data[3]);

        List<String> gender = Collections.singletonList(data[4]);

        String padding = "9";

        Map<String, String> months = new HashMap<>();
        months.put("01", "Jan");
        months.put("09", "Sep");
        months.put("12", "Dec");

        final String arbitraryDigit = "9";

        final String computerCheck = "AA";

        // LAST NAME
        StringBuilder firstFiveCharsOfSurname = new StringBuilder(surname.stream()
                .filter(name -> name.length() <= 5)
                .map(name -> name.toUpperCase(Locale.ROOT))
                .map(Object::toString)
                .collect(Collectors.joining()));

        while (firstFiveCharsOfSurname.length() < 5) {
            firstFiveCharsOfSurname.append(padding);
        }

        // DECADE DIGIT
        String decadeDigit = birthDate.stream()
                .map(element -> element.charAt(element.length() -2))
                .map(Objects::toString)
                .collect(Collectors.joining());

        // BIRTH MONTH
        String birthMonth = birthDate.stream()
                .map(element -> element.substring(3, 6))
                .map(Objects::toString)
                .collect(Collectors.joining());

        // MONTH OF BIRTH
        String birthMonthDigits = months.entrySet()
                .stream()
                .filter(element -> element.getValue().equals(birthMonth))
                .map(Map.Entry::getKey)
                .map(Objects::toString)
                .collect(Collectors.joining());

        if (gender.contains("F")) {
            if (birthMonthDigits.startsWith("1")) {
                birthMonthDigits = birthMonthDigits.replaceFirst("1", "6");
            } else {
                birthMonthDigits = birthMonthDigits.replaceFirst("0", "5");
            }
        }

        //  DAY OF BIRTH
        String birthDay = birthDate.stream()
                .map(element -> element.substring(0,2))
                .map(Objects::toString)
                .collect(Collectors.joining());

        // YEAR DIGIT
        String yearDigit = birthDate.stream()
                .map(element -> element.charAt(element.length() -1))
                .map(Objects::toString)
                .collect(Collectors.joining());

        // FIRST INITIAL
        String firstInitial = firstName.stream()
                .map(element -> element.substring(0,1))
                .map(Objects::toString)
                .collect(Collectors.joining());

        // MIDDLE INITIAL
        if (middleName.length() < 1) {
            middleName.insert(0, padding);
        }

        String middleInitial = middleName.substring(0,1);

        // RETURN STATEMENT
        return firstFiveCharsOfSurname + decadeDigit + birthMonthDigits + birthDay + yearDigit + firstInitial + middleInitial + arbitraryDigit + computerCheck;
    }
}