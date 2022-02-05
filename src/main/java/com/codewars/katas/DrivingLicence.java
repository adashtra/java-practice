package com.codewars.katas;

import java.util.*;
import java.util.stream.Collectors;

// Link to Kata: https://www.codewars.com/kata/586a1af1c66d18ad81000134/train/java

public class DrivingLicence {
    public static String driver(final String[] data) {

        final String firstName = data[0];

        StringBuilder middleName = new StringBuilder(data[1]);

        StringBuilder surname = new StringBuilder(data[2]);

        List<String> birthDate = Collections.singletonList(data[3]);

        final String gender = data[4];

        Map<String, String> months = new HashMap<>();
        months.put("01", "Jan");
        months.put("02", "Feb");
        months.put("03", "Mar");
        months.put("04", "Apr");
        months.put("05", "May");
        months.put("06", "Jun");
        months.put("07", "Jul");
        months.put("08", "Aug");
        months.put("09", "Sep");
        months.put("10", "Oct");
        months.put("11", "Nov");
        months.put("12", "Dec");

        final String arbitraryDigit = "9";

        final String computerCheck = "AA";

        while (surname.length() < 5) {
            surname.append(arbitraryDigit);
        }

        String firstFiveCharsOfSurname = surname.substring(0, 5).toUpperCase(Locale.ROOT);

        String decadeDigit = birthDate.stream()
                .map(element -> element.charAt(element.length() - 2))
                .map(Objects::toString)
                .collect(Collectors.joining());

        String birthMonth = birthDate.stream()
                .map(element -> element.substring(3, 6))
                .map(Objects::toString)
                .collect(Collectors.joining());

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

        String birthDay = birthDate.stream()
                .map(element -> element.substring(0, 2))
                .map(Objects::toString)
                .collect(Collectors.joining());

        String yearDigit = birthDate.stream()
                .map(element -> element.charAt(element.length() - 1))
                .map(Objects::toString)
                .collect(Collectors.joining());

        String firstInitial = firstName.substring(0, 1);

        if (middleName.length() < 1) {
            middleName.insert(0, arbitraryDigit);
        }

        String middleInitial = middleName.substring(0, 1);

        return firstFiveCharsOfSurname + decadeDigit + birthMonthDigits + birthDay + yearDigit + firstInitial + middleInitial + arbitraryDigit + computerCheck;
    }
}