package com.codewars.katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    @Test
    public void basicTests()
    {
        assertEquals("SMITH001010JJ9AA", Kata.driver(new String[]{"John",    "James",  "Smith", "01-Jan-2000",       "M"}));
        assertEquals("GIBBS862131J99AA", Kata.driver(new String[]{"Johanna", "",       "Gibbs", "13-Dec-1981",       "F"}));
        assertEquals("LEE99809021AR9AA", Kata.driver(new String[]{"Andrew",  "Robert", "Lee",   "02-September-1981", "M"}));
    }

}